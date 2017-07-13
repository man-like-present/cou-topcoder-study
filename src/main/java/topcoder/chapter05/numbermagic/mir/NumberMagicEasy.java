package topcoder.chapter05.numbermagic.mir;

import java.util.*;

public class NumberMagicEasy {
    private int[][] ar = {{1, 2, 3, 4, 5, 6, 7, 8}, {1, 2, 3, 4, 9, 10, 11, 12}, {1, 2, 5, 6, 9, 10, 13, 14}, {1, 3, 5, 7, 9, 11, 13, 15}};
    private List<Set<Integer>> list = new ArrayList<>();
    private Set<Integer> result = new HashSet<>();

    public int theNumber(String answer) {
        list.add(new HashSet<>());
        list.add(new HashSet<>());
        list.add(new HashSet<>());
        list.add(new HashSet<>());
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                list.get(j).add(ar[j][i]);
                result.add(ar[j][i]);
            }
        }
        for (int i = 1; i <= 16; i++) {
            result.add(i);
        }
        for (int i = 0; i < 4; i++) {
            if (answer.charAt(i) == 'Y') {
                HashSet<Integer> newResult = new HashSet<>();
                list.get(i).forEach(it -> {
                    if (result.contains(it)) {
                        newResult.add(it);
                    }
                });
                result = newResult;
            } else {
                result.removeAll(list.get(i));
            }
        }
        return (int) result.toArray()[0];
    }
}
