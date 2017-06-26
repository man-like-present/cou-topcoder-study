package topcoder.chapter05.friendscore.juv;

import java.util.HashSet;

/**
 * @author Juv
 * @since 2017-06-23
 */
public class FriendScore {

    private static final char IS_FRIEND = 'Y';

    public static int getNumberOfFriendsOfPopularPeople(String[] friends) {
        int greatest = 0;
        for (int i = 0; i < friends.length; i++) {
            HashSet<Integer> idOfFriends = new HashSet<>();

            idOfFriends.addAll(getIdOfFriends(friends[i]));
            idOfFriends.addAll(getIdOfSecondDepthFriends(friends, idOfFriends));

            idOfFriends.remove(i);
            greatest = greatest > idOfFriends.size() ? greatest : idOfFriends.size();
        }
        return greatest;
    }

    private static HashSet<Integer> getIdOfSecondDepthFriends(String[] friends, HashSet<Integer> idOfFriends) {
        HashSet<Integer> secondDepthFriends = new HashSet<>();
        for (Integer idOfFriend : idOfFriends) {
            secondDepthFriends.addAll(getIdOfFriends(friends[idOfFriend]));
        }
        return secondDepthFriends;
    }

    private static HashSet<Integer> getIdOfFriends(String friend) {
        char[] isFriend = friend.toCharArray();

        HashSet<Integer> ids = new HashSet<>();
        for (int i = 0; i < isFriend.length; i++) {
            if (IS_FRIEND == isFriend[i]) {
                ids.add(i);
            }
        }
        return ids;
    }
}
