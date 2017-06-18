package topcoder.chapter05.digit.bro;

import org.junit.Test;

import java.util.Arrays;

/** * Created with Intellij IDEA_17.
 * User: Scenestealer / Team_Oslo
 * Date: 2017-06-18
 * Time: 오후 11:28
 * cou-topcoder-study
 * for
 */
public class InterestingDigitsTest {

	private InterestingDigits interestingDigits = new InterestingDigits();

	@Test
	public void digits_example1() throws Exception {
		int [] result = interestingDigits.digits(10);

		System.out.println("## Example Result ##\n=> " + Arrays.toString(result));
	}

	@Test
	public void digits_example2() throws Exception {
		int [] result = interestingDigits.digits(3);

		System.out.println("## Example Result ##\n=> " + Arrays.toString(result));
	}

	@Test
	public void digits_example3() throws Exception {
		int [] result = interestingDigits.digits(9);

		System.out.println("## Example Result ##\n=> " + Arrays.toString(result));
	}

	@Test
	public void digits_example4() throws Exception {
		int [] result = interestingDigits.digits(26);

		System.out.println("## Example Result ##\n=> " + Arrays.toString(result));
	}

	@Test
	public void digits_example5() throws Exception {
		int [] result = interestingDigits.digits(30);

		System.out.println("## Example Result ##\n=> " + Arrays.toString(result));
	}

	@Test
	public void digits_test1() throws Exception {
		int [] result = interestingDigits.digits(0);

		System.out.println("## Test Result ##\n=> " + Arrays.toString(result));
	}

	@Test
	public void digits_test2() throws Exception {
		int [] result = interestingDigits.digits(1);

		System.out.println("## Test Result ##\n=> " + Arrays.toString(result));
	}

	@Test
	public void digits_test3() throws Exception {
		int [] result = interestingDigits.digits(2);

		System.out.println("## Test Result ##\n=> " + Arrays.toString(result));
	}
}