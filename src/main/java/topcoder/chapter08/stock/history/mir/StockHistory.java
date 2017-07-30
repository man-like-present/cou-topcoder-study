package topcoder.chapter08.stock.history.mir;

public class StockHistory {

    public int maximumEarnings(int initialInvestment, int monthlyContribution, String[] stockPrices) {
        int stock[][] = getIntegerArray(stockPrices);
        double variation[] = new double[stock.length - 1];
        for (int currentVariation = 0; currentVariation < stock.length - 1; currentVariation++) {
            double max = Double.MIN_VALUE;
            for (int selectedStock = 0; selectedStock < stock[0].length; selectedStock++) {
                double var = (double) stock[stock.length - 1][selectedStock] / stock[currentVariation][selectedStock];
                if (var > max) {
                    max = var;
                }
            }
            variation[currentVariation] = max;
        }
        for (int i = variation.length - 2; i >= 0; i--) {
            if (variation[i] < variation[i + 1]) {
                variation[i] = variation[i + 1];
            }
        }
        double result = 0.0;
        int investmentPrice = 0;
        if (variation[0] > 1) {
            result = initialInvestment * variation[0];
            investmentPrice = initialInvestment;
        }
        for (int i = 1; i < variation.length; i++) {
            if (variation[i] > 1) {
                result += monthlyContribution * variation[i];
                investmentPrice += monthlyContribution;
            }
        }
        return (int) Math.round(result - investmentPrice);
    }

    private int[][] getIntegerArray(String[] stockPrices) {
        int stock[][] = new int[stockPrices.length][];
        for (int i = 0; i < stockPrices.length; i++) {
            String[] stockPriceSplit = stockPrices[i].split(" ");
            int stockCount = stockPriceSplit.length;
            stock[i] = new int[stockCount];
            for (int stockNum = 0; stockNum < stockCount; stockNum++) {
                stock[i][stockNum] = Integer.parseInt(stockPriceSplit[stockNum]);
            }
        }
        return stock;
    }
}
