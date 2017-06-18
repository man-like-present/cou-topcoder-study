package topcoder.chapter05.party.mir;

import java.util.HashMap;
import java.util.Map;

public class InterestingParty {
    public int bestInvitation(String[] first, String[] second) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : first) {
            check(map, s);
        }
        for (String s : second) {
            check(map, s);
        }
        int max = 0;
        for (int value : map.values()) {
            max = Math.max(value, max);
        }
        return max;
    }

    private void check(Map<String, Integer> map, String s) {
        if (!map.containsKey(s)) {
            map.put(s, 1);
        } else {
            int value = map.get(s) + 1;
            map.put(s, value);
        }
    }
}