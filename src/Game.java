
/**
 * Is made to start a new session of the game.
 * @author Jesper
 *
 */

public class Game {
	GameSetup newGame = new GameSetup();
	
	/**
	 * Constructor
	 */
	
	public Game () {
		
	}
	
	/**
	 * Start game calls printStartMenu, which prints the starting menu.
	 */

	public void startGame () {
		newGame.printStartMenu();
	}
}
