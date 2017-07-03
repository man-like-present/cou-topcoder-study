package topcoder.chapter05.crazybot.juv;

import java.util.HashMap;

/**
 * @author Juv
 * @since 2017-07-03
 */
public class CrazyBot2 {

    // E, W, S, N 순서대로 X,Y 좌표에 더해줄 값
    private static final int[] DIRECTIONS_X = new int[]{1, -1, 0, 0};
    private static final int[] DIRECTIONS_Y = new int[]{0, 0, 1, -1};
    private static final int DIRECTIONS_SIZE = 4;

    public double getProbability(int n, int east, int west, int south, int north) {
        validate(east, west, south, north);

        // 방문여부 기록
        double[] probability = calculateEachProbability(east, west, south, north);
        HashMap<String, Boolean> isVisited = new HashMap<>();

        return calculateProbabilityOfPath(n, 0, 0, isVisited, probability);
    }

    private double calculateProbabilityOfPath(int depth, int x, int y,
                                              HashMap<String, Boolean> isVisited, double[] probability) {

        // 해당 좌표를 방문한적이 있다면 invalid path이므로 0 리턴
        String key = makeKey(x, y);
        Boolean isVisitedXY = isVisited.get(key);
        if (isVisitedXY != null && isVisitedXY) {
            return 0D;
        }

        // 모든 depth를 연산했으면 default 값 1
        if (depth == 0) {
            return 1D;
        }

        // 해당 좌표를 방문했다고 표시
        isVisited.put(key, true);

        double resultProbability = 0D;
        for (int directions = 0; directions < DIRECTIONS_SIZE; directions++) {
            int newX = x + DIRECTIONS_X[directions];
            int newY = y + DIRECTIONS_Y[directions];
            double probabilityOfChildDepth =
                    calculateProbabilityOfPath(depth - 1, newX, newY, isVisited, probability);
            resultProbability += (probabilityOfChildDepth * probability[directions]);
        }
        isVisited.remove(key);
        return resultProbability;
    }

    private double[] calculateEachProbability(double east, double west, double south, double north) {
        double[] probability = new double[4];
        probability[0] = east / 100;
        probability[1] = west / 100;
        probability[2] = south / 100;
        probability[3] = north / 100;
        return probability;
    }

    private void validate(int east, int west, int south, int north) {
        if (east + west + south + north != 100) {
            throw new IllegalArgumentException();
        }
    }

    private String makeKey(int x, int y) {
        return x + "_" + y;
    }
}
