package topcoder.chapter05.friendscore.bart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FriendScore {

	public int highestScore(String[] friends) {
		Map<Integer, List<Integer>> directFriendMap = buildDirectFriendMap(friends);
		return	directFriendMap.entrySet().stream()
			.map(entry -> {
				int directFriendsCount = entry.getValue().size();
				int friendsFriendsCount = countFriendsFriend(directFriendMap, entry);
				return directFriendsCount + friendsFriendsCount;
			}).max(Integer::compare).get();
	}

	private int countFriendsFriend(Map<Integer, List<Integer>> directFriendMap, Map.Entry<Integer, List<Integer>> entry) {
		Integer me = entry.getKey();
		List<Integer> directFriendsList = entry.getValue();
		return directFriendsList.stream()
						.map(directFriendMap::get)
						.flatMap(List::stream)
						.filter(friendsFriend-> !Objects.equals(friendsFriend, me))
						.filter(friendsFriend-> !directFriendsList.contains(friendsFriend))
						.collect(Collectors.toSet()).size();
	}

	private Map<Integer, List<Integer>> buildDirectFriendMap(String[] friends) {
		Map<Integer, List<Integer>> result = new HashMap<>();
		IntStream.range(0, friends.length).forEach(i -> {
			result.put(i, findDirectFriend(friends[i]));
		});
		return result;
	}

	private List<Integer> findDirectFriend(String s) {
		char[] chars = s.toCharArray();
		return IntStream.range(0, chars.length)
			.filter(i->chars[i]=='Y')
			.mapToObj(Integer::new)
			.collect(Collectors.toList());
	}
}
