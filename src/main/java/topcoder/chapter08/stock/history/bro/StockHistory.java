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
		if (this.isInvalidInput(initialInvestment, monthlyContribution)
			|| this.isInvalidPrices(stockPrices)) {
			return THE_TRICKSTER;
		}



		return INTEGER_ZERO;
	}

	private boolean isInvalidPrices(String[] stockPrices) {
		if (stockPrices.length < 2 || stockPrices.length > 50) {
			return true;
		}

		int beforeLength = INTEGER_ZERO;
		for (String eachStockPrice : stockPrices) {
			String[] monthlyStock = eachStockPrice.split(" ");

			if (beforeLength != 0 && beforeLength != monthlyStock.length) {
				return true;
			}

			for (String eachCompanyStock : monthlyStock) {
				if (Integer.valueOf(eachCompanyStock) < 1 || Integer.valueOf(eachCompanyStock) < 999) {
					return true;
				}
			}
			beforeLength = monthlyStock.length;
		}

		return false;
	}

	private boolean isInvalidInput(int initialInvestment, int monthlyContribution) {
		return initialInvestment < INTEGER_ZERO || initialInvestment > MAX_INVESTMENT
			|| monthlyContribution < INTEGER_ZERO || monthlyContribution > MAX_CONTRIBUTION;
	}
}