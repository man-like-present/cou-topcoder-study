package topcoder.chapter05.crazybot.mir;

public class CrazyBot {
    private static final int center = 14;
    private static final int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static double[] probabilities;
    private boolean[][] map;
    private double sumByArrived;
    private int max;
    public double getProbability(int n, int east, int west, int south, int north) {
        map = new boolean[201][201];
        sumByArrived = 0.0;
        max = n;
        probabilities = new double[]{(double) north / 100, (double) east / 100, (double) south / 100, (double) west / 100};
        int x = center;
        int y = center;
        map[center][center] = true;
        check(x, y, 0, 1);
        return sumByArrived;
    }

    private void check(int x, int y, int count, double probability) {
        if (count == max) {
            sumByArrived += probability;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + direct[i][0];
            int nextY = y + direct[i][1];
            if (!map[nextX][nextY]) {
                map[nextX][nextY] = true;
                check(nextX, nextY, count + 1, probability * probabilities[i]);
                map[nextX][nextY] = false;
            }
        }
    }
}
