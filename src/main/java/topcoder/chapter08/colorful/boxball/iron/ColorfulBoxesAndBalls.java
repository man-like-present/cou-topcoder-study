package topcoder.chapter08.colorful.boxball.iron;

/**
 * Created with IntelliJ IDEA
 * User: 아이언
 * Date: 2017. 7. 30.
 * Time: 오후 10:34
 */
public class ColorfulBoxesAndBalls {

    // 값 음수일 때 처리

    int[] blue = new int[2];
    int[] red = new int[2];

    public int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {

        blue[0] = numBlue;
        blue[1] = onlyBlue;

        red[0] = numRed;
        red[1] = onlyRed;

        int maxNum = 0, minCount = 0;
        // bothColors 음수일 때 처리 (*2)
        if (blue[1] + red[1] < bothColors * 2) {
            minCount = Math.min(blue[0], red[0]);
            maxNum = bothColors * minCount;
            blue[0] -= minCount;
            red[0] -= minCount;
        }

        maxNum += (blue[0] * blue[1]);
        maxNum += (red[0] * red[1]);

        return maxNum;
    }
}
