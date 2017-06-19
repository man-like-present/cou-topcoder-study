package topcoder.chapter05.cryptography.bart;

import java.util.Arrays;

public class Cryptography {
	public long encrypt(int[] numbers) {
		Arrays.sort(numbers);
		numbers[0] = numbers[0]+1;
		long result = 1;
		for(int index = 0; index < numbers.length; index++ ) {
			result = result * numbers[index];
		}
		return result;
	}
}
