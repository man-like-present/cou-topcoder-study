package topcoder.chapter08.circles.country.bart;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import topcoder.chapter08.batch.system.bart.BatchSystem;

import static org.junit.Assert.*;

public class CirclesCountryTest {
	private CirclesCountry circlesCountry;

	@Before
	public void setUp() throws Exception {
		circlesCountry = new CirclesCountry();
	}

	@Test
	public void leastBoarders_test1() throws Exception {
		int[] X = {0};
		int[] Y = {0};
		int[] R = {2};
		int x1 = -5;
		int y1 = 1;
		int x2 = 5;
		int y2 = 1;

		int expected = 0;

		int actual = circlesCountry.leastBorders(X,Y,R,x1,y1,x2,y2);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void leastBoarders_test2() throws Exception {
		int[] X = {0,-6,6};
		int[] Y = {0,1,2};
		int[] R = {2,2,2};
		int x1 = -5;
		int y1 = 1;
		int x2 = 5;
		int y2 = 1;

		int expected = 2;

		int actual = circlesCountry.leastBorders(X,Y,R,x1,y1,x2,y2);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void leastBoarders_test3() throws Exception {
		int[] X = {1,-3,2,5,-4,12,12};
		int[] Y = {1,-1,2,5,5,1,1};
		int[] R = {8,1,2,1,1,1,2};
		int x1 = -5;
		int y1 = 1;
		int x2 = 12;
		int y2 = 1;

		int expected = 3;

		int actual = circlesCountry.leastBorders(X,Y,R,x1,y1,x2,y2);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void leastBoarders_test4() throws Exception {
		int[] X = {-3,2,2,0,-4,12,12,12};
		int[] Y = {-1,2,3,1,5,1,1,1};
		int[] R = {1,3,1,7,1,1,2,3};
		int x1 = 2;
		int y1 = 3;
		int x2 = 13;
		int y2 = 2;

		int expected = 5;

		int actual = circlesCountry.leastBorders(X,Y,R,x1,y1,x2,y2);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void leastBoarders_test5() throws Exception {
		int[] X = {-107,-38,140,148,-198,172,-179,148,176,153,-56,-187};
		int[] Y = {175,-115,23,-2,-49,-151,-52,42,0,68,109,-174};
		int[] R = {135,42,70,39,89,39,43,150,10,120,16,8};
		int x1 = 102;
		int y1 = 16;
		int x2 = 19;
		int y2 = -108;

		int expected = 3;

		int actual = circlesCountry.leastBorders(X,Y,R,x1,y1,x2,y2);

		Assert.assertEquals(expected, actual);
	}
}