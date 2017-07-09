package topcoder.chapter05.numbermagic.juv;

import org.junit.Assert;
import org.junit.Test;
import topcoder.chapter05.numbermagic.juv.NumberMagicEasy;

/**
 * @author Juv
 * @since 2017-07-06
 */
public class NumberMagicEasyTest {

    private NumberMagicEasy numberMagicEasy = new NumberMagicEasy();

    @Test
    public void theNumber1() throws Exception {
        // Given
        int expected = 5;

        // When
        int actual = numberMagicEasy.theNumber("YNYY");

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void theNumber2() throws Exception {
        // Given
        int expected = 8;

        // When
        int actual = numberMagicEasy.theNumber("YNNN");

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void theNumber3() throws Exception {
        // Given
        int expected = 16;

        // When
        int actual = numberMagicEasy.theNumber("NNNN");

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void theNumber4() throws Exception {
        // Given
        int expected = 1;

        // When
        int actual = numberMagicEasy.theNumber("YYYY");

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void theNumber5() throws Exception {
        // Given
        int expected = 11;

        // When
        int actual = numberMagicEasy.theNumber("NYNY");

        // Then
        Assert.assertEquals(expected, actual);
    }
}