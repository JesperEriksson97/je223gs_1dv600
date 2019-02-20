
public class Game {
	Print print = new Print();
	private boolean yesOrNo = false;
	private String nickname = "Player unknown";
	
	public Game () {
		
	}
	
	/**
	 * Start game calls printStartMenu, which prints the starting menu.
	 */
	
	public void startGame () {
		print.printStartMenu();
	}
	
	/**
	 * Ends the game.
	 */
	
	private void endGame () {}
	
	/**
	 * Checks if the letter inserted is part of the word
	 * @return boolean value 
	 */
	
	
	/**
	 * Setter for the player username.
	 * @param str
	 */
	
	private void setUsername (String str) {
		nickname = str;
	}
	
	/**
	 * Getter for the player username.
	 * @return String
	 */
	
	private String getUsername () {
		return nickname;
	}
}
