package topcoder.chapter08.stock.history.bro;

/** * Created with Intellij IDEA_17.
 * Date: 2017-07-31
 * Time: 오전 12:03
 * cou-topcoder-study
 * for
 */
public class StockHistory {

	private static final int THE_TRICKSTER = -1;

	private static final int MAX_INVESTMENT = 10000;
	private static final int MAX_CONTRIBUTION = 1000;

	private static final int INTEGER_ZERO = 0;

	public int maximumEarnings(int initialInvestment, int monthlyContribution, String[] stockPrices) {
		if (this.isInvalidInput(initialInvestment, monthlyContribution)) {
			return THE_TRICKSTER;
		}

		int companyCount = stockPrices[INTEGER_ZERO].split(" ").length;
		int[][] stockPricesIntArr = new int[stockPrices.length][companyCount];
		if (!this.convertIntegerArray(stockPrices, stockPricesIntArr)) {
			return THE_TRICKSTER;
		}

		Double[] monthlyMaxProfit = this.getMonthlyMaxProfit(stockPricesIntArr);

		return this.getMaximumProfit(initialInvestment, monthlyContribution, monthlyMaxProfit);
	}

	private int getMaximumProfit(int initialInvestment, int monthlyContribution, Double[] monthlyMaxProfit) {
		double result = INTEGER_ZERO;
		int contribution = initialInvestment;
		for (double maxProfit : monthlyMaxProfit) {
			if (maxProfit > INTEGER_ZERO) {
				result += maxProfit * contribution;
				contribution = INTEGER_ZERO;
			}
			contribution += monthlyContribution;
		}

		return (int) result;
	}

	private Double[] getMonthlyMaxProfit(int[][] stockPrices) {

		double profit, maxProfit = INTEGER_ZERO;
		Double[] monthlyMaxProfit = new Double[stockPrices.length];

		for (int i = stockPrices.length-1 ; i >= INTEGER_ZERO ; i--) {
			for (int j = INTEGER_ZERO ; j < stockPrices[i].length ; j++) {
				profit = (double) stockPrices[stockPrices.length-1][j] / stockPrices[i][j] - 1;

				if (profit > INTEGER_ZERO && profit > maxProfit) {
					maxProfit = profit;
					monthlyMaxProfit[i] = maxProfit;
				} else if (monthlyMaxProfit[i] != null) {
					monthlyMaxProfit[i] = (double) INTEGER_ZERO;
				}
			}
		}

		return monthlyMaxProfit;
	}

	private boolean convertIntegerArray(String[] stockPrices, int[][] convertedArr) {
		if (stockPrices.length < 2 || stockPrices.length > 50) {
			// 길이 제한 이슈로 컨버팅 실패
			return false;
		}

		int beforeLength = INTEGER_ZERO;
		for (int i = INTEGER_ZERO ; i < stockPrices.length ; i++) {
			String[] companyPrices = stockPrices[i].split(" ");

			if (beforeLength != 0 && beforeLength != companyPrices.length) {
				// 각 요소별 길이 제한 이슈로 컨버팅 실패
				return false;
			}

			for (int j = INTEGER_ZERO ; j < companyPrices.length ; j++) {
				convertedArr[i][j] = Integer.valueOf(companyPrices[j]);
			}

			beforeLength = companyPrices.length;
		}

		// converting 에 성공 했음
		return true;
	}

	private boolean isInvalidInput(int initialInvestment, int monthlyContribution) {
		return initialInvestment < INTEGER_ZERO || initialInvestment > MAX_INVESTMENT
			|| monthlyContribution < INTEGER_ZERO || monthlyContribution > MAX_CONTRIBUTION;
	}
}