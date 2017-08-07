package topcoder.chapter08.colorful.boxball.bro;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/** * Created with Intellij IDEA_17.
 * Date: 2017-07-30
 * Time: 오후 11:32
 * cou-topcoder-study
 * for
 */
public class ColorfulBoxesAndBallsTest {

	private ColorfulBoxesAndBalls colorfulBoxesAndBalls;

	@Before
	public void setUp() throws Exception {
		colorfulBoxesAndBalls = new ColorfulBoxesAndBalls();
	}

	@Test
	public void testExample1() throws Exception {

		int numRed = 2;
		int numBlue = 3;
		int onlyRed = 100;
		int onlyBlue = 400;
		int bothColors = 200;

		System.out.println("## Example Input ##");
		System.out.println("numRed : " + numRed);
		System.out.println("numBlue : " + numBlue);
		System.out.println("onlyRed : " + onlyRed);
		System.out.println("onlyBlue : " + onlyBlue);
		System.out.println("bothColors : " + bothColors);

		long startTime = System.currentTimeMillis();
		long result = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");

		assertEquals(1400, result);
	}

	@Test
	public void testExample2() throws Exception {

		int numRed = 2;
		int numBlue = 3;
		int onlyRed = 100;
		int onlyBlue = 400;
		int bothColors = 300;

		System.out.println("## Example Input ##");
		System.out.println("numRed : " + numRed);
		System.out.println("numBlue : " + numBlue);
		System.out.println("onlyRed : " + onlyRed);
		System.out.println("onlyBlue : " + onlyBlue);
		System.out.println("bothColors : " + bothColors);

		long startTime = System.currentTimeMillis();
		long result = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");

		assertEquals(1600, result);
	}

	@Test
	public void testExample3() throws Exception {

		int numRed = 5;
		int numBlue = 5;
		int onlyRed = 464;
		int onlyBlue = 464;
		int bothColors = 464;

		System.out.println("## Example Input ##");
		System.out.println("numRed : " + numRed);
		System.out.println("numBlue : " + numBlue);
		System.out.println("onlyRed : " + onlyRed);
		System.out.println("onlyBlue : " + onlyBlue);
		System.out.println("bothColors : " + bothColors);

		long startTime = System.currentTimeMillis();
		long result = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");

		assertEquals(4640, result);
	}

	@Test
	public void testExample4() throws Exception {

		int numRed = 1;
		int numBlue = 4;
		int onlyRed = 20;
		int onlyBlue = -30;
		int bothColors = -10;

		System.out.println("## Example Input ##");
		System.out.println("numRed : " + numRed);
		System.out.println("numBlue : " + numBlue);
		System.out.println("onlyRed : " + onlyRed);
		System.out.println("onlyBlue : " + onlyBlue);
		System.out.println("bothColors : " + bothColors);

		long startTime = System.currentTimeMillis();
		long result = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");

		assertEquals(-100, result);
	}

	@Test
	public void testExample5() throws Exception {

		int numRed = 9;
		int numBlue = 1;
		int onlyRed = -1;
		int onlyBlue = -10;
		int bothColors = 4;

		System.out.println("## Example Input ##");
		System.out.println("numRed : " + numRed);
		System.out.println("numBlue : " + numBlue);
		System.out.println("onlyRed : " + onlyRed);
		System.out.println("onlyBlue : " + onlyBlue);
		System.out.println("bothColors : " + bothColors);

		long startTime = System.currentTimeMillis();
		long result = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");

		assertEquals(0, result);
	}
}