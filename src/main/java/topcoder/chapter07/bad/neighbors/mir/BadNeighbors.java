package topcoder.chapter07.bad.neighbors.mir;

import java.util.Arrays;

public class BadNeighbors {

    public int maxDonations(int[] donations) {
        int[] includeZeroPosition = Arrays.copyOfRange(donations, 0, donations.length - 1);
        int[] excludeZeroPosition = Arrays.copyOfRange(donations, 1, donations.length);
        return Math.max(findMaxDonationPrice(includeZeroPosition), findMaxDonationPrice(excludeZeroPosition));
    }

    private int findMaxDonationPrice(int[] donations) {
        Integer[] accumulatedDonation = new Integer[donations.length];
        for (int i = 0; i < donations.length; i++) {
            if (i == 0 || i == 1) {
                accumulatedDonation[i] = donations[i];
            } else if (i == 2) {
                accumulatedDonation[i] = donations[i] + accumulatedDonation[0];
            } else {
                int selectedDonationPrice = accumulatedDonation[i - 2] > accumulatedDonation[i - 3] ? accumulatedDonation[i - 2] : accumulatedDonation[i - 3];
                accumulatedDonation[i] = donations[i] + selectedDonationPrice;
            }
        }
        Arrays.sort(accumulatedDonation, (o1, o2) -> o2 - o1);
        return accumulatedDonation[0];
    }
}
