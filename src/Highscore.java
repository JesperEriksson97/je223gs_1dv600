import java.util.ArrayList;

public class Highscore {

	/**
	 * Private inner class.
	 */

	private class Player {
		private String nickname;
		private int score;
		
		/* Node constructor */
		
		public Player (String nick, int scoreIn) {
			nickname = nick;
			score = scoreIn;
		}
		
		public Player () {
			
		}
		
		public String getNickname() {
			return nickname;
		}
		
		public int getPlayerScore() {
			return score;
		}
		
		public void setPlayerScore(int scoreIn) {
			score = scoreIn;
		}
		
		public void setNickname(String nick) {
			nickname = nick;
		}
		
		public String toString() {
			String str = new String(getNickname() + " Score: " + getPlayerScore());
			return str;
		}
	}
		
	/**
    * The highscore list.
	*/
	ArrayList<Player> highscoreList = new ArrayList<Player>();
	
	public Highscore () {
		Player nr1 = new Player("Unknown", 0);
		Player nr2 = new Player("Unknown", 0);
		Player nr3 = new Player("Unknown", 0);
		highscoreList.add(nr1);
		highscoreList.add(nr2);
		highscoreList.add(nr3);
	}
	
	/**
	 * Checks if the score is high enough to enter the highscore, if it is add it to the highscore list.
	 */
	public void addToHighscore(int score, String nickname) {
	    if (score > highscoreList.get(0).getPlayerScore()) {
			Player player2 = new Player();
			player2.setNickname(nickname);
			player2.setPlayerScore(score);
			highscoreList.set(0, player2);
		} else if (score > highscoreList.get(1).getPlayerScore()) {
			Player player3 = new Player();
			player3.setNickname(nickname);
			player3.setPlayerScore(score);
			highscoreList.set(1, player3);
		} else if (score > highscoreList.get(2).getPlayerScore()) {
			Player player4 = new Player();
			player4.setNickname(nickname);
			player4.setPlayerScore(score);
			highscoreList.set(2, player4);
		}
		
	}
	
	public boolean checkIfHighscore (int score) {
		for(int i = 0; i < highscoreList.size(); i++) {
			if (score > highscoreList.get(i).getPlayerScore()) {
				System.out.println(highscoreList.get(i).getPlayerScore());
				return true;
			}
		}
		return false;
		
	}
	
	public String print () {
		String str = new String(
				"#1: " + highscoreList.get(0).toString() + "\n" +
				"#2: " + highscoreList.get(1).toString() + "\n" +
				"#3: " + highscoreList.get(2).toString() + "\n"
		);
		return str;
	}
}
