
public class Game {
	GameSetup newGame = new GameSetup();
	
	public Game () {
		
	}
	
	/**
	 * Start game calls printStartMenu, which prints the starting menu.
	 */

	public void startGame () {
		newGame.printStartMenu();
	}
}
