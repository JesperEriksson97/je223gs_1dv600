import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.Test;

public class GameTest {
	
	   GameSetup gameSetUp = new GameSetup();

	   // The highscore list is by default set to 0, 0, 0. Which means that if we check with anything > 0 it should go in to the highscore
	   Highscore highscore = new Highscore();
	   
	   String testWord = "test";
       String testLetter = "e";

	/**
	 * If the word is "test" checkAnswer should return true if the Player guesses on a "e"
	 */
				
	@Test public void testCheckAnswerReturnsTrue ()  {
			assertTrue(gameSetUp.checkAnswer(testLetter, testWord));
	}
	
	/**
	 * If the word is "test" checkAnswer should return false if the Player guesses on a "g"
	 */
	
	@Test public void testCheckAnswerReturnsFalse ()  {
			assertFalse(gameSetUp.checkAnswer("g", testWord));
	}
	
	/**
	 * checkAnswer is designed to only read the first letter in the String. Therefore if we insert "tu"
	 * as the guessed letter checkAnswer should still return true.
	 */
	
	@Test public void testCheckAnswerHandlesMultipleLetters()  {
		assertTrue(gameSetUp.checkAnswer("tu", testWord));
	}
	
	/**
	 * Checks if checkAnswer can handle numbers without crashing
	 */
	
	@Test public void testCheckAnswerReturnsFalseIfNumber() {
		assertFalse(gameSetUp.checkAnswer("1",testWord));
	}
	
	/**
	 * Checks if checkAnswer can handle unicode without crashing
	 */
	
	@Test public void testCheckAnswerReturnsFalseIfUnicode() {
		assertFalse(gameSetUp.checkAnswer("!",testWord));
	}
	
	/**
	 * Checks if 1 is enough to get into the Highscore-list, returns true if it is.
	 */
	@Test public void testCheckIfScoreIsInRangeOfHighscore() {
		assertTrue(highscore.checkIfHighscore(1));
	}
	
	/**
	 * Checks if -1 is enough to get into the Highscore-list, returns true if it is.
	 */
	@Test public void testCheckIfNegativeScoreIsInRangeOfHighscore() {
		assertFalse(highscore.checkIfHighscore(-1));
	}
	
	/**
	 *  One failing method 
	 */
	
	@Test public void printHangManTest() {
		assertEquals(gameSetUp.printHangMan(3), "err3");
	}
	
}
