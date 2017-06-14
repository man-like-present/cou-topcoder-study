package topcoder.chapter05.party.juv;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Juv on 2017-06-14.
 */
public class PartyMemberSelectorTest {
    @Test
    public void select() throws Exception {
       Assert.assertTrue(check(new String[]{"fishing", "gardening", "swimming", "fishing"}
                , new String[]{"hunting", "fishing", "fishing", "biting"}, 4));

        Assert.assertTrue(check(new String[]{"variety", "diversity", "loquacity", "courtesy"}
                , new String[]{"talking", "speaking", "discussion", "meeting"}, 1));
    }

    private static boolean check(String[] first, String[] second, int expected) {
        return expected == PartyMemberSelector.select(first, second);
    }

}