package topcoder.chapter05.crazybot.juv;

import org.junit.Test;

/**
 * @author Juv
 * @since 2017-07-01
 */
public class CrazyBotTest {


    @Test
    public void getProbability() throws Exception {
        // Given

        // When
//        System.out.println(getProbability(1, 25, 25, 25, 25));
//        System.out.println(getProbability(2, 25, 25, 25, 25));
//        System.out.println(getProbability(7, 50, 0, 0, 50));
//        System.out.println(getProbability(14, 50, 50, 0, 0));
//        System.out.println(getProbability(14, 25, 25, 25, 25));

        CrazyBot2 crazyBot = new CrazyBot2();
        System.out.println(crazyBot.getProbability(1, 25, 25, 25, 25));
        System.out.println(crazyBot.getProbability(2, 25, 25, 25, 25));
        System.out.println(crazyBot.getProbability(7, 50, 0, 0, 50));
        System.out.println(crazyBot.getProbability(14, 50, 50, 0, 0));
        System.out.println(crazyBot.getProbability(14, 25, 25, 25, 25));

        // Then
    }

}