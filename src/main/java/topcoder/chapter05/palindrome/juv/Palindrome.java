package topcoder.chapter05.palindrome.juv;

/**
 * @author Juv
 * @since 2017-06-16
 */
public class Palindrome {

    public static int find(String str) {
        char[] chars = str.toCharArray();

        int lengthOfInput = chars.length;
        int left = 0;
        int right = 0;

        boolean isPalindrome = false;

        for (int i = lengthOfInput - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                isPalindrome = isPalindromeRange(chars, j, i);
                if (isPalindrome) {
                    right = i;
                    left = j;
                    break;
                }
            }
            if (isPalindrome) {
                break;
            }
        }

        return left == right ? (2 * lengthOfInput) - 1 : left + lengthOfInput;
    }

    private static boolean isPalindromeRange(char[] chars, int start, int end) {
        int left = start;
        int right = end;

        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }

}
