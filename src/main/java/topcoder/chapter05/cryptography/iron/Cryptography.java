package topcoder.chapter05.cryptography.iron;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Iron
 * @Since 2017. 6. 18..
 */
public class Cryptography {

    private static final int INCREASE_TARGET = 0;

    public static void main(String[] args) {
        int[] number = {1000, 999, 998, 997, 996, 995};

        Cryptography secure = new Cryptography();
        long encrypt = secure.encrypt(number);

        System.out.println(encrypt);
    }

    private long encrypt(int[] number) {
        Arrays.sort(number);
        number[INCREASE_TARGET] += 1;
        return IntStream.of(number).asLongStream().reduce(1, (a, b) -> a * b);
    }
}
