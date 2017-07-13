package topcoder.chapter07.salary.juv;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Juv
 * @since 2017-07-08
 */
public class CorporationSalaryTest {

    private CorporationSalary corporationSalary;

    @Before
    public void setUp() throws Exception {
        corporationSalary = new CorporationSalary();
    }

    @Test
    public void totalSalary_case0() throws Exception {
        // Given
        String[] relations = new String[]{"N"};
        long expected = 1;

        // When
        long actual = corporationSalary.totalSalary(relations);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void totalSalary_case1() throws Exception {
        // Given
        String[] relations = new String[]{
                "NNYN",
                "NNYN",
                "NNNN",
                "NYYN"
        };
        long expected = 5;

        // When
        long actual = corporationSalary.totalSalary(relations);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void totalSalary_case2() throws Exception {
        // Given
        String[] relations = new String[]{
                "NNNNNN",
                "YNYNNY",
                "YNNNNY",
                "NNNNNN",
                "YNYNNN",
                "YNNYNN"
        };
        long expected = 17;

        // When
        long actual = corporationSalary.totalSalary(relations);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void totalSalary_case3() throws Exception {
        // Given
        String[] relations = new String[]{
                "NYNNYN",
                "NNNNNN",
                "NNNNNN",
                "NNYNNN",
                "NNNNNN",
                "NNNYYN"
        };
        long expected = 8;

        // When
        long actual = corporationSalary.totalSalary(relations);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void totalSalary_case4() throws Exception {
        // Given
        String[] relations = new String[]{
                "NNNN",
                "NNNN",
                "NNNN",
                "NNNN"
        };
        long expected = 4;

        // When
        long actual = corporationSalary.totalSalary(relations);

        // Then
        Assert.assertEquals(expected, actual);
    }

}