import java.util.ArrayList;
import java.util.Scanner;

public class Print {
	
	/**
	 * The Strings that are supposed to represent a hanging man.
	 */
	
	String error1 = "err1";
	String error2 = "err2";
	String error3 = "err3";
	String error4 = "err4";
	String error5 = "err5";
	String error6 = "err6";
	String error7 = "err7";
	String error8 = "err8";
	String error9 = "err9";
	String error10 = "err10";
	int failures = 0;
	int rightGuesses = 0;
	StringBuilder word = new StringBuilder(""); // The word the player guess against
	StringBuilder hiddenWord = new StringBuilder(""); // The word presented in the game, starts hidden (_ _ _ _ _)
	ArrayList<String> guessedWords = new ArrayList<String>();
	
	/**
	 * Prints the start menu.
	 */
	
	public void printStartMenu () {
		System.out.println(" __    __       ___       __   __    _______ .___  ___.      ___      .__   __.");
		System.out.println("|  |  |  |     /   \\     |  \\ |  |  /  _____||   \\/   |     /   \\     |  \\ |  |");
		System.out.println("|  |__|  |    /  ^  \\    |   \\|  | |  |  __  |  \\  /  |    /  ^  \\    |   \\|  |");
		System.out.println("|   __   |   /  /_\\  \\   |  . `  | |  | |_ | |  |\\/|  |   /  /_\\  \\   |  . `  |");
		System.out.println("|  |  |  |  /  _____  \\  |  |\\   | |  |__| | |  |  |  |  /  _____  \\  |  |\\   |");  
		System.out.println("|__|  |__| /__/     \\__\\ |__| \\__|  \\______| |__|  |__| /__/     \\__\\ |__| \\__|"); 
		System.out.println("\n");
		System.out.println("1 Play Game      | press 1");
		System.out.println("2 View Highscore | press 2");
		System.out.println("3 Exit           | press 3");
		System.out.print("Your choice: ");
		
		 Scanner scanner = new Scanner(System.in);
		    int choice = scanner.nextInt();


		    switch (choice) {
		        case 1:
		            System.out.println("Playing the game");
		            printGame();
		            break;
		        case 2:
		        	System.out.println("Viewing Highscore");
		            break;
		        case 3:
		        	System.out.println("Exiting.. Goodbye!");
		            break;
		        default:
		            ;
		    }
		    
		  scanner.close();
	}
	
	private void printGame() {
		Game game = new Game();
		ArrayList<StringBuilder> words = new ArrayList<StringBuilder>();
		StringBuilder test = new StringBuilder("test");
		words.add(test);
		word = words.get(0);
		System.out.println("\nGuess the word!");
		
		for (int i = 0; i < word.length(); i++) {
			hiddenWord.append('_');
		}
		
		
		Scanner scanner = new Scanner(System.in);
		while (failures < 10 && rightGuesses < word.length()) {
			System.out.println("failures: " + failures ); // Exchange this row to the different hangman figures!
			System.out.println(hiddenWord);
			System.out.println("Already gussed words: " + guessedWords.toString());
			System.out.print("Guess on a letter: ");
			String choice = scanner.nextLine();
			if (checkAnswer(choice, word) == true) {
				
				for (int i = 0; i < word.length(); i++) {
					if (choice.charAt(0) == word.charAt(i)) {
						hiddenWord.setCharAt(i, choice.charAt(0));
					}
				}
				
				System.out.println("Sucess");
				
			} else {
				failures++;
				guessedWords.add(choice + " ");
			}
		}

		
		
	}
	
    public boolean checkAnswer (String letter, StringBuilder wordIn) {
		// If the guess is correct set the hiddenWord character to the guess character.
		for (int i = 0; i < wordIn.length(); i++) {
			if (letter.charAt(0) == wordIn.charAt(i)) {
				hiddenWord.setCharAt(i, letter.charAt(0));
				return true;
			}
		}
		return false;
	}

	/**
	 * Prints the highscore.
	 */
	
	public void printHighscore (ArrayList<String> highscore) {}
}
