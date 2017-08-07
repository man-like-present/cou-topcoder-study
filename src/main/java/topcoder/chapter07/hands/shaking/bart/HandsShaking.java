package topcoder.chapter07.hands.shaking.bart;

import java.util.HashMap;
import java.util.Map;

public class HandsShaking {

    private Map<Integer, Long> caseResultMap = new HashMap<>();

    public long countPerfect(int n) {
        if (n == 0 || n % 2 == 1) {
            return 0L;
        }

        if(n == 2) {
            return 1;
        }

        int caseNumber = n / 2;
        if(caseResultMap.get(caseNumber) != null) {
            return caseResultMap.get(caseNumber);
        }

        long result = 0L;
        for(int i = 1; i < n; i++) {
            if(i % 2 != 0) {
                result += Math.max(countPerfect(i-1),1) * Math.max(countPerfect(n-i-1),1);
            }
        }

        caseResultMap.put(caseNumber, result);
        return result;
    }
}
