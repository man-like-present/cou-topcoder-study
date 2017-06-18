package topcoder.chapter05.cryptography.corelle;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Created by noblesm on 2017. 6. 17..
 */
public class Cryptography {

	public static void main(String[] args) {
		List<Long> ex1 = Lists.newArrayList(1L, 3L, 2L, 1L, 1L, 3L);
		List<Long> ex2 = Lists.newArrayList(1000L, 999L, 998L, 997L, 996L, 995L);

		System.out.println("Answer: 36");
		System.out.println("Return: " + encrypt(ex1));
		System.out.println("Answer: 986074810223904000");
		System.out.println("Return: " + encrypt(ex2));
	}

	/**
	 * 최소값에 +1을 한후 전체를 곱하기한다
	 * 최소값은 오름차순 정렬을 하여 index : 0 으로 판단
	 * @param inputs
	 * @return
	 */
	private static Long encrypt(List<Long> inputs) {
		Collections.sort(inputs, Comparator.comparingLong(o -> o));

		Long result = 1L;

		for (int i = 0; i < inputs.size(); i++) {
			long input = inputs.get(i);

			if (i == 0) {
				input += 1;
			}

			result = result * input;
		}

		return result;
	}

}
