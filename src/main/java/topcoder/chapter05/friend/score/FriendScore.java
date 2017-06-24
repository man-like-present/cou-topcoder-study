package topcoder.chapter05.friend.score;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Juv
 * @since 2017-06-23
 */
public class FriendScore {

    private static final char IS_FRIEND = 'Y';

    public static int getNumberOfFriendsOfPopularPeople(String[] friends) {
        return 0;
    }

    public static void main(String[] args) {
        String[] friends1 = new String[]{"NNN", "NNN", "NNN"};
        String[] friends2 = new String[]{"NYY", "YNY", "YYN"};
        String[] friends = new String[]{"NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN"};

        ArrayList<HashSet<Integer>> numberOfFriends = new ArrayList<>();
        for (int i = 0; i < friends.length; i++) {
            HashSet<Integer> idOfFriends = new HashSet<>();

            idOfFriends.addAll(getIdOfFriends(friends[i]));

            HashSet<Integer> secondDepthFriends = new HashSet<>();
            for (Integer idOfFriend : idOfFriends) {
                secondDepthFriends.addAll(getIdOfFriends(friends[idOfFriend]));
            }
            idOfFriends.addAll(secondDepthFriends);
            idOfFriends.remove(i);
            numberOfFriends.add(i, idOfFriends);
        }
        System.out.println(numberOfFriends);
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
