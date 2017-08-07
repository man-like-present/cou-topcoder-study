package topcoder.chapter07.hands.shaking.bro;

/** * Created with Intellij IDEA_17.
 * Date: 2017-07-23
 * Time: 오후 10:38
 * cou-topcoder-study
 * for
 */
public class HandsShaking {

	private static final int THE_TRICKSTER = -1;
	private static final int MIN_CASE = 1;

	public long countPerfect(int n) {
		if (this.isInvalidInput(n)) {
			return THE_TRICKSTER;
		}

		long[] shakingMemory = new long[n/2+1];
		shakingMemory[0] = MIN_CASE;
		for (int repeat = 1 ; repeat <= n/2 ; repeat++) {
			shakingMemory[repeat] = 0;
			this.letsGetIt(repeat, shakingMemory);
		}

		return shakingMemory[n/2];
	}

	private void letsGetIt(int n, long[] shakingMemory) {
		for (int i = 0 ; i < n ; i++) {
			shakingMemory[n] += shakingMemory[i] * shakingMemory[n -i -1];
		}
	}

	private boolean isInvalidInput(int n) {
		return n % 2 != 0 || n < 2 || n > 50;
	}
}