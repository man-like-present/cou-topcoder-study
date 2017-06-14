package topcoder.problem05.juv;

import java.util.*;

/**
 * Created by Juv on 2017-06-11.
 */
public class PartyMemberSelector {

    public static int select(String[] first, String[] second) {
        Map<String, Set<Integer>> resultMap = new HashMap<>();

        classifyMemberByInterest(first, resultMap);
        classifyMemberByInterest(second, resultMap);

        System.out.println(resultMap);

        Optional<Integer> maxNumberOfMember =
                resultMap.values().stream().map(Set::size).max(Integer::compareTo);
        return maxNumberOfMember.orElse(0);
    }

    private static void classifyMemberByInterest(String[] interests, Map<String, Set<Integer>> resultMap) {
        for (int i = 0; i < interests.length; i++) {
            Set<Integer> members =
                    resultMap.computeIfAbsent(interests[i], k -> new HashSet<>());
            members.add(i);
        }
    }
}
