package topcoder.chapter05.crazybot.corelle;

/**
 * Created by noblesm on 2017. 7. 3..
 */
public class CrazyBot {

	boolean[][] grid = new boolean[100][100];

	double pEast = 0;
	double pWest = 0;
	double pSouth = 0;
	double pNorth = 0;

	public double getProbability(int n, int east, int west, int south, int north) {
		if (!validCondition(n, east, west, south, north)) {
			return 0;
		}

		pEast = east * 0.01;
		pWest = west * 0.01;
		pSouth = south * 0.01;
		pNorth = north * 0.01;

		return search(n, 50, 50);
	}

	private double search(int n, int x, int y) {
		if (grid[x][y]) {
			return 0;
		}

		if (n == 0) {
			return 1;
		}

		grid[x][y] = true;

		double result = 0;
		result += search(n - 1, x + 1, y) * pEast;
		result += search(n - 1, x - 1, y) * pWest;
		result += search(n - 1, x, y - 1) * pSouth;
		result += search(n - 1, x, y + 1) * pNorth;

		grid[x][y] = false;

		return result;
	}

	private static boolean validCondition(int n, int east, int west, int south, int north) {
		if ((1 <= n && n <= 14)
			&& (0 <= east && east <= 100)
			&& (0 <= west && west <= 100)
			&& (0 <= south && south <= 100)
			&& (0 <= north && north <= 100)
			&& (east + west + south + north == 100)) {
			return true;
		}
		return false;
	}
}
