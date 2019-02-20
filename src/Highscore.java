import java.util.ArrayList;

/**
 * This class is made to create a Highscore-list
 * @author Jesper
 *
 */

public class Highscore {

	/**
	 * Private inner class for the Player object.
	 */

	private class Player {
		private String nickname;
		private int score;
		
		/* Player constructors */
		
		public Player (String nick, int scoreIn) {
			nickname = nick;
			score = scoreIn;
		}
		
		public Player () {
			
		}
		
		/**
		 * Getter for nickname
		 * @return String the nickname
		 */
		
		public String getNickname() {
			return nickname;
		}
		
		/**
		 * Getter for nickname
		 * @return Integer the player score
		 */
		
		public int getPlayerScore() {
			return score;
		}
		
		/**
		 * Setter for the player score
		 * @param scoreIn the player score.
		 */
		
		public void setPlayerScore(int scoreIn) {
			score = scoreIn;
		}
		
		/**
		 * Setter for the nickname
		 * @param nick the player nickname
		 */
		
		public void setNickname(String nick) {
			nickname = nick;
		}
		
		/**
		 * ToString method for Player.
		 */
		
		public String toString() {
			String str = new String(getNickname() + " Score: " + getPlayerScore());
			return str;
		}
	}
		
    //The highscore list.
	
	ArrayList<Player> highscoreList = new ArrayList<Player>();
	
	/**
	 * Highscore constructor with default values for the highscoreList
	 */
	
	public Highscore () {
		Player nr1 = new Player("Unknown", 0);
		Player nr2 = new Player("Unknown", 0);
		Player nr3 = new Player("Unknown", 0);
		highscoreList.add(nr1);
		highscoreList.add(nr2);
		highscoreList.add(nr3);
	}
	
	/**
	 * Checks if the players score is compatible for the highscoreList.
	 * If it is, create a new player and add it to the list.
	 * @param score the player score
	 * @param nickname the player nickname
	 */
	
	public void addToHighscore(int score, String nickname) {
	    if (score > highscoreList.get(0).getPlayerScore()) {
			Player player2 = new Player();
			player2.setNickname(nickname);
			player2.setPlayerScore(score);
			highscoreList.set(1, highscoreList.get(0));
			highscoreList.set(0, player2);
		} else if (score > highscoreList.get(1).getPlayerScore()) {
			Player player3 = new Player();
			player3.setNickname(nickname);
			player3.setPlayerScore(score);
			highscoreList.set(2, highscoreList.get(1));
			highscoreList.set(1, player3);
		} else if (score > highscoreList.get(2).getPlayerScore()) {
			Player player4 = new Player();
			player4.setNickname(nickname);
			player4.setPlayerScore(score);
			highscoreList.set(2, player4);
		}
		
	}
	
	/**
	 * Checks if the score is enough for the highscoreList
	 * @param score the player score
	 * @return Boolean true if it is or false if it's not
	 */
	
	public boolean checkIfHighscore (int score) {
		for(int i = 0; i < highscoreList.size(); i++) {
			if (score > highscoreList.get(i).getPlayerScore()) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Prints the current highscoreList
	 * @return String the highscoreList
	 */
	
	public String print () {
		String str = new String(
				"#1: " + highscoreList.get(0).toString() + "\n" +
				"#2: " + highscoreList.get(1).toString() + "\n" +
				"#3: " + highscoreList.get(2).toString() + "\n"
		);
		return str;
	}
}
