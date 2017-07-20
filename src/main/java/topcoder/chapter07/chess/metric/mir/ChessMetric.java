package topcoder.chapter07.chess.metric.mir;

import java.util.LinkedList;
import java.util.Queue;

public class ChessMetric {
    private static final int L[][] = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    private static final int X[][] = {{1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};

    private static final Queue<Point> queue = new LinkedList<>();

    public long howMany(int size, int[] start, int[] end, int numMoves) {
        int resultCount = 0;
        int startX = start[0];
        int startY = start[1];
        int endX = end[0];
        int endY = end[1];
        queue.add(new Point(startX, startY, 0));

        Point poll;
        while ((poll = queue.poll()) != null) {
            if (poll.count == numMoves) {
                if (endX == poll.x && endY == poll.y) {
                    resultCount++;
                }
            } else {
                moveKing(poll, L, size);
                moveKing(poll, X, size);
            }
        }

        return resultCount;
    }

    private void moveKing(Point point, int[][] move, int size) {
        for (int i = 0; i < 8; i++) {
            int moveX = move[i][0] + point.x;
            int moveY = move[i][1] + point.y;
            if (moveX >= 0 && moveX < size && moveY >= 0 && moveY < size) {
                queue.add(new Point(moveX, moveY, point.count + 1));
            }
        }
    }

    private class Point {
        public int x;
        public int y;
        public int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
