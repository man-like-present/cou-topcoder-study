package topcoder.chapter05.palindrome.mir;

import org.junit.Assert;
import org.junit.Test;
import topcoder.chapter05.palindrome.mir.ThePalindrome;

import static org.junit.Assert.*;


public class ThePalindromeTest {


    @Test
    public void find_case1() throws Exception {
        // Given
        String inputString = "abab";
        ThePalindrome thePalindrome = new ThePalindrome();
        // When
        int minPalindromeLength = thePalindrome.find(inputString);
        int expected = 5;

        // Then
        Assert.assertEquals(expected, minPalindromeLength);
    }

    @Test
    public void find_case2() throws Exception {
        // Given
        String inputString = "abacaba";

        ThePalindrome thePalindrome = new ThePalindrome();
        // When
        int minPalindromeLength = thePalindrome.find(inputString);
        int expected = 7;

        // Then
        Assert.assertEquals(expected, minPalindromeLength);
    }

    @Test
    public void find_case3() throws Exception {
        // Given
        String inputString = "qwerty";

        ThePalindrome thePalindrome = new ThePalindrome();
        // When
        int minPalindromeLength = thePalindrome.find(inputString);
        int expected = 11;

        // Then
        Assert.assertEquals(expected, minPalindromeLength);
    }

    @Test
    public void find_case4() throws Exception {
        // Given
        String inputString = "abdfhdyrbdbsdfghjkllkjhgfds";

        ThePalindrome thePalindrome = new ThePalindrome();
        // When
        int minPalindromeLength = thePalindrome.find(inputString);
        int expected = 38;

        // Then
        Assert.assertEquals(expected, minPalindromeLength);
    }

    @Test
    public void find_case5() throws Exception {
        // Given
        String inputString = "a";

        ThePalindrome thePalindrome = new ThePalindrome();
        // When
        int minPalindromeLength = thePalindrome.find(inputString);
        int expected = 1;

        // Then
        Assert.assertEquals(expected, minPalindromeLength);
    }
}