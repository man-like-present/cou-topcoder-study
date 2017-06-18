package topcoder.chapter05.digit.corelle;

import java.util.List;

import org.apache.commons.lang3.time.StopWatch;

import com.google.common.collect.Lists;

/**
 * Created by noblesm on 2017. 6. 17..
 * Limits Time limit (s): 840.000
 * Memory limit (MB): 64
 */
public class InterestingDigit {

	public static void main(String[] args) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		System.out.println("Answer : 10 - {3, 9}");
		System.out.println(digits(10));

		System.out.println("Answer : 3 - {2}");
		System.out.println(digits(3));

		System.out.println("Answer : 9 - {2, 4, 8}");
		System.out.println(digits(9));

		System.out.println("Answer : 26 - {5, 25}");
		System.out.println(digits(26));

		System.out.println("Answer : 30 - {29}");
		System.out.println(digits(30));

		System.out.println("Progress End !!! : " + stopWatch.toString());
	}

	/**
	 * 2 ~ 세자리까지 n의 배수이면서 각 자리의 합이 n의 배수인 n을 찾는다
	 * @param n
	 * @return
	 */
	private static List<Integer> digits(int n) {
		int end = ((n-1) * (n * n)) + ((n-1) * n) + (n-1);

		List<Integer> results = Lists.newArrayList();

		for (int i = 2; i < n; i++) {
			boolean flag = true;

			for (int j = 2; j <= end; j++) {
				if (j % i != 0) {
					continue;
				}

				int a = j / (n * n); // 세번째 자리수
				int temp = j % (n * n); // 나머지 두자리수
				int b = temp / n; // 두번째 자리수
				int c = temp % n; // 세번째 자리수
				int sum = a + b + c;

//				int sum = getSum(j, n);

				if (sum % i != 0) {
					flag = false;
				}
			}

			if (flag) {
				results.add(i);
			}
		}

		return results;
	}

	private static int getSum(int j, int n) {
		int sum = 0;
		int temp = j;

		while(true){
			sum += temp % n;
			temp = temp / n;
			if(temp < n){
				sum += temp;
				break;
			}
		}
		return sum;
	}
}
