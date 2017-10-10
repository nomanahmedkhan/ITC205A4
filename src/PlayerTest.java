import static org.junit.Assert.*;

import org.junit.Test;


public class PlayerTest {

	@Test
	public void testPlayerUnableToReachLimit() {
		Player testPlayer = new Player ("noman", 5);
		int bet = 5;
		boolean testResult = testPlayer.balanceExceedsLimitBy(bet);
		assertEquals(true, testResult);
	}
	
	public void testPlayerUnableToReachLimit2() {
		Player testPlayer = new Player ("noman", 5);
		int bet = 4;
		boolean testResult = testPlayer.balanceExceedsLimitBy(bet);
		assertEquals(true, testResult);
	}

}
