package topcoder.chapter07.bad.neighbors.bro;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/** * Created with Intellij IDEA_17.
 * User: Scenestealer / Team_Oslo
 * Date: 2017-07-21
 * Time: 오전 1:12
 * cou-topcoder-study
 * for
 */
public class BadNeighborsTest {

	private BadNeighbors badNeighbors;

	@Before
	public void setUp() throws Exception {
		badNeighbors = new BadNeighbors();
	}

	@Test
	public void maxDonations_case0() throws Exception {
		int[] donations = {10, 3, 2, 5, 7, 8};
		int expected = 19;

		int result = badNeighbors.maxDonations(donations);
		System.out.println("## Example Input ##\n=> " + Arrays.toString(donations));
		System.out.println("Return : " + result);
		System.out.println();

		Assert.assertEquals(expected, result);
	}

	@Test
	public void maxDonations_case1() throws Exception {

		int[] donations = {11, 15};
		int expected = 15;

		int result = badNeighbors.maxDonations(donations);
		System.out.println("## Example Input ##\n=> " + Arrays.toString(donations));
		System.out.println("Return : " + result);
		System.out.println();

		Assert.assertEquals(expected, result);
	}

	@Test
	public void maxDonations_case2() throws Exception {

		int[] donations = {7, 7, 7, 7, 7, 7, 7};
		int expected = 21;

		int result = badNeighbors.maxDonations(donations);
		System.out.println("## Example Input ##\n=> " + Arrays.toString(donations));
		System.out.println("Return : " + result);
		System.out.println();

		Assert.assertEquals(expected, result);
	}

	@Test
	public void maxDonations_case3() throws Exception {

		int[] donations = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
		int expected = 16;

		int result = badNeighbors.maxDonations(donations);
		System.out.println("## Example Input ##\n=> " + Arrays.toString(donations));
		System.out.println("Return : " + result);
		System.out.println();

		Assert.assertEquals(expected, result);
	}

	@Test
	public void maxDonations_case4() throws Exception {

		int[] donations = {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
			6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
			52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};
		int expected = 2926;

		int result = badNeighbors.maxDonations(donations);
		System.out.println("## Example Input ##\n=> " + Arrays.toString(donations));
		System.out.println("Return : " + result);
		System.out.println();

		Assert.assertEquals(expected, result);
	}
}