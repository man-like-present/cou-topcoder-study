package topcoder.chapter05.digit.juv;

import java.util.stream.IntStream;

/**
 * 5-3. Interesting Digit
 *
 * @author Juv
 * @since 2017-06-14
 */
public class InterestingDigit {

    // big(O) = n
    public static int[] find(int base) {
        int maxValue = base - 1;

        return IntStream.range(2, base)
                .filter(value -> maxValue % value == 0)
                .toArray();
    }

    // big(O) = n^4
    public static int[] find_using_full_scan(int base) {
        return IntStream.range(2, base).filter(value -> isInterestNumber(base, value)).toArray();
    }

    private static boolean isInterestNumber(int base, int targetNumber) {
        return IntStream.range(0, base)
                .noneMatch(first -> IntStream.range(0, base)
                        .anyMatch(second -> IntStream.range(0, base)
                                .anyMatch(third -> isNotInterestNumber(first, second, third, targetNumber, base))));
    }

    private static boolean isNotInterestNumber(int first, int second, int third, int targetNumber, int base) {
        int number = first + second * base + third * base * base;
        int sum = first + second + third;
        return number % targetNumber == 0 && sum % targetNumber != 0;
    }
}
