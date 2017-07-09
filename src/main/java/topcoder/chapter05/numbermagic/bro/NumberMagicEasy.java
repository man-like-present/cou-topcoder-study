package topcoder.chapter05.numbermagic.bro;

/** * Created with Intellij IDEA_17.
 * cou-topcoder-study
 * for
 */
public class NumberMagicEasy {

	private static final char YES = 'Y';
	private static final char NO = 'N';

	private static final int FIRST_INDEX = 1;
	private static final int THE_TRICKSTER = 16;

	private static final String[] BICYCLE_CARDS = new String[]{
		"1, 2, 3, 4, 5, 6, 7, 8,",
		"1, 2, 3, 4, 9, 10, 11, 12,",
		"1, 2, 5, 6, 9, 10, 13, 14,",
		"1, 3, 5, 7, 9, 11, 13, 15,"
	};

	public int theNumber(String answer) {
		if (this.isInvalidAnswer(answer)) {
			return THE_TRICKSTER;
		}

		String matchResult;
		for (int candidate = FIRST_INDEX; candidate < THE_TRICKSTER; candidate++) {
			matchResult = this.getMatchResult(candidate);

			if (answer.equals(matchResult)) {
				return candidate;
			}
		}

		System.out.println("Trickster!! You insulted me!!");
		return THE_TRICKSTER;
	}

	private String getMatchResult(int candidate) {
		StringBuilder result = new StringBuilder();

		for (String eachCard : BICYCLE_CARDS) {
			if (eachCard.contains(candidate + ",")) {
				result.append(YES);
			} else {
				result.append(NO);
			}
		}

		return result.toString();
	}

	private boolean isInvalidAnswer(String userInput) {

		if (userInput.matches("/[YN]{4}/")) {
			System.out.println("Trickster!! You must answer only use the Y or N and max length 4.");
			return true;
		}

		return false;
	}
}
