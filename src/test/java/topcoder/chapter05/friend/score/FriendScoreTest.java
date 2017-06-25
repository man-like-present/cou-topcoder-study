package topcoder.chapter05.friend.score;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Juv
 * @since 2017-06-26
 */
public class FriendScoreTest {
    @Test
    public void getNumberOfFriendsOfPopularPeople_case1() throws Exception {
        // Given
        String[] friends = new String[]{"NNN", "NNN", "NNN"};
        int expected = 0;

        // When
        int actual = FriendScore.getNumberOfFriendsOfPopularPeople(friends);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfFriendsOfPopularPeople_case2() throws Exception {
        // Given
        String[] friends = new String[]{"NYY", "YNY", "YYN"};
        int expected = 2;

        // When
        int actual = FriendScore.getNumberOfFriendsOfPopularPeople(friends);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfFriendsOfPopularPeople_case3() throws Exception {
        // Given
        String[] friends = new String[]{"NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN"};
        int expected = 4;

        // When
        int actual = FriendScore.getNumberOfFriendsOfPopularPeople(friends);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfFriendsOfPopularPeople_case4() throws Exception {
        // Given
        String[] friends = new String[]{"NNNNYNNNNN",
                "NNNNYNYYNN",
                "NNNYYYNNNN",
                "NNYNNNNNNN",
                "YYYNNNNNNY",
                "NNYNNNNNYN",
                "NYNNNNNYNN",
                "NYNNNNYNNN",
                "NNNNNYNNNN",
                "NNNNYNNNNN"};
        int expected = 8;

        // When
        int actual = FriendScore.getNumberOfFriendsOfPopularPeople(friends);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfFriendsOfPopularPeople_case5() throws Exception {
        // Given
        String[] friends = new String[]{"NNNNNNNNNNNNNNY",
                "NNNNNNNNNNNNNNN",
                "NNNNNNNYNNNNNNN",
                "NNNNNNNYNNNNNNY",
                "NNNNNNNNNNNNNNY",
                "NNNNNNNNYNNNNNN",
                "NNNNNNNNNNNNNNN",
                "NNYYNNNNNNNNNNN",
                "NNNNNYNNNNNYNNN",
                "NNNNNNNNNNNNNNY",
                "NNNNNNNNNNNNNNN",
                "NNNNNNNNYNNNNNN",
                "NNNNNNNNNNNNNNN",
                "NNNNNNNNNNNNNNN",
                "YNNYYNNNNYNNNNN"};
        int expected = 6;

        // When
        int actual = FriendScore.getNumberOfFriendsOfPopularPeople(friends);

        // Then
        Assert.assertEquals(expected, actual);
    }
}