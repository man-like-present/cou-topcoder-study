package topcoder.chapter08.stock.history.bart;

import java.util.*;

public class StockHistory {

	private class Stock {
		private int[] stockPrices;
		private int tradingPrice;

		Stock(int[] stockPrices) {
			this.stockPrices = stockPrices;
			this.tradingPrice = stockPrices[stockPrices.length-1];
		}

		double yield(int currentMonth) {
			return (tradingPrice - stockPrices[currentMonth]) / (double) tradingPrice;
		}

		int getStockPrice(int month) {
			return stockPrices[month];
		}

		int getTradingPrice() {
			return tradingPrice;
		}

		double getBestYield(int currentMonth) {
			double bestInvestYield = 0;
			for (int month = currentMonth; month < stockPrices.length; month++) {
				if (stockPrices[currentMonth] >= tradingPrice)
					continue;
				double monthlyYield = yield(month);
				if (monthlyYield > bestInvestYield) {
					bestInvestYield = monthlyYield;
				}
			}
			return bestInvestYield;
		}
	}

	public int maximumEarnings(int initialInvestment, int monthlyContribution, String[] stockPrices) {
		List<Stock> stockList = buildStockList(stockPrices);
		int totalInvestment =  0;
		int currentInvestment = initialInvestment;
		Map<Stock, Double> stockInvestmentMap = new HashMap<>();

		for(int month = 0; month < stockPrices.length-1; month++) {
			if(month > 0) currentInvestment += monthlyContribution;

			Stock stock = findMonthlyBestInvestStock(stockList, month);
			if(stock == null) {
				continue;
			}

			double stockInvestment = Optional.ofNullable(stockInvestmentMap.get(stock)).orElse(0D);
			stockInvestmentMap.put(stock, stockInvestment + calcInvestmentStockAmount(stock, month, currentInvestment));
			totalInvestment += currentInvestment;
			currentInvestment = 0;
		}

		return calcTotalProfit(totalInvestment, stockInvestmentMap);
	}

	private List<Stock> buildStockList(String[] stockPrices) {
		int stockLength = stockPrices[0].split(" ").length;
		int[][] reverseStockPrices = new int[stockLength][stockPrices.length];

		for(int i = 0; i < stockPrices.length; i++) {
			String prices = stockPrices[i];
			String[] priceStream = prices.split(" ");
			for(int j = 0; j < priceStream.length; j++) {
				reverseStockPrices[j][i] = Integer.parseInt(priceStream[j]);
			}
		}

		List<Stock> stockList = new ArrayList<>();
		for (int[] reverseStockPrice : reverseStockPrices) {
			stockList.add(new Stock(reverseStockPrice));
		}

		return stockList;
	}

	private Stock findMonthlyBestInvestStock(List<Stock> stockList, int month) {
		Stock candidate = stockList.stream()
			.filter(stock -> stock.yield(month) > 0)
			.max((origin, stock)-> {
				if(origin.yield(month) > stock.yield(month)) return 1;
				else if(origin.yield(month) < stock.yield(month)) return -1;
				else return 0;
			}).orElse(null);

		if(candidate != null) {
			double candidateYield = candidate.yield(month);
			if(stockList.stream().anyMatch(stock -> stock.getBestYield(month) > candidateYield)) {
				return null;
			}
		}
		return candidate;
	}

	private double calcInvestmentStockAmount(Stock stock, int month, int investment) {
		int stockPrice = stock.getStockPrice(month);
		return investment / (double)stockPrice;
	}

	private int calcTotalProfit(int totalInvestment, Map<Stock, Double> stockInvestmentMap) {
		if(stockInvestmentMap.isEmpty()) return 0;
		double asset = stockInvestmentMap.entrySet().stream()
			.mapToDouble(entry -> {
				Stock stock = entry.getKey();
				double stockAmount = entry.getValue();
				return stock.getTradingPrice() * stockAmount;
			}).sum();

		return (int) Math.round(asset - totalInvestment);
	}
}
