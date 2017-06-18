package topcoder.chapter05.digit.juv;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Juv
 * @since 2017-06-14
 */
public class InterestingDigitTest {
    @Test
    public void find_interesting_digit_case1() throws Exception {
        // Given
        int base = 10;
        int[] expected = new int[]{3, 9};

        // When
        int[] actual = InterestingDigit.find(base);
        int[] actual2 = InterestingDigit.find_using_full_scan(base);

        // Then
        Assert.assertArrayEquals(expected, actual);
        Assert.assertArrayEquals(expected, actual2);
    }

    @Test
    public void find_interesting_digit_case2() throws Exception {
        // Given
        int base = 3;
        int[] expected = new int[]{2};

        // When
        int[] actual = InterestingDigit.find(base);
        int[] actual2 = InterestingDigit.find_using_full_scan(base);

        // Then
        Assert.assertArrayEquals(expected, actual);
        Assert.assertArrayEquals(expected, actual2);
    }

    @Test
    public void find_interesting_digit_case3() throws Exception {
        // Given
        int base = 9;
        int[] expected = new int[]{2, 4, 8};

        // When
        int[] actual = InterestingDigit.find(base);
        int[] actual2 = InterestingDigit.find_using_full_scan(base);

        // Then
        Assert.assertArrayEquals(expected, actual);
        Assert.assertArrayEquals(expected, actual2);
    }

    @Test
    public void find_interesting_digit_case4() throws Exception {
        // Given
        int base = 26;
        int[] expected = new int[]{5, 25};

        // When
        int[] actual = InterestingDigit.find(base);
        int[] actual2 = InterestingDigit.find_using_full_scan(base);

        // Then
        Assert.assertArrayEquals(expected, actual);
        Assert.assertArrayEquals(expected, actual2);
    }

    @Test
    public void find_interesting_digit_case5() throws Exception {
        // Given
        int base = 30;
        int[] expected = new int[]{29};

        // When
        int[] actual = InterestingDigit.find(base);
        int[] actual2 = InterestingDigit.find_using_full_scan(base);

        // Then
        Assert.assertArrayEquals(expected, actual);
        Assert.assertArrayEquals(expected, actual2);
    }

}