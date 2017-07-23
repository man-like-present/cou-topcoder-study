package topcoder.chapter07.bad.neighbors.bro;

import java.util.Arrays;

/** * Created with Intellij IDEA_17.
 * User: Bro.
 * Date: 2017-07-17
 * Time: 오후 11:21
 * cou-topcoder-study
 * for
 */
public class BadNeighbors {

	private static final int THE_TRICKSTER = -1;

	private static final int MY_NEIGHBOR_INDEX = 2;
	private static final int MY_NEIGHBORS_NEIGHBOR_INDEX = 3;

	public int maxDonations(int[] donations) {
		if (this.isInvalidInput(donations)) {
			return THE_TRICKSTER;
		}

		int result = 0;
		for (int start = 0; donations.length - 1 + start <= donations.length; start++) {
			result = Math.max(result, this.findMaxDonation(start, (donations.length - 1 + start), donations));
		}

		return result;
	}

	private int findMaxDonation(int start, int end, int[] donations) {

		int cases[] = new int[donations.length];
		for (int index = start; index < end; index++) {
			if (index == start || index == (start + 1)) {
				cases[index] = donations[index];
			} else if (index == (start + MY_NEIGHBOR_INDEX)){
				cases[index] = donations[index] + cases[index - MY_NEIGHBOR_INDEX];
			} else {
				cases[index] = donations[index] + Math.max(cases[index - MY_NEIGHBOR_INDEX], cases[index - MY_NEIGHBORS_NEIGHBOR_INDEX]);
			}
		}

		Arrays.sort(cases);
		return cases[donations.length - 1];
	}

	private boolean isInvalidInput(int[] donations) {
		if (donations.length < 2 || donations.length > 40) {
			return true;
		}

		for (int eachInput : donations) {
			if (eachInput < 1 || eachInput > 1000) {
				return true;
			}
		}

		return false;
	}
}
