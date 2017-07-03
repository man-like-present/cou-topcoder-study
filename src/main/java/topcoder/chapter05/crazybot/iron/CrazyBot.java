package topcoder.chapter05.crazybot.iron;

/**
 * Created with IntelliJ IDEA
 * User: 아이언
 * Date: 2017. 7. 2.
 * Time: 오후 2:51
 */
public class CrazyBot {
    boolean[][] move = new boolean[50][50];
    double[] probability = new double[4];
    double res = 0.0;

    public static void main(String[] args) {
        CrazyBot bot = new CrazyBot();
        System.out.println(bot.getProbability(2, 25, 25, 25, 25));
    }

    private void explore(int i, double p, int x, int y) {
        if (move[x][y])
            return;

        if (i == 0) {
            res += p;
            return;
        } else {
            i--;
        }

        move[x][y] = true;
        explore(i, p * probability[3], x, y+1);
        explore(i, p * probability[2], x, y-1);
        explore(i, p * probability[1], x-1, y);
        explore(i, p * probability[0], x+1, y);
    }

    public double getProbability(int n, int east, int west, int south, int north) {
        probability[0] = east / 100.0;
        probability[1] = west / 100.0;
        probability[2] = south / 100.0;
        probability[3] = north / 100.0;

        for (int i = 0; i < 50; ++i)
            for (int j = 0; j < 50; ++j)
                move[j][i] = false;

        explore(n, 1, 20, 20);
        return res;
    }
}
