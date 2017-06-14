package topcoder.chapter05.cryptography.juv;

import java.util.Arrays;

/**
 * 5-2. Cryptography
 *
 * @author Juv
 * @since 2017-06-14
 */
public class Cryptography {

    // big(O) = n * n
    public static long encrypt(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0L;
        }
        long max = 0L;
        for (int i = 0; i < numbers.length; i++) {
            long calculated = 1L;
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    calculated *= (long) numbers[j] + 1L;
                } else {
                    calculated *= (long) numbers[j];
                }
            }
            max = max > calculated ? max : calculated;
        }

        return max;
    }

    // big(O) = 2n
    public static long encrypt2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0L;
        }

        long normalCalculated = Arrays.stream(numbers)
                .mapToLong(value -> (long) value)
                .reduce((left, right) -> left * right)
                .orElse(0L);

        if (normalCalculated == 0L) {
            return 0L;
        }

        return Arrays.stream(numbers)
                .mapToLong(value -> normalCalculated / (long) value * ((long) value + 1L)).max()
                .orElse(0L);
    }
}
