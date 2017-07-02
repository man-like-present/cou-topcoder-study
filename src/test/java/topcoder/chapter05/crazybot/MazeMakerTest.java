package topcoder.chapter05.crazybot;

import org.junit.Test;
import topcoder.chapter05.mazemaker.bart.MazeMaker;

import static org.junit.Assert.assertTrue;

public class MazeMakerTest {

	private MazeMaker mazeMaker = new MazeMaker();

	@Test
	public void maze_example1() throws Exception {
		String [] maze = {"...", "...", "..."};
		int [] moveRow = {1,0,-1,0};
		int [] moveCol = {0,1,0,-1};

		int result = mazeMaker.longestPath(maze,0,1,moveRow,moveCol);
		System.out.println("## Example Result ##\n=> " + result);

		assertTrue(result == 3);
	}

	@Test
	public void maze_example2() throws Exception {
		String [] maze = {"X.X","...","XXX","X.X"};
		int [] moveRow = {1,0,-1,0};
		int [] moveCol = {0,1,0,-1};

		int result = mazeMaker.longestPath(maze,0,1,moveRow,moveCol);
		System.out.println("## Example Result ##\n=> " + result);

		assertTrue(result == -1);
	}

	@Test
	public void maze_example3() throws Exception {
		String [] maze = {"..X.X.X.X.X.X."};
		int [] moveRow = {2,0,-2,0};
		int [] moveCol = {0,2,0,-2};

		int result = mazeMaker.longestPath(maze,0,0,moveRow,moveCol);
		System.out.println("## Example Result ##\n=> " + result);

		assertTrue(result == -1);
	}

}
