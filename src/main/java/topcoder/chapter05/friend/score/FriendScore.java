package topcoder.chapter05.friend.score;

import java.util.HashSet;
import java.util.Set;

public class FriendScore {
	public int highestScore(String[] friends) {
		int max = 0;
		for (int i = 0; i < friends.length; i++) {
			Set<Integer> friendSet = new HashSet<>();
			check(friends, i, friendSet, 1);
			if (friendSet.contains(i)) {
				friendSet.remove(i);
			}
			int size = friendSet.size();
			max = Math.max(size, max);
		}
		return max;
	}

	private void check(String[] friends, int friendNumber, Set<Integer> friendSet, int depth) {
		if (depth > 2) {
			return;
		}
		String friend = friends[friendNumber];
		for (int j = 0; j < friend.length(); j++) {
			if (friend.charAt(j) == 'Y' ) {
				friendSet.add(j);
				check(friends, j, friendSet, depth+1);
			}
		}
	}
}
