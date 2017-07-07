package topcoder.chapter05.mazemaker.mir;

import java.util.LinkedList;
import java.util.Queue;

public class MazeMaker {
	private char[][] mazeChar;
	private Queue<Point> pointQueue = new LinkedList<>();

	public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
		int rowLength = maze.length;
		int colLength = maze[0].length();
		this.mazeChar = new char[rowLength][colLength];

		for (int i = 0; i < rowLength; i++) {
			this.mazeChar[i] = maze[i].toCharArray();
		}
		int length = moveCol.length;
		pointQueue.add(new Point(startCol, startRow, 0));
		mazeChar[startRow][startCol] = 'X';
		int max = 0;


		while (pointQueue.size() != 0) {
			Point poll = pointQueue.poll();
			for (int i = 0; i < length; i++) {
				int nextCol = poll.x + moveCol[i];
				int nextRow = poll.y + moveRow[i];
				int count = poll.count + 1;
				if (nextCol >= 0 & nextCol < colLength & nextRow >= 0 & nextRow < rowLength) {
					if (mazeChar[nextRow][nextCol] == '.') {
						pointQueue.add(new Point(nextCol, nextRow, count));
						mazeChar[nextRow][nextCol] = 'X';
						max = Math.max(count, max);
					}
				}
			}
		}
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				if (mazeChar[i][j] == '.')
					return -1;
			}
		}
		return max;
	}

	class Point {
		int x;
		int y;
		int count;

		Point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
