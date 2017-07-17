package topcoder.chapter07.bad.neighbors.juv;

/**
 * @author Juv
 * @since 2017-07-16
 */
public class BadNeighbors2 {

    public int maxDonations(int[] donations) {

        int maxDonation = 0;
        for (int start = 0; start < 2; start++) {
            int[] maxByStep = new int[donations.length];
            int lastNeighbor = donations.length - 2 + start;
            for (int neighbor = start; neighbor <= lastNeighbor; neighbor++) {
                calculateMaxByStep(donations, maxByStep, start, neighbor);
            }
            maxDonation = getMaxValue(maxByStep[lastNeighbor], maxDonation);
        }

        return maxDonation;
    }

    private void calculateMaxByStep(int[] donations, int[] maxByStep, int start, int neighbor) {
        if (neighbor == start) {
            maxByStep[neighbor] = donations[neighbor];
        }
        if (neighbor > 0) {
            int prevMax = getMaxValue(maxByStep[neighbor - 1], maxByStep[neighbor]);
            int currentMax = neighbor > 1 ? maxByStep[neighbor - 2] + donations[neighbor] : donations[neighbor];
            maxByStep[neighbor] = getMaxValue(prevMax, currentMax);
        }
    }

    private int getMaxValue(int v1, int v2) {
        return v1 > v2 ? v1 : v2;
    }

}
