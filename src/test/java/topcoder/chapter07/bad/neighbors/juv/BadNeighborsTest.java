package topcoder.chapter07.bad.neighbors.juv;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Juv
 * @since 2017-07-16
 */
public class BadNeighborsTest {

    private BadNeighbors badNeighbors;
    private BadNeighbors2 badNeighbors2;

    @Before
    public void setUp() throws Exception {
        badNeighbors = new BadNeighbors();
        badNeighbors2 = new BadNeighbors2();
    }

    @Test
    public void maxDonations_case0() throws Exception {
        // Given
        int[] donations = {10, 3, 2, 5, 7, 8};
        int expected = 19;

        // When
        int actual = badNeighbors.maxDonations(donations);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxDonations_case1() throws Exception {
        // Given
        int[] donations = {11, 15};
        int expected = 15;

        // When
        int actual = badNeighbors.maxDonations(donations);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxDonations_case2() throws Exception {
        // Given
        int[] donations = {7, 7, 7, 7, 7, 7, 7};
        int expected = 21;

        // When
        int actual = badNeighbors.maxDonations(donations);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxDonations_case3() throws Exception {
        // Given
        int[] donations = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int expected = 16;

        // When
        int actual = badNeighbors.maxDonations(donations);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxDonations_case4() throws Exception {
        // Given
        int[] donations = {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
                6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
                52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};
        int expected = 2926;

        // When
        int actual = badNeighbors.maxDonations(donations);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void maxDonations2_case0() throws Exception {
        // Given
        int[] donations = {10, 3, 2, 5, 7, 8};
        int expected = 19;

        // When
        int actual = badNeighbors2.maxDonations(donations);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxDonations2_case1() throws Exception {
        // Given
        int[] donations = {11, 15};
        int expected = 15;

        // When
        int actual = badNeighbors2.maxDonations(donations);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxDonations2_case2() throws Exception {
        // Given
        int[] donations = {7, 7, 7, 7, 7, 7, 7};
        int expected = 21;

        // When
        int actual = badNeighbors2.maxDonations(donations);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxDonations2_case3() throws Exception {
        // Given
        int[] donations = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int expected = 16;

        // When
        int actual = badNeighbors2.maxDonations(donations);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxDonations2_case4() throws Exception {
        // Given
        int[] donations = {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
                6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
                52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};
        int expected = 2926;

        // When
        int actual = badNeighbors2.maxDonations(donations);

        // Then
        Assert.assertEquals(expected, actual);
    }
}