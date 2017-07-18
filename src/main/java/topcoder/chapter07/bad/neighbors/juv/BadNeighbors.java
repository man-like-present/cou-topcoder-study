package topcoder.chapter07.bad.neighbors.juv;

/**
 * @author Juv
 * @since 2017-07-16
 */
public class BadNeighbors {
    public int maxDonations(int[] donations) {

        return maxDonations(donations, 0, donations.length - 1);
    }

    private int maxDonations(int[] donations, int left, int right) {

        if (left > right) {
            return 0;
        }
        if (left == right) {
            return donations[left];
        }

        int end = (right > left + 2) ? (left + 2) : right;

        int max = 0;
        for (int i = left; i <= end; i++) {
            int newRight = (i == 0) ? right - 1 : right;
            int sum = donations[i] + maxDonations(donations, i + 2, newRight);
            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }
}
