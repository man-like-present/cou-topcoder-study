package topcoder.chapter07.chess.metric.bart;

import java.util.HashMap;
import java.util.Map;

//juv 님을 참조했음
public class ChessMetric {

	private static final int[][] KING_KNIGHTS_MOVING = {
		{-2,-1},{-2,1},
		{-1,-2},{-1,-1},{-1,0},{-1,1},{-1,2},
		{0,-1},{0,1},
		{1,-2},{1,-1},{1,0},{1,1},{1,2},
		{2,-1},{2,1}
	};

//	private long[][][] memory = new long[100][100][55]; // 5번이 안돌아감;
	private Map<String, Long> memory = new HashMap();

	public long howMany(int size, int[] start, int[] end, int numMoves) {
		if(numMoves == 0
			&& start[0] == end[0]
			&& start[1] == end[1]) {
			return 1;
		}

		if(numMoves == 0) {
			return 0;
		}

		String key= makeKey(start, numMoves);
		if(memory.get(key) != null) {
			return memory.get(key);
		}

		long result = 0;
		for(int[] moving : KING_KNIGHTS_MOVING) {
			int[] prevPoint = {start[0] + moving[0], start[1] + moving[1]};

			if(isAvailablePoint(size, prevPoint)) {
				result += howMany(size, prevPoint, end, numMoves-1);
			}
		}

		memory.put(key, result);
		return result;
	}

	private String makeKey(int[] start, int numMoves) {
		return start[0] + "_" + start[1] + "_" + numMoves;
	}

	private boolean isAvailablePoint(int size, int[] next) {
		return next[0] >= 0 && next[1] >= 0 &&
			next[0] < size && next[1] < size;
	}
}
