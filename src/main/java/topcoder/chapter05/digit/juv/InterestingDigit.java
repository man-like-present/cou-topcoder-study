package topcoder.chapter05.digit.juv;

import java.util.stream.IntStream;

/**
 * 5-3. Interesting Digit
 *
 * @author Juv
 * @since 2017-06-14
 */
public class InterestingDigit {
    public static int[] find(int base) {
        int maxValue = base - 1;

        return IntStream.range(2, base)
                .filter(value -> maxValue % value == 0)
                .toArray();
    }
}
