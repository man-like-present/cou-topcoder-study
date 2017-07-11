package topcoder.chapter07.salary.bro;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/** * Created with Intellij IDEA_17.
 * cou-topcoder-study
 * for
 */
public class CorporationSalaryTest {

	private CorporationSalary corporationSalary;

	@Before
	public void setUp() throws Exception {
		corporationSalary = new CorporationSalary();
	}

	@Test
	public void testExample1() {
		String[] input = { "N" };
		long result = corporationSalary.totalSalary(input);
		System.out.println("## Example Input ##\n=> " + Arrays.toString(input));
		System.out.println("Return : " + result);
		System.out.println();

		assertEquals(1, result);
	}

	@Test
	public void testExample2() {
		String[] input = {
			"NNYN",
			"NNYN",
			"NNNN",
			"NYYN"
		};
		long result = corporationSalary.totalSalary(input);
		System.out.println("## Example Input ##\n=> " + Arrays.toString(input));
		System.out.println("Return : " + result);
		System.out.println();

		assertEquals(5, result);
	}

	@Test
	public void testExample3() {
		String[] input = {
			"NNNNNN",
			"YNYNNY",
			"YNNNNY",
			"NNNNNN",
			"YNYNNN",
			"YNNYNN"
		};
		long result = corporationSalary.totalSalary(input);
		System.out.println("## Example Input ##\n=> " + Arrays.toString(input));
		System.out.println("Return : " + result);
		System.out.println();

		assertEquals(17, result);
	}

	@Test
	public void testExample4() {
		String[] input = {
			"NYNNYN",
			"NNNNNN",
			"NNNNNN",
			"NNYNNN",
			"NNNNNN",
			"NNNYYN"
		};
		long result = corporationSalary.totalSalary(input);
		System.out.println("## Example Input ##\n=> " + Arrays.toString(input));
		System.out.println("Return : " + result);
		System.out.println();

		assertEquals(8, result);
	}

	@Test
	public void testExample5() {
		String[] input = {
			"NNNN",
			"NNNN",
			"NNNN",
			"NNNN"
		};
		long result = corporationSalary.totalSalary(input);
		System.out.println("## Example Input ##\n=> " + Arrays.toString(input));
		System.out.println("Return : " + result);
		System.out.println();

		assertEquals(4, result);
	}
}