package topcoder.chapter05.crazybot.corelle;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by noblesm on 2017. 7. 3..
 */
public class CrazyBotTest {

	@Test
	public void getProbabilityTest_1() throws Exception {
		CrazyBot crazyBot = new CrazyBot();
		double probability = crazyBot.getProbability(1, 25, 25, 25, 25);
		assertTrue(probability == 1.0);
	}

	@Test
	public void getProbabilityTest_2() throws Exception {
		CrazyBot crazyBot = new CrazyBot();
		double probability = crazyBot.getProbability(2, 25, 25, 25, 25);
		assertTrue(probability == 0.75);
	}

	@Test
	public void getProbabilityTest_3() throws Exception {
		CrazyBot crazyBot = new CrazyBot();
		double probability = crazyBot.getProbability(7, 50, 0, 0, 50);
		assertTrue(probability == 1.0);

	}

}