package topcoder.chapter05.friendscore.bro;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by bro. on 2017. 6. 26..
 */
public class FriendScoreTest {

    private FriendScore friendScore = new FriendScore();

    @Test
    public void testExample1() {
        String[] input = {"NNN", "NNN", "NNN"};
        int result = friendScore.highestScore(input);
        System.out.println("## Example Input ##\n=> " + Arrays.toString(input));
        System.out.println("Return : " + result);
        System.out.println();

        assertEquals(0, result);
    }

    @Test
    public void testExample2() {
        String[] input = {"NYY", "YNY", "YYN"};
        int result = friendScore.highestScore(input);
        System.out.println("## Example Input ##\n=> " + Arrays.toString(input));
        System.out.println("Return : " + result);
        System.out.println();

        assertEquals(2, result);
    }

    @Test
    public void testExample3() {
        String[] input = {"NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN"};
        int result = friendScore.highestScore(input);
        System.out.println("## Example Input ##\n=> " + Arrays.toString(input));
        System.out.println("Return : " + result);
        System.out.println();

        assertEquals(4, result);
    }

    @Test
    public void testExample4() {
        String[] input = {
                "NNNNYNNNNN",
                "NNNNYNYYNN",
                "NNNYYYNNNN",
                "NNYNNNNNNN",
                "YYYNNNNNNY",
                "NNYNNNNNYN",
                "NYNNNNNYNN",
                "NYNNNNYNNN",
                "NNNNNYNNNN",
                "NNNNYNNNNN"
        };
        int result = friendScore.highestScore(input);
        System.out.println("## Example Input ##\n=> " + Arrays.toString(input));
        System.out.println("Return : " + result);
        System.out.println();

        assertEquals(8, result);
    }

    @Test
    public void testExample5() {
        String[] input = {
                "NNNNNNNNNNNNNNY",
                "NNNNNNNNNNNNNNN",
                "NNNNNNNYNNNNNNN",
                "NNNNNNNYNNNNNNY",
                "NNNNNNNNNNNNNNY",
                "NNNNNNNNYNNNNNN",
                "NNNNNNNNNNNNNNN",
                "NNYYNNNNNNNNNNN",
                "NNNNNYNNNNNYNNN",
                "NNNNNNNNNNNNNNY",
                "NNNNNNNNNNNNNNN",
                "NNNNNNNNYNNNNNN",
                "NNNNNNNNNNNNNNN",
                "NNNNNNNNNNNNNNN",
                "YNNYYNNNNYNNNNN"
        };
        int result = friendScore.highestScore(input);
        System.out.println("## Example Input ##\n=> " + Arrays.toString(input));
        System.out.println("Return : " + result);
        System.out.println();

        assertEquals(6, result);
    }
}