package topcoder.chapter05.digit.bro;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;

/** * Created with Intellij IDEA_17.
 * User: Scenestealer / Team_Oslo
 * Date: 2017-06-18
 * Time: 오후 10:56
 * cou-topcoder-study
 * for Interesting Digit
 */
public class InterestingDigits {

	public int [] digits(int base) {

		List<Integer> result = Lists.newArrayList();

		for (int denominator = 2 ; denominator < base ; denominator++) {
			if ((base - 1) % denominator == 0) {
				result.add(denominator);
			}
		}

		return this.convertToArray(result);
	}

	private int[] convertToArray(List<Integer> result) {
		int [] convertResult = new int[result.size()];

		int arrayIdx = NumberUtils.INTEGER_ZERO;
		for (Integer digit : result) {
			convertResult[arrayIdx++] = digit;
		}

		return convertResult;
	}
}
