package topcoder.chapter08.stock.history.bro;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/** * Created with Intellij IDEA_17.
 * Date: 2017-07-31
 * Time: 오전 12:17
 * cou-topcoder-study
 * for
 */
public class StockHistoryTest {
	private StockHistory stockHistory;

	@Before
	public void setUp() throws Exception {
		stockHistory = new StockHistory();
	}

	@Test
	public void testExample1() throws Exception {

		int initialInvestment = 1000;
		int monthlyContribution = 0;
		String[] stockPrices = { "10 20 30","15 24 32" };

		System.out.println("## Example Input ##");
		System.out.println("initialInvestment : " + initialInvestment);
		System.out.println("monthlyContribution : " + monthlyContribution);
		System.out.println("stockPrices : " + Arrays.toString(stockPrices));

		long startTime = System.currentTimeMillis();
		long result = stockHistory.maximumEarnings(initialInvestment, monthlyContribution, stockPrices);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");

		assertEquals(500, result);
	}

	@Test
	public void testExample2() throws Exception {

		int initialInvestment = 1000;
		int monthlyContribution = 0;
		String[] stockPrices = { "10","9" };

		System.out.println("## Example Input ##");
		System.out.println("initialInvestment : " + initialInvestment);
		System.out.println("monthlyContribution : " + monthlyContribution);
		System.out.println("stockPrices : " + Arrays.toString(stockPrices));

		long startTime = System.currentTimeMillis();
		long result = stockHistory.maximumEarnings(initialInvestment, monthlyContribution, stockPrices);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");

		assertEquals(0, result);
	}

	@Test
	public void testExample3() throws Exception {
	
		int initialInvestment = 100;
		int monthlyContribution = 20;
		String[] stockPrices ={
			"40 50 60",
			"37 48 55",
			"100 48 50",
			"105 48 47",
			"110 50 52",
			"110 50 52",
			"110 51 54",
			"109 49 53",
		};

		System.out.println("## Example Input ##");
		System.out.println("initialInvestment : " + initialInvestment);
		System.out.println("monthlyContribution : " + monthlyContribution);
		System.out.println("stockPrices : " + Arrays.toString(stockPrices));

		long startTime = System.currentTimeMillis();
		long result = stockHistory.maximumEarnings(initialInvestment, monthlyContribution, stockPrices);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");

		assertEquals(239, result);
	}
}