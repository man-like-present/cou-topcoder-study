package topcoder.chapter05.numbermagic.bro;

import org.junit.Test;

import static org.junit.Assert.*;

/** * Created with Intellij IDEA_17.
 * User: Scenestealer / Team_Oslo
 * Date: 2017-07-09
 * Time: 오후 3:33
 * cou-topcoder-study
 * for
 */
public class NumberMagicEasyTest {

	private NumberMagicEasy numberMagicEasy = new NumberMagicEasy();

	@Test
	public void testExample1() {
		String input = "YNYY";
		int result = numberMagicEasy.theNumber(input);
		System.out.println("## Example Input ##\n=> " + input);
		System.out.println("Return : " + result);
		System.out.println();

		assertEquals(5, result);
	}

	@Test
	public void testExample2() {
		String input = "YNNN";
		int result = numberMagicEasy.theNumber(input);
		System.out.println("## Example Input ##\n=> " + input);
		System.out.println("Return : " + result);
		System.out.println();

		assertEquals(8, result);
		numberMagicEasy.theNumber("YNNN");
	}

	@Test
	public void testExample3() {
		String input = "NNNN";
		int result = numberMagicEasy.theNumber(input);
		System.out.println("## Example Input ##\n=> " + input);
		System.out.println("Return : " + result);
		System.out.println();

		assertEquals(16, result);
	}

	@Test
	public void testExample4() {
		String input = "YYYY";
		int result = numberMagicEasy.theNumber(input);
		System.out.println("## Example Input ##\n=> " + input);
		System.out.println("Return : " + result);
		System.out.println();

		assertEquals(1, result);
	}

	@Test
	public void testExample5() {
		String input = "NYNY";
		int result = numberMagicEasy.theNumber(input);
		System.out.println("## Example Input ##\n=> " + input);
		System.out.println("Return : " + result);
		System.out.println();

		assertEquals(11, result);
	}
}