package topcoder.chapter05.mazemaker.juv;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Juv
 * @since 2017-07-03
 */
public class MazeMakerTest {

    @Test
    public void longestPath1() {
        String[] maze = new String[] { "...", "...", "..." };
        int startRow = 0;
        int startCol = 1;
        int[] moveRow = new int[] { 1, 0, -1, 0 };
        int[] moveCol = new int[] { 0, 1, 0, -1 };

        int expected = 3;
        // int actual = solution.longestPath(maze, startRow, startCol, moveRow, moveCol);

        // Assert.assertEquals(expected, actual);
    }

    @Test
    public void longestPath2() {
        String[] maze = new String[] { "...", "...", "..." };
        int startRow = 0;
        int startCol = 1;
        int[] moveRow = new int[] { 1, 0, -1, 0, 1, 1, -1, -1 };
        int[] moveCol = new int[] { 0, 1, 0, -1, 1, -1, 1, -1 };

        int expected = 2;
        // int actual = solution.longestPath(maze, startRow, startCol, moveRow, moveCol);

        // Assert.assertEquals(expected, actual);
    }

    @Test
    public void longestPath3() {
        String[] maze = new String[] { "X.X", "...", "XXX", "X.X" };
        int startRow = 0;
        int startCol = 1;
        int[] moveRow = new int[] { 1, 0, -1, 0 };
        int[] moveCol = new int[] { 0, 1, 0, -1 };

        int expected = -1;
        // int actual = solution.longestPath(maze, startRow, startCol, moveRow, moveCol);

        // Assert.assertEquals(expected, actual);
    }

    @Test
    public void longestPath4() {
        String[] maze = new String[] { ".......", "X.X.X..", "XXX...X", "....X..", "X....X.", "......." };
        int startRow = 5;
        int startCol = 0;
        int[] moveRow = new int[] { 1, 0, -1, 0, -2, 1 };
        int[] moveCol = new int[] { 0, -1, 0, 1, 3, 0 };

        int expected = 7;
        // int actual = solution.longestPath(maze, startRow, startCol, moveRow, moveCol);

        // Assert.assertEquals(expected, actual);
    }

    @Test
    public void longestPath5() {
        String[] maze = new String[] { "......." };
        int startRow = 0;
        int startCol = 0;
        int[] moveRow = new int[] { 1, 0, 1, 0, 1, 0 };
        int[] moveCol = new int[] { 0, 1, 0, 1, 0, 1 };

        int expected = 6;
        // int actual = solution.longestPath(maze, startRow, startCol, moveRow, moveCol);

        // Assert.assertEquals(expected, actual);
    }

    @Test
    public void longestPath6() {
        String[] maze = new String[] { "..X.X.X.X.X.X." };
        int startRow = 0;
        int startCol = 0;
        int[] moveRow = new int[] { 2, 0, -2, 0 };
        int[] moveCol = new int[] { 0, 2, 0, -2 };

        int expected = -1;
        // int actual = solution.longestPath(maze, startRow, startCol, moveRow, moveCol);

        // Assert.assertEquals(expected, actual);
    }


}