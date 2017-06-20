package topcoder.chapter05.cryptography.bro;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

/** * Created with Intellij IDEA_17.
 * User: Scenestealer / Team_Oslo
 * Date: 2017-06-18
 * Time: 오후 10:04
 * for cou-topcoder-study
 */

public class Cryptography {
	public long encrypt(int[] numbers) {
		if (this.isNotValidLengthArray(numbers)) {
			return NumberUtils.LONG_ZERO;
		}

		long minNumber = NumberUtils.LONG_ZERO;
		long encryptResult = NumberUtils.LONG_ONE;

		for (long number : numbers) {
			if (number <= 1000 && number >= 1) {
				if (minNumber == NumberUtils.LONG_ZERO) {
					minNumber = number;
				} else if (minNumber != number && minNumber > number) {
					encryptResult *= minNumber;
					minNumber = number;
				} else {
					encryptResult *= number;
				}
			}
		}

		encryptResult *= (minNumber + NumberUtils.INTEGER_ONE);

		return encryptResult;
	}

	private boolean isNotValidLengthArray(int[] numbers) {
		return ArrayUtils.isEmpty(numbers) || numbers.length > 50;
	}
}
