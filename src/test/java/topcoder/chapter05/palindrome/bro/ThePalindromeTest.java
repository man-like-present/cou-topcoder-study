package topcoder.chapter05.palindrome.bro;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bro. on 2017. 6. 26..
 */
public class ThePalindromeTest {

    private ThePalindrome thePalindrome = new ThePalindrome();

    @Test
    public void testExample1() {
        int result = thePalindrome.find("abab");
        System.out.println("## Example Input ##\n=> " + "abab");
        System.out.println("Return : " + result);
        System.out.println("ResultString : " + thePalindrome.findString("abab"));
        System.out.println();

        assertEquals(5, result);
    }

    @Test
    public void testExample2() {
        int result = thePalindrome.find("abacaba");
        System.out.println("## Example Input ##\n=> " + "abacaba");
        System.out.println("Return : " + result);
        System.out.println("ResultString : " + thePalindrome.findString("abacaba"));
        System.out.println();

        assertEquals(7, result);
    }

    @Test
    public void testExample3() {
        int result = thePalindrome.find("qwerty");
        System.out.println("## Example Input ##\n=> " + "qwerty");
        System.out.println("Return : " + result);
        System.out.println("ResultString : " + thePalindrome.findString("qwerty"));
        System.out.println();

        assertEquals(11, result);
    }

    @Test
    public void testExample4() {
        int result = thePalindrome.find("abdfhdyrbdbsdfghjkllkjhgfds");
        System.out.println("## Example Input ##\n=> " + "abdfhdyrbdbsdfghjkllkjhgfds");
        System.out.println("Return : " + result);
        System.out.println("ResultString : " + thePalindrome.findString("abdfhdyrbdbsdfghjkllkjhgfds"));
        System.out.println();

        assertEquals(38, result);
    }

    @Test
    public void testException1() {
        int result = thePalindrome.find("12345");
        System.out.println("## Example Input ##\n=> " + "12345");
        System.out.println("Return : " + result);
        System.out.println("ResultString : " + thePalindrome.findString("12345"));
        System.out.println();

        assertTrue(NumberUtils.INTEGER_MINUS_ONE.equals(result));
    }

    @Test
    public void testException2() {
        int result = thePalindrome.find("aba1aba");
        System.out.println("## Example Input ##\n=> " + "aba1aba");
        System.out.println("Return : " + result);
        System.out.println("ResultString : " + thePalindrome.findString("aba1aba"));
        System.out.println();

        assertTrue(NumberUtils.INTEGER_MINUS_ONE.equals(result));
    }

    @Test
    public void testException3() {
        int result = thePalindrome.find("");
        System.out.println("## Example Input ##\n=> " + "");
        System.out.println("Return : " + result);
        System.out.println("ResultString : " + thePalindrome.findString(""));
        System.out.println();

        assertTrue(NumberUtils.INTEGER_MINUS_ONE.equals(result));
    }
}