package topcoder.chapter07.chess.metric.bro;

/** * Created with Intellij IDEA_17.
 * Date: 2017-07-23
 * Time: 오후 10:38
 * cou-topcoder-study
 * for
 */
public class ChessMetric {

	private static final int THE_TRICKSTER = -1;
	private static final int X_POSITION = 0;
	private static final int Y_POSITION = 1;

	private static final int[][] kingKnightMoves = {
		// kingMovements
		{-1, -1}, {-1, 0}, {-1, 1},
		{0, -1},{0, 1},
		{1, -1}, {1, 0}, {1, 1},
		// knightMovements
		{-2, -1}, {-2, 1},
		{-1, -2}, {-1, 2},
		{1, -2}, { 1, 2 },
		{2, -1}, {2, 1}
	};

	public long howMany(int size, int[] start, int[] end, int numMoves) {
		if (this.isInvalidInput(size, start, end, numMoves)) {
			return THE_TRICKSTER;
		}

		// 시작점에 놓여있는 경우를 case0 으로 보고 1을 더해준다.
		long[][][] movesMatrix = new long[size][size][numMoves+1];
		movesMatrix[start[X_POSITION]][start[Y_POSITION]][0] = 1;

		this.djReCurLetsGetIt(start[X_POSITION], start[Y_POSITION], size, 1, numMoves, movesMatrix);

		return movesMatrix[end[X_POSITION]][end[Y_POSITION]][numMoves];
	}

	private void djReCurLetsGetIt(int xPosition, int yPosition, int size, int nowMoves, int maxMoves, long[][][] movesMatrix) {
		if (nowMoves > maxMoves || !this.isInMatrix(xPosition, yPosition, size)) {
			return;
		}

		for (int[] kingKnightMove : kingKnightMoves) {
			int movedX = xPosition + kingKnightMove[X_POSITION];
			int movedY = yPosition + kingKnightMove[Y_POSITION];

			if (this.isInMatrix(movedX, movedY, size)) {
				movesMatrix[movedX][movedY][nowMoves] += movesMatrix[xPosition][yPosition][nowMoves-1];
				this.djReCurLetsGetIt(movedX, movedY, size, nowMoves+1, maxMoves, movesMatrix);
			}
		}
	}

	private boolean isInMatrix(int xPosition, int yPosition, int size) {
		return xPosition >= 0 && yPosition >= 0 && xPosition < size && yPosition < size;
	}

	private boolean isInvalidInput(int size, int[] start, int[] end, int numMoves) {
		return size < 3 || size > 100
			|| numMoves < 1 || numMoves > 50
			|| this.isInvalidPosition(size, start) || this.isInvalidPosition(size, end);

	}

	private boolean isInvalidPosition(int size, int[] position) {
		if (position.length != 2) {
			return true;
		}

		for (int eachPosition : position) {
			if (eachPosition < 0 || eachPosition > size - 1) {
				return true;
			}
		}

		return false;
	}
}
