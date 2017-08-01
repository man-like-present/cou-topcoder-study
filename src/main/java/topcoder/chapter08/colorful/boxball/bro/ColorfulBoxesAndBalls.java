package topcoder.chapter08.colorful.boxball.bro;

/** * Created with Intellij IDEA_17.
 * Date: 2017-07-30
 * Time: 오후 11:10
 * cou-topcoder-study
 * for
 */
public class ColorfulBoxesAndBalls {

	private static final int THE_TRICKSTER = -1;
	private static final int MIN_NUM = 1;
	private static final int MAX_NUM = 1000;
	private static final int MIN_VALUE = -1000;
	private static final int MAX_VALUE = 1000;

	private static final int INTEGER_ZERO = 0;

	public int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {
		if (this.isInvalidInput(numRed, numBlue, onlyRed, onlyBlue, bothColors)) {
			return THE_TRICKSTER;
		}

		int diffRedAndBoth = bothColors - onlyRed;
		int diffBlueAndBoth = bothColors - onlyBlue;

		int i = INTEGER_ZERO;
		int result = (onlyRed * numRed) + (onlyBlue * numBlue);

		// 증감분이 음수일 경우 더 계산할 필요가 없다
		while ((diffRedAndBoth + diffBlueAndBoth) > INTEGER_ZERO) {
			int tempResult = (onlyRed * (numRed - i)) + (onlyBlue * (numBlue - i)) + (bothColors * (i * 2));

			if (!this.isMaximumResult(i++, numRed, numBlue, tempResult, result)) {
				result = tempResult;
			} else {
				break;
			}
		}

		return result;
	}

	private boolean isMaximumResult(int i, int numRed, int numBlue, int tempResult, int result) {
		return numRed - i < INTEGER_ZERO || numBlue - i < INTEGER_ZERO || tempResult < result;
	}

	private boolean isInvalidInput(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {
		return this.isInvalidNumber(numRed) || this.isInvalidNumber(numBlue)
			|| this.isInvalidValue(onlyRed) || this.isInvalidValue(onlyBlue) || this.isInvalidValue(bothColors);

	}

	private boolean isInvalidValue(int value) {
		return value < MIN_VALUE || value > MAX_VALUE;
	}

	private boolean isInvalidNumber(int number) {
		return number < MIN_NUM || number > MAX_NUM;
	}
}
