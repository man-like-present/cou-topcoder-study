package topcoder.chapter05.numbermagic.juv;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Juv
 * @since 2017-07-06
 */
public class NumberMagicEasy {

    private static final char YES = 'Y';

    private static final int NUMBER_OF_CARD = 4;
    private static final int LENGTH_OF_NUMBER_OF_CARD = 8;
    private static final int NOT_EXIST_NUMBER = 16;

    private static final int[][] CARDS = new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 9, 10, 11, 12},
            {1, 2, 5, 6, 9, 10, 13, 14},
            {1, 3, 5, 7, 9, 11, 13, 15}
    };

    public int theNumber(String answer) {
        HashMap<Integer, HashSet<Integer>> indexesByNumber = getIndexesByNumber(CARDS);
        HashSet<Integer> answerIndexes = getAnswerIndexSet(answer);

        // 15
        for (HashMap.Entry<Integer, HashSet<Integer>> each : indexesByNumber.entrySet()) {
            if (answerIndexes.equals(each.getValue())) {
                return each.getKey();
            }
        }

        return NOT_EXIST_NUMBER;
    }

    // 4 * 8 = 32
    private HashMap<Integer, HashSet<Integer>> getIndexesByNumber(int[][] cards) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int cardIndex = 0; cardIndex < NUMBER_OF_CARD; cardIndex++) {
            for (int numberIndex = 0; numberIndex < LENGTH_OF_NUMBER_OF_CARD; numberIndex++) {
                int number = cards[cardIndex][numberIndex];
                HashSet<Integer> yesOrNo = map.computeIfAbsent(number, k -> new HashSet<>());
                yesOrNo.add(cardIndex);
            }
        }
        return map;
    }

    // 4
    private HashSet<Integer> getAnswerIndexSet(String answer) {
        HashSet<Integer> answerIndexes = new HashSet<>();
        char[] answerArray = answer.toCharArray();
        for (int answerIndex = 0; answerIndex < answerArray.length; answerIndex++) {
            if (YES == answerArray[answerIndex]) {
                answerIndexes.add(answerIndex);
            }
        }
        return answerIndexes;
    }
}
