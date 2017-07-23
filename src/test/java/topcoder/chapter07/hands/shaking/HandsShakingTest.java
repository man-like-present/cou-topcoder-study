package topcoder.chapter07.hands.shaking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Juv
 * @since 2017-07-22
 */
public class HandsShakingTest {

    private HandsShaking handsShaking;

    @Before
    public void setUp() throws Exception {
        handsShaking = new HandsShaking();
    }

    @Test
    public void countPerfect_case0() throws Exception {
        // Given
        int n = 2;
        long expected = 1L;

        // When
        long actual = handsShaking.countPerfect(n);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countPerfect_case1() throws Exception {
        // Given
        int n = 4;
        long expected = 2L;

        // When
        long actual = handsShaking.countPerfect(n);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countPerfect_case2() throws Exception {
        // Given
        int n = 8;
        long expected = 14L;

        // When
        long actual = handsShaking.countPerfect(n);

        // Then
        Assert.assertEquals(expected, actual);
    }
}