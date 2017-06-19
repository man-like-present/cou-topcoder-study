package topcoder.chapter05.palindrome.juv;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Juv
 * @since 2017-06-17
 */
public class PalindromeTest {
    @Test
    public void find_case1() throws Exception {
        // Given
        String inputString = "abab";

        // When
        int minPalindromeLength = Palindrome.find(inputString);
        int expected = 5;

        // Then
        Assert.assertEquals(expected, minPalindromeLength);
    }

    @Test
    public void find_case2() throws Exception {
        // Given
        String inputString = "abacaba";

        // When
        int minPalindromeLength = Palindrome.find(inputString);
        int expected = 7;

        // Then
        Assert.assertEquals(expected, minPalindromeLength);
    }

    @Test
    public void find_case3() throws Exception {
        // Given
        String inputString = "qwerty";

        // When
        int minPalindromeLength = Palindrome.find(inputString);
        int expected = 11;

        // Then
        Assert.assertEquals(expected, minPalindromeLength);
    }

    @Test
    public void find_case4() throws Exception {
        // Given
        String inputString = "abdfhdyrbdbsdfghjkllkjhgfds";

        // When
        int minPalindromeLength = Palindrome.find(inputString);
        int expected = 38;

        // Then
        Assert.assertEquals(expected, minPalindromeLength);
    }
}