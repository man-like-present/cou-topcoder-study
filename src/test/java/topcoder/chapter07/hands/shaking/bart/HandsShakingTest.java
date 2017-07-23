package topcoder.chapter07.hands.shaking.bart;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HandsShakingTest {

    private topcoder.chapter07.hands.shaking.bart.HandsShaking handsShaking;

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

    @Test
    public void countPerfect_case3() throws Exception {
        // Given
        int n = 10;
        long expected = 42L;

        // When
        long actual = handsShaking.countPerfect(n);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countPerfect_case4() throws Exception {
        // Given
        int n = 12;
        long expected = 132L;

        // When
        long actual = handsShaking.countPerfect(n);

        // Then
        Assert.assertEquals(expected, actual);
    }
}