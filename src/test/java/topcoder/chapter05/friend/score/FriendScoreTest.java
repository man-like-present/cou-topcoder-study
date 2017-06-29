package topcoder.chapter05.friend.score;

import org.junit.Assert;
import org.junit.Test;
import topcoder.chapter05.friendscore.mir.FriendScore;

public class FriendScoreTest {
	@Test
	public void friend_score_case1() throws Exception {
		String str1 = "NNN";
		String str2 = "NNN";
		String str3 = "NNN";
		String[] strings = new String[3];
		strings[0] = str1;
		strings[1] = str2;
		strings[2] = str3;
		// When
		FriendScore friendScore = new FriendScore();
		int result = friendScore.highestScore(strings);

		// Then
		Assert.assertEquals(0, result);
	}

	@Test
	public void friend_score_case2() throws Exception {
		String str1 = "NYY";
		String str2 = "YNY";
		String str3 = "YYN";
		String[] strings = new String[3];
		strings[0] = str1;
		strings[1] = str2;
		strings[2] = str3;
		// When
		FriendScore friendScore = new FriendScore();
		int result = friendScore.highestScore(strings);

		// Then
		Assert.assertEquals(2, result);
	}

	@Test
	public void friend_score_case3() throws Exception {
		String str1 = "NYNNN";
		String str2 = "YNYNN";
		String str3 = "NYNYN";
		String str4 = "NNYNY";
		String str5 = "NNNYN";
		String[] strings = new String[5];
		strings[0] = str1;
		strings[1] = str2;
		strings[2] = str3;
		strings[3] = str4;
		strings[4] = str5;
		// When
		FriendScore friendScore = new FriendScore();
		int result = friendScore.highestScore(strings);

		// Then
		Assert.assertEquals(4, result);
	}


	@Test
	public void friend_score_case4() throws Exception {
		String str0 = "NNNNYNNNNN";
		String str1 = "NNNNYNYYNN";
		String str2 = "NNNYYYNNNN";
		String str3 = "NNYNNNNNNN";
		String str4 = "YYYNNNNNNY";
		String str5 = "NNYNNNNNYN";
		String str6 = "NYNNNNNYNN";
		String str7 = "NYNNNNYNNN";
		String str8 = "NNNNNYNNNN";
		String str9 = "NNNNYNNNNN";
		String[] strings = new String[10];
		strings[0] = str0;
		strings[1] = str1;
		strings[2] = str2;
		strings[3] = str3;
		strings[4] = str4;
		strings[5] = str5;
		strings[6] = str6;
		strings[7] = str7;
		strings[8] = str8;
		strings[9] = str9;
		// When
		FriendScore friendScore = new FriendScore();
		int result = friendScore.highestScore(strings);

		// Then
		Assert.assertEquals(8, result);
	}
}