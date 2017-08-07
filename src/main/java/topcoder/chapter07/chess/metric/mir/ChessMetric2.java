package topcoder.chapter07.chess.metric.mir;

import com.google.common.base.Stopwatch;
import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChessMetric2 {
    private static final int L[][] = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    private static final int X[][] = {{1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};

    public Map<Point, Long> map;

    public long howMany(int size, int[] start, int[] end, int numMoves) {
        StopWatch started = new StopWatch();
        started.start();
        map = new ConcurrentHashMap<>();
        Point startPoint = new Point(start[0], start[1]);
        Point endPoint = new Point(end[0], end[1]);

        map.put(startPoint, 1L);

        for (int i = 0; i < numMoves; i++) {
            Map<Point, Long> currentMap = new HashMap<>(map);
            map = new ConcurrentHashMap<>();
            currentMap.entrySet().parallelStream()
            .forEach(pointLongEntry -> {
                moveKing(pointLongEntry.getKey(), L, pointLongEntry.getValue(), size);
                moveKing(pointLongEntry.getKey(), X, pointLongEntry.getValue(), size);
            });
        }
        return map.getOrDefault(endPoint, 0L);
    }

    private void moveKing(Point point, int[][] move, Long count, int size) {
        for (int i = 0; i < 8; i++) {
            int moveX = move[i][0] + point.x;
            int moveY = move[i][1] + point.y;
            if (isPossible(moveX, moveY, size)) {
                Point key = new Point(moveX, moveY);
                if (map.containsKey(key)) {
                    if (Long.MAX_VALUE - map.get(key) > count) {
                        long value = map.get(key) + count;
                        map.put(key, value);
                    }
                } else {
                    map.put(key, count);
                }
            }
        }
    }

    private boolean isPossible(int moveX, int moveY, int size) {
        return moveX >= 0 && moveX < size && moveY >= 0 && moveY < size;
    }

    private class Point {
        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object object) {
            Point point = (Point) object;
            return (this.x == point.x) && (this.y == point.y);
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
}
