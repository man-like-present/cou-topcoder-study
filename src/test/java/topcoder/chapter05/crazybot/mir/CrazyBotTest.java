package topcoder.chapter05.crazybot.mir;

import org.junit.Test;

import static org.junit.Assert.*;

public class CrazyBotTest {

    private CrazyBot crazyBot = new CrazyBot();

    @Test
    public void CrazyBot_test1() throws Exception {
        double result = crazyBot.getProbability(2,25,25,25,25);
        System.out.println("## Example Result ##\n=> " + result);

        assertTrue(result == 0.75);
    }

    @Test
    public void CrazyBot_test2() throws Exception {
        double result = crazyBot.getProbability(1, 25, 25, 25, 25);
        System.out.println("## Example Result ##\n=> " + result);

        assertTrue(result == 1);
    }

    @Test
    public void CrazyBot_test3() throws Exception {
        double result = crazyBot.getProbability( 7, 50, 0, 0, 50);
        System.out.println("## Example Result ##\n=> " + result);

        assertTrue(result == 1.0);
    }

    @Test
    public void CrazyBot_test4() throws Exception {
        double result = crazyBot.getProbability(14, 50, 50, 0, 0);
        System.out.println("## Example Result ##\n=> " + result);

        assertTrue(result == 1.220703125E-4);
    }

    @Test
    public void CrazyBot_test5() throws Exception {
        double result = crazyBot.getProbability( 14, 25, 25, 25, 25);
        System.out.println("## Example Result ##\n=> " + result);

        assertTrue(result == 0.008845493197441101);
    }

}