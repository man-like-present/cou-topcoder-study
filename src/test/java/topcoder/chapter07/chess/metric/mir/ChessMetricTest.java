package topcoder.chapter07.chess.metric.mir;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessMetricTest {

    private ChessMetric chessMetric;

    @Before
    public void setUp() throws Exception {
        chessMetric = new ChessMetric();
    }

    @Test
    public void howMany_case0() throws Exception {
        // Given
        int size = 3;
        int[] start = new int[]{0, 0};
        int[] end = new int[]{1, 0};
        int numMoves = 1;

        long expected = 1;

        // When
        long actual = chessMetric.howMany(size, start, end, numMoves);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howMany_case1() throws Exception {
        // Given
        int size = 3;
        int[] start = new int[]{0, 0};
        int[] end = new int[]{1, 2};
        int numMoves = 1;

        long expected = 1;

        // When
        long actual = chessMetric.howMany(size, start, end, numMoves);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howMany_case2() throws Exception {
        // Given
        int size = 3;
        int[] start = new int[]{0, 0};
        int[] end = new int[]{2, 2};
        int numMoves = 1;

        long expected = 0;

        // When
        long actual = chessMetric.howMany(size, start, end, numMoves);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howMany_case3() throws Exception {
        // Given
        int size = 3;
        int[] start = new int[]{0, 0};
        int[] end = new int[]{0, 0};
        int numMoves = 2;

        long expected = 5;

        // When
        long actual = chessMetric.howMany(size, start, end, numMoves);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void howMany_case4() throws Exception {
        // Given
        int size = 100;
        int[] start = new int[]{0, 0};
        int[] end = new int[]{0, 99};
        int numMoves = 50;

        long expected = 243_097_320_072_600L;
        //364645980108900

        // When
        long actual = chessMetric.howMany(size, start, end, numMoves);

        // Then
        Assert.assertEquals(expected, actual);
    }
}