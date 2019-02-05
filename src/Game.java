
public class Game extends Print {
	
	private char yesOrNo = 'n';
	private String nickname = "Player unknown";
	
	public Game () {
		
	}
	
	/**
	 * Start game calls printStartMenu, which prints the starting menu.
	 */
	
	private void startGame () {}
	
	/**
	 * Ends the game.
	 */
	
	private void endGame () {}
	
	/**
	 * Checks if the letter inserted is part of the word
	 * @return boolean value 
	 */
	
	private boolean checkAnswer (Character letter) {return false;}
	
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
