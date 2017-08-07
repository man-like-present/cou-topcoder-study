package topcoder.chapter07.hands.shaking.juv;

import java.util.HashMap;

/**
 * @author Juv
 * @since 2017-07-22
 */
public class HandsShaking {

    private HashMap<Integer, Long> countPerfectsByN = new HashMap<>();

    public long countPerfect(int n) {

        // 사람이 없는 경우나 홀수인 경우는 악수할 수 있는 경우가 없다.
        if (n == 0 || n % 2 == 1) {
            return 0L;
        }
        return countPerfectWhenPossible(n);
    }

    private long countPerfectWhenPossible(int n) {
        if (n == 0 || n == 2) {
            return 1;
        }

        if (countPerfectsByN.get(n) != null) {
            return countPerfectsByN.get(n);
        }

        int casesOfOnePoint = n / 2;
        int remainN = n - 2;

        long result = 0;
        for (int i = 0; i < casesOfOnePoint; i++) {
            int rightN = 2 * i;
            int leftN = remainN - rightN;
            result += countPerfectWhenPossible(rightN) * countPerfectWhenPossible(leftN);
        }

        countPerfectsByN.put(n, result);
        return result;
    }

    private long countPerfectWhenPossible2(int n) {

        long[] cases = new long[n / 2 + 1];

        for (int i = 0; i <= n / 2; i++) {
            long numOfCase = 0L;
            if (i == 0 || i == 1) {
                numOfCase = 1;
            } else {
                for (int j = 0; j < i; j++) {
                    numOfCase += cases[j] * cases[i - j - 1];
                }
            }
            cases[i] = numOfCase;
        }

        return cases[n / 2];
    }
}
