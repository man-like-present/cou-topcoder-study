package topcoder.chapter08.batch.system.mir;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BatchSystemTest {
    private BatchSystem batchSystem;

    @Before
    public void setUp() throws Exception {
        batchSystem = new BatchSystem();
    }

    @Test
    public void batchSystem_case0() throws Exception {
        int[] duration = {400, 100, 100, 100};
        String[] user = {"Danny Messer", "Stella Bonasera", "Stella Bonasera", "Mac Taylor"};
        int[] expected = {3, 1, 2, 0};

        int[] actual = batchSystem.schedule(duration, user);

        Assert.assertEquals(expected[0], actual[0]);
        Assert.assertEquals(expected[1], actual[1]);
        Assert.assertEquals(expected[2], actual[2]);
        Assert.assertEquals(expected[3], actual[3]);
    }

    @Test
    public void batchSystem_case1() throws Exception {
        int[] duration = {200, 200, 200};
        String[] user = {"Sarah", "Gil", "Warrick"};
        int[] expected = {1, 0, 2};

        int[] actual = batchSystem.schedule(duration, user);

        Assert.assertEquals(expected[0], actual[0]);
        Assert.assertEquals(expected[1], actual[1]);
        Assert.assertEquals(expected[2], actual[2]);
    }

    @Test
    public void batchSystem_case2() throws Exception {
        int[] duration = {100, 200, 50};
        String[] user = {"HC", "hc", "YBB"};
        int[] expected = {2, 0, 1};

        int[] actual = batchSystem.schedule(duration, user);

        Assert.assertEquals(expected[0], actual[0]);
        Assert.assertEquals(expected[1], actual[1]);
        Assert.assertEquals(expected[2], actual[2]);
    }

    @Test
    public void batchSystem_case3() throws Exception {
        int[] duration = {1, 1, 1, 1};
        String[] user = {"B", "B", "A", "A"};
        int[] expected = {0, 1, 2, 3};

        int[] actual = batchSystem.schedule(duration, user);

        Assert.assertEquals(expected[0], actual[0]);
        Assert.assertEquals(expected[1], actual[1]);
        Assert.assertEquals(expected[2], actual[2]);
    }
}