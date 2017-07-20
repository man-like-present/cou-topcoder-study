package topcoder.chapter07.chess.metric.juv;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Juv
 * @since 2017-07-16
 */
public class ChessMetric {

    private static final int[][] KING_KNIGHTS_MOVE_DIRECTIONS = {
            {1, 1}, {1, 0}, {1, -1}, {0, -1},
            {-1, -1}, {-1, 0}, {-1, 1}, {0, 1},

            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {-1, 2}, {1, -2}, {-1, -2}
    };

    private HashMap<String, Long> howManyResultMap = new HashMap<>();

    public long howMany(int size, int[] start, int[] end, int numMoves) {
        if (numMoves == 0 && Arrays.equals(start, end)) {
            return 1L;
        }

        if (numMoves == 0) {
            return 0L;
        }

        String key = makeKey(start, numMoves);
        if (howManyResultMap.get(key) != null) {
            return howManyResultMap.get(key);
        }

        long numberOfPath = 0L;
        for (int directionIndex = 0; directionIndex < KING_KNIGHTS_MOVE_DIRECTIONS.length; directionIndex++) {
            int[] direction = KING_KNIGHTS_MOVE_DIRECTIONS[directionIndex];
            int[] newStart = {start[0] + direction[0], start[1] + direction[1]};

            boolean isValidMove = isValidMove(newStart, size);

            if (isValidMove) {
                numberOfPath += howMany(size, newStart, end, numMoves - 1);
            }
        }

        howManyResultMap.put(key, numberOfPath);
        return numberOfPath;
    }

    private String makeKey(int[] start, int numMoves) {
        return start[0] + "_" + start[1] + "_" + numMoves;
    }

    private boolean isValidMove(int[] point, int size) {
        if (point[0] < 0 || point[0] >= size) {
            return false;
        }
        if (point[1] < 0 || point[1] >= size) {
            return false;
        }

        return true;
    }
}
