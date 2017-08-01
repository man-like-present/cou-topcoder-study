package topcoder.chapter07.hands.shaking.bro;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/** * Created with Intellij IDEA_17.
 * Date: 2017-07-30
 * Time: 오후 11:09
 * cou-topcoder-study
 * for
 */
public class HandsShakingTest {
	private HandsShaking handsShaking;

	@Before
	public void setUp() throws Exception {
		handsShaking = new HandsShaking();
	}

	@Test
	public void testExample1() throws Exception {
		int n = 2;

		System.out.println("## Example Input ##");
		System.out.println("=> " + n);

		long startTime = System.currentTimeMillis();
		long result = handsShaking.countPerfect(n);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");

		assertEquals(1L, result);
	}

	@Test
	public void testExample2() throws Exception {
		int n = 4;

		System.out.println("## Example Input ##");
		System.out.println("=> " + n);

		long startTime = System.currentTimeMillis();
		long result = handsShaking.countPerfect(n);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");

		assertEquals(2L, result);
	}

	@Test
	public void testExample4() throws Exception {
		int n = 8;

		System.out.println("## Example Input ##");
		System.out.println("=> " + n);

		long startTime = System.currentTimeMillis();
		long result = handsShaking.countPerfect(n);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");

		assertEquals(14L, result);
	}
}