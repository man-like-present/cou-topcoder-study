package topcoder.chapter08.colorful.boxball.mir;

/**
 * @author Mir
 * @since 2017-07-29
 */
public class ColorfulBoxesAndBalls {
    public int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {
        int max = numRed > numBlue ? numBlue : numRed;
        int maxScore = Integer.MIN_VALUE;

        for (int bothCount = 0; bothCount <= max; bothCount++) {
            int score = onlyRed * (numRed - bothCount) + onlyBlue * (numBlue - bothCount) + 2 * bothColors * bothCount;
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
}
