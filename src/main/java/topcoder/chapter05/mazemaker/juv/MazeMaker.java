package topcoder.chapter05.mazemaker.juv;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author Juv
 * @since 2017-06-30
 */
public class MazeMaker {

    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(Point point, int moveX, int moveY) {
            this.x = point.x + moveX;
            this.y = point.y + moveY;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private static final char DISABLE = 'X';

    public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
        validate(maze, startRow, startCol, moveRow, moveCol);

        int rowSize = maze.length;
        int colSize = maze[0].length();

        int directionSize = moveCol.length;

        HashMap<Point, Boolean> isVisited = new HashMap<>();
        Point startPoint = new Point(startRow, startCol);
        isVisited.put(startPoint, true);

        Deque<Point> deque = new ArrayDeque<>();
        deque.addLast(startPoint);

        while (deque.isEmpty()) {
            Point point = deque.getFirst();
            for (int i = 0; i < directionSize; i++) {
                int movedX = point.getX() + moveCol[directionSize];
                int movedY = point.getY() + moveRow[directionSize];
                if(DISABLE != maze[movedY].indexOf(movedX)) {
                    deque.addFirst(new Point(point, movedX, movedY));
                }
            }
        }

        return 0;
    }

    private void validate(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {

    }

    private String makeKey(int x, int y) {
        return x + "_" + y;
    }
}
