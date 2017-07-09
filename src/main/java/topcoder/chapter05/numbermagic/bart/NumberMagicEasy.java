package topcoder.chapter05.numbermagic.bart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberMagicEasy {

	private static final int NUMBER_LIMIT = 16;
	private static final int INVALID_VALUE = -1;
	private int[][] cardList = {
		{1,2,3,4,5,6,7,8},
		{1,2,3,4,9,10,11,12},
		{1,2,5,6,9,10,13,14},
		{1,3,5,7,9,11,13,15}
	};

	private Map<Integer, List<Character>> answerMap;
	public NumberMagicEasy() {
		this.answerMap = initAnswerMap();
	}

	private Map<Integer, List<Character>> initAnswerMap() {
		Map<Integer, List<Character>> answerMap = new HashMap<>();
		for(int i = 1; i <= NUMBER_LIMIT; i ++) {
			answerMap.put(i, Arrays.asList('N','N','N','N'));
		}

		for(int i = 0; i < cardList.length; i++) {
			int[] card = cardList[i];
			int index = i;
			Arrays.stream(card).forEach(number -> {
				List<Character> commandList = answerMap.get(number);
				commandList.set(index, 'Y');
			});
		}
		return answerMap;
	}

	public int theNumber(String answer) {
		return answerMap.entrySet().stream()
			.filter(entry -> this.findAnswer(answer, entry.getValue()))
			.map(Map.Entry::getKey).findFirst().orElse(INVALID_VALUE);

	}

	private boolean findAnswer(String answer, List<Character> commandList) {
		StringBuilder builder = new StringBuilder();
		commandList.forEach(builder::append);
		return answer.equals(builder.toString());
	}
}
