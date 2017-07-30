package topcoder.chapter08.stock.history.bart;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StockHistoryTest {

    private StockHistory stockHistory;

    @Before
    public void setUp() throws Exception {
        stockHistory = new StockHistory();
    }

    @Test
    public void stockHistory_case0() throws Exception {
        long expected = 500;

        long actual = stockHistory.maximumEarnings(1000, 0, new String[] { "10 20 30","15 24 32" });

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stockHistory_case1() throws Exception {
        long expected = 0;

        long actual = stockHistory.maximumEarnings(1000, 0, new String[] { "10","9" });

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stockHistory_case2() throws Exception {
        long expected = 239;

        long actual = stockHistory.maximumEarnings(100, 20,
            new String[] {
                "40 50 60",
                "37 48 55",
                "100 48 50",
                "105 48 47",
                "110 50 52",
                "110 50 52",
                "110 51 54",
                "109 49 53",
            });

        Assert.assertEquals(expected, actual);
    }

}