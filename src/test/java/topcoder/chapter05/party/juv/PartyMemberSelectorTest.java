package topcoder.chapter05.party.juv;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Juv
 * @since 2017-06-14
 */
public class PartyMemberSelectorTest {
    @Test
    public void select() throws Exception {
        String[] first = {"fishing", "gardening", "swimming", "fishing"};
        String[] second = {"hunting", "fishing", "fishing", "biting"};
        Assert.assertEquals(4, PartyMemberSelector.select(first, second));


        String[] first2 = {"variety", "diversity", "loquacity", "courtesy"};
        String[] second2 = {"talking", "speaking", "discussion", "meeting"};
        Assert.assertEquals(1, PartyMemberSelector.select(first2, second2));
    }
}