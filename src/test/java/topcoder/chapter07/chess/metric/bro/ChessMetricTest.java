package topcoder.chapter07.chess.metric.bro;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/** * Created with Intellij IDEA_17.
 * User: Scenestealer / Team_Oslo
 * Date: 2017-07-23
 * Time: 오후 11:32
 * cou-topcoder-study
 * for
 */
public class ChessMetricTest {

	private ChessMetric chessMetric;

	@Before
	public void setUp() {
		chessMetric = new ChessMetric();
	}

	@Test
	public void testExample1() throws Exception {

		int size = 3;
		int[] start = new int[]{0, 0};
		int[] end = new int[]{1, 0};
		int numMoves = 1;

		System.out.println("## Example Input ##");
		System.out.println("size : " + size);
		System.out.println("start : " + Arrays.toString(start));
		System.out.println("end : " + Arrays.toString(end));
		System.out.println("numMoves : " + numMoves);

		long startTime = System.currentTimeMillis();
		long result = chessMetric.howMany(size, start, end, numMoves);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");
		assertEquals(1, result);
	}

	@Test
	public void testExample2() throws Exception {
		// Given
		int size = 3;
		int[] start = new int[]{0, 0};
		int[] end = new int[]{1, 2};
		int numMoves = 1;

		System.out.println("## Example Input ##");
		System.out.println("size : " + size);
		System.out.println("start : " + Arrays.toString(start));
		System.out.println("end : " + Arrays.toString(end));
		System.out.println("numMoves : " + numMoves);

		long startTime = System.currentTimeMillis();
		long result = chessMetric.howMany(size, start, end, numMoves);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");
		assertEquals(1, result);
	}

	@Test
	public void testExample3() throws Exception {
		// Given
		int size = 3;
		int[] start = new int[]{0, 0};
		int[] end = new int[]{2, 2};
		int numMoves = 1;

		System.out.println("## Example Input ##");
		System.out.println("size : " + size);
		System.out.println("start : " + Arrays.toString(start));
		System.out.println("end : " + Arrays.toString(end));
		System.out.println("numMoves : " + numMoves);

		long startTime = System.currentTimeMillis();
		long result = chessMetric.howMany(size, start, end, numMoves);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");
		assertEquals(0, result);
	}

	@Test
	public void testExample4() throws Exception {
		// Given
		int size = 3;
		int[] start = new int[]{0, 0};
		int[] end = new int[]{0, 0};
		int numMoves = 2;

		System.out.println("## Example Input ##");
		System.out.println("size : " + size);
		System.out.println("start : " + Arrays.toString(start));
		System.out.println("end : " + Arrays.toString(end));
		System.out.println("numMoves : " + numMoves);

		long startTime = System.currentTimeMillis();
		long result = chessMetric.howMany(size, start, end, numMoves);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");
		assertEquals(5, result);
	}

	@Test
	public void testExample5() throws Exception {
		// Given
		int size = 100;
		int[] start = new int[]{0, 0};
		int[] end = new int[]{0, 99};
		int numMoves = 50;

		System.out.println("## Example Input ##");
		System.out.println("size : " + size);
		System.out.println("start : " + Arrays.toString(start));
		System.out.println("end : " + Arrays.toString(end));
		System.out.println("numMoves : " + numMoves);

		long startTime = System.currentTimeMillis();
		long result = chessMetric.howMany(size, start, end, numMoves);
		long endTime = System.currentTimeMillis();

		System.out.println("Reslut : " + result);
		System.out.println("Elapsed time(ms) : " + (endTime - startTime) + "ms\n");
		assertEquals(243097320072600L, result);
	}
}