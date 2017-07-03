package topcoder.chapter05.crazybot.bart;

// 답을 참고했음 ㅠ
public class CrazyBot {
	 double[] prob = new double[4];
	 boolean[][] location;
	 int[] xVal = {1, -1, 0, 0};
	 int[] yVal = {0, 0, -1, 1};

	public  double getProbability(int n, int east, int west, int south, int north){
		initProbability(east, west, south, north);
		initLocation(n);
		return dfs(n, n, n);
	}

	private  double dfs(int x, int y, int depth) {
		if(location[x][y]) {
			return 0;
		}

		if(depth == 0) {
			return 1;
		}

		location[x][y] = true;
		double result = 0;
		for(int direction=0; direction<4; direction++) {
			if(prob[direction] == 0) {
				continue;
			}
			result += dfs(x+xVal[direction], y+yVal[direction], depth-1) * prob[direction];
		}

		location[x][y] = false;
		return result;
	}

	private  void initLocation(int n) {
		location = new boolean[2*n+1][2*n+1];
	}

	private  void initProbability(int east, int west, int south, int north) {
		prob[0] = east * 0.01;
		prob[1] = west * 0.01;
		prob[2] = south * 0.01;
		prob[3] = north * 0.01;
	}

}
