package topcoder.chapter07.bad.neighbors.iron;

/**
 * Created with IntelliJ IDEA
 * User: 아이언
 * Date: 2017. 7. 16.
 * Time: 오후 11:05
 */
public class BadNeighbors {

    public static void main(String[] args) {
        BadNeighbors b = new BadNeighbors();
        System.out.println(b.maxDonations(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

    public int maxDonations(int[] donations) {
        // 직전 값 캐시할 array
        int[] cacheZeroSum = new int[donations.length];
        int maxZeroStart = 0;
        for(int i = 0; i < donations.length - 1; i++) {

            if(i == 0) {
                cacheZeroSum[i] = donations[i];
                maxZeroStart = donations[i];

                continue;
            }

            if(i == 1) {
                cacheZeroSum[i] = donations[i];
                maxZeroStart = Math.max(donations[i], donations[i - 1]);

                continue;
            }

            cacheZeroSum[i] =  Math.max(donations[i] + cacheZeroSum[i -2], maxZeroStart);
            maxZeroStart = cacheZeroSum[i];
        }

        // 직전 값 캐시할 array
        int[] cacheOneSum = new int[donations.length];
        int maxOneStart = 0;
        for(int i = 1; i < donations.length; i++) {
            if(i == 1) {
                cacheOneSum[i] = donations[i];
                maxOneStart = Math.max(donations[i], donations[i - 1]);

                continue;
            }

            cacheOneSum[i] =  Math.max(donations[i] + cacheOneSum[i -2], maxOneStart);
            maxOneStart = cacheOneSum[i];
        }

        return Math.max(maxZeroStart, maxOneStart);
    }
}
