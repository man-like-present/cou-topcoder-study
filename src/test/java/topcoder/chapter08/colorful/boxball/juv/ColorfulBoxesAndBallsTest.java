package topcoder.chapter08.colorful.boxball.juv;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Juv
 * @since 2017-07-29
 */
public class ColorfulBoxesAndBallsTest {

    private ColorfulBoxesAndBalls colorfulBoxesAndBalls;

    @Before
    public void setUp() throws Exception {
        colorfulBoxesAndBalls = new ColorfulBoxesAndBalls();
    }

    @Test
    public void getMaximum_case0() throws Exception {
        // Given
        int numRed = 2;
        int numBlue = 3;
        int onlyRed = 100;
        int onlyBlue = 400;
        int bothColors = 200;

        int expected = 1400;

        // When
        int actual = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMaximum_case1() throws Exception {
        // Given
        int numRed = 2;
        int numBlue = 3;
        int onlyRed = 100;
        int onlyBlue = 400;
        int bothColors = 300;

        int expected = 1600;

        // When
        int actual = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMaximum_case2() throws Exception {
        // Given
        int numRed = 5;
        int numBlue = 5;
        int onlyRed = 464;
        int onlyBlue = 464;
        int bothColors = 464;

        int expected = 4640;

        // When
        int actual = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMaximum_case3() throws Exception {
        // Given
        int numRed = 1;
        int numBlue = 4;
        int onlyRed = 20;
        int onlyBlue = -30;
        int bothColors = -10;

        int expected = -100;

        // When
        int actual = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMaximum_case4() throws Exception {
        // Given
        int numRed = 9;
        int numBlue = 1;
        int onlyRed = -1;
        int onlyBlue = -10;
        int bothColors = 4;

        int expected = 0;

        // When
        int actual = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);

        // Then
        Assert.assertEquals(expected, actual);
    }
}