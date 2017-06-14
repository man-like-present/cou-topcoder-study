package topcoder.chapter05.cryptography.juv;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Juv
 * @since 2017-06-14
 */
public class CryptographyTest {
    @Test
    public void encrypt_case1() throws Exception {
        // Given
        int[] numbers = {1, 2, 3};
        long expected = 12L;

        // When
        long encrypted = Cryptography.encrypt(numbers);
        long encrypted2 = Cryptography.encrypt2(numbers);

        // Then
        Assert.assertEquals(expected, encrypted);
        Assert.assertEquals(expected, encrypted2);
    }

    @Test
    public void encrypt_case2() throws Exception {
        // Given
        int[] numbers = {1, 3, 2, 1, 1, 3};
        long expected = 36L;

        // When
        long encrypted = Cryptography.encrypt(numbers);
        long encrypted2 = Cryptography.encrypt2(numbers);

        // Then
        Assert.assertEquals(expected, encrypted);
        Assert.assertEquals(expected, encrypted2);
    }

    @Test
    public void encrypt_case3() throws Exception {
        // Given
        int[] numbers = {1000, 999, 998, 997, 996, 995};
        long expected = 986074810223904000L;

        // When
        long encrypted = Cryptography.encrypt(numbers);
        long encrypted2 = Cryptography.encrypt2(numbers);

        // Then
        Assert.assertEquals(expected, encrypted);
        Assert.assertEquals(expected, encrypted2);
    }

}