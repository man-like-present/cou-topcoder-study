package topcoder.chapter05.digit.iron;

import java.util.stream.IntStream;

/**
 * Created by Iron
 *
 * @Since 2017. 6. 19..
 */
public class InterestingDigit {

    public static void main(String[] args) {
        InterestingDigit digit = new InterestingDigit();
        int[] a = digit.digits(9);
        System.out.println(a);
    }


    private boolean isTarget(int base, int cur) {
        return (base - 1) % cur == 0;
    }


    public int[] digits(int base) {
        return IntStream.range(2, base).filter(cur -> isTarget(base, cur)).toArray();
    }
}