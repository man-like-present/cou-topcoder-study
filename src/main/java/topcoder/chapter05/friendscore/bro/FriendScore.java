package topcoder.chapter05.friendscore.bro;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;

import static java.util.Collections.sort;

/**
 * Created by bro. on 2017. 6. 26..
 */

public class FriendScore {
    public int highestScore(String[] friends) {

        if (this.isNotValidInput(friends)) {
            return NumberUtils.INTEGER_MINUS_ONE;
        }

        List<Long> scoreCountList = Lists.newArrayList();

        for (int current = NumberUtils.INTEGER_ZERO; current < friends.length; current++) {

            String me = friends[current];
            char[] myFriends = me.toCharArray();

            List<Long> myDirectFriendIndex = Lists.newArrayList();
            long myFriendCount = NumberUtils.LONG_ZERO;

            for (int target = NumberUtils.INTEGER_ZERO; target < me.length(); target++) {
                if ("Y".equals(String.valueOf(myFriends[target]).toUpperCase())) {
                    // 내 직접 친구의 index를 기록 한다
                    myDirectFriendIndex.add((long) target);
                    // 내 직접 친구의 수를 센다
                    myFriendCount++;
                }
            }
            // 내 직접 친구들의 친구를 확인해가며 전체 친구가 있을 경우 내 친구로 강제 집계
            long globalFriendsCount = this.countGlobalFriend(current, friends, myDirectFriendIndex);

            scoreCountList.add(current, myFriendCount + globalFriendsCount);
        }

        sort(scoreCountList);

        return scoreCountList.get(scoreCountList.size() - NumberUtils.INTEGER_ONE).intValue();
    }

    private boolean isNotValidInput(String[] friends) {
        if (friends.length > 50 || friends.length <= 0) {
            return true;
        }

        for (String friend : friends) {
            if (!friend.matches("[Y|N]+") || friend.length() != friends.length) {
                return true;
            }
        }

        return false;
    }

    private long countGlobalFriend(int current, String[] friends, List<Long> myDirectFrinedIndex) {

        long globalCount = NumberUtils.LONG_ZERO;

        for (Long directedFriend : myDirectFrinedIndex) {
            char[] myDirectFriendFriends = friends[directedFriend.intValue()].toCharArray();

            for (int globalTarget = NumberUtils.INTEGER_ZERO; globalTarget < myDirectFriendFriends.length; globalTarget++) {
                if (globalTarget != current && !myDirectFrinedIndex.contains((long) globalTarget)
                        && "Y".equals(String.valueOf(myDirectFriendFriends[globalTarget]).toUpperCase())) {
                    // 내 직접친구의 친구가 '나'도 아니고 '또 다른 내 직접 친구' 도 아닌데
                    // 내 직접 친구랑은 친구 일 때,
                    globalCount++; // 너, 내 친구가 되라.
                }
            }
        }

        return globalCount;
    }
}
