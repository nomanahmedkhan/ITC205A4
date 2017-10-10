import static org.junit.Assert.*;

import org.junit.Test;


public class GameTest {

	@Test
	public void testPayoutLevel_oneMatch() {
		Dice firstDie = new Dice (DiceValue.CLUB);
		Dice secondDie = new Dice (DiceValue.ANCHOR);
		Dice thirdDie = new Dice (DiceValue.HEART);
		
		DiceValue player_choice = DiceValue.HEART;
		
		Game testGame = new Game(firstDie,secondDie, thirdDie);
		Player testPlayer = new Player ("noman", 25);
		
		testGame.playRound(testPlayer, player_choice, 5);
		
		assertEquals(30, testPlayer.getBalance());
		
	}
	@Test
	public void testPayoutLevel_twoMatch() {
		Dice firstDie = new Dice (DiceValue.CLUB);
		Dice secondDie = new Dice (DiceValue.ANCHOR);
		Dice thirdDie = new Dice (DiceValue.CLUB);
		
		DiceValue player_choice = DiceValue.CLUB;
		
		Game testGame = new Game(firstDie,secondDie, thirdDie);
		Player testPlayer = new Player ("noman", 25);
		
		testGame.playRound(testPlayer, player_choice, 5);
		
		assertEquals(35, testPlayer.getBalance());
		
	}
	
		

}
