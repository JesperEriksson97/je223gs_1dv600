import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @class GameSetup is the class that sets up the game, making it ready to play
 * @author Jesper
 *
 */

public class GameSetup {
	
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
	boolean victory = false;
	int failures = 0;
	int score = 10;
	StringBuilder word = new StringBuilder("");   // The word the player guess against
	StringBuilder hiddenWord = new StringBuilder("");   // The word presented in the game, starts hidden (- - - -)
	ArrayList<String> guessedWords = new ArrayList<String>(); // The letters that the player guessed on previously.
	public Highscore hs = new Highscore(); 
	
	/**
	 * Prints the start menu.
	 */
	
	public void printStartMenu () {
		victory = false;
		word.setLength(0);
		hiddenWord.setLength(0);
		guessedWords.clear();
		failures = 0;
		
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
		 try {
		    int choice = scanner.nextInt();

		    if (choice > 3) {
		    	System.err.println("\nWrong input! Enter a single number 1,2 or 3.\n");
		    	printStartMenu();
		    } else {
		    switch (choice) {
		        case 1:
		            printGame();
		            break;
		        case 2:
		        	printHighscore();
		            break;
		        case 3:
		        	System.exit(0);
		            break;
		        default:
		            ;
		      }
		    }
		    } catch (Exception e) {
		    	System.err.println("Wrong input! Enter 1, 2 or 3");
		    	printStartMenu();
		    }
		    
		  scanner.close();
	}
	
	/**
	 * printGame handles all the game logic.
	 */
	
	private void printGame() {
		
		/* Creating a ArrayList<StringBuilder> and adds values to it */
		
		ArrayList<StringBuilder> words = new ArrayList<StringBuilder>();
		StringBuilder str = new StringBuilder("calculator");
		StringBuilder str1 = new StringBuilder("programming");
		StringBuilder str2 = new StringBuilder("church");
		StringBuilder str3 = new StringBuilder("piano");
		StringBuilder str4 = new StringBuilder("microphone");
		words.add(str1);
		words.add(str2);
		words.add(str3);
		words.add(str4);
		words.add(str);
		
		/* Grabs a random value from the ArrayList */
		
		Random rand = new Random();
		int value = rand.nextInt((words.size() - 0));
		word = words.get(value);
		System.out.println("\nGuess the word by guessing letter by letter!\nYou start at 10 points and for every wrong guess you get - 1 points\nYou can only guess on letter A-Z! Numbers and mulitple letters is not allowed");
		System.out.println("Write 'exit' and press enter to go back to the start menu\n");
		
		for (int i = 0; i < word.length(); i++) {
			hiddenWord.append('-');
		}
		
		Scanner scanner = new Scanner(System.in);
		
		/* while-loop start */
		
		while (failures < 10 && victory == false) {
			System.out.println("Wrong guesses: " + failures + "\n" ); // Exchange this row to the different hangman figures!
			System.out.println(hiddenWord + "\n");
			System.out.println("Already gussed letters: " + guessedWords.toString());
			System.out.print("Guess on a letter: ");
			
			String choice = scanner.nextLine();
			
			if (choice.matches("exit")) {
				printStartMenu();
			} else if (choice.length() > 1) {
				System.err.println("\nWrong input! Enter only 1 letter! \n"); 
			} else if (choice.matches("^\\d+(\\.\\d+)?")) {
				System.err.println("\nWrong input! Enter a letter(A-Z)! \n");
			} else {
			
				
				if (checkAnswer(choice, word) == true) {
					
					for (int i = 0; i < word.length(); i++) {
						if (choice.charAt(0) == word.charAt(i)) {
							hiddenWord.setCharAt(i, choice.charAt(0));
						}
					}
				} else {
					failures++;
					guessedWords.add(choice.charAt(0) + " ");
				}
			}
			
			int cleared = 0;
			for (int i = 0; i < hiddenWord.length(); i++) {
				if (hiddenWord.charAt(i) != '-') {
					cleared++;
				}
				if (cleared == hiddenWord.length()) {
					victory = true;
				}
			}
			
			System.out.println("_________________");
			System.out.println("");
			
		}
		
		/* while end */
		
		
		if (failures >= 10) { // Guessing wrong 10 times.
			System.out.println("You lost... Transfering to start-menu.");
			printStartMenu();
		} else if (victory) { // Guessing the right word.
			int total = score - failures;
			if (hs.checkIfHighscore(total)) {
				System.out.println("The word was: " + word);
				System.out.println("HOORAY! You made it! New Highscore!!");
				System.out.println("Your points: " + total);
				
				Scanner scan = new Scanner(System.in);
				System.out.print("Enter your nickname: ");
				String nickname = scan.nextLine();
				
				hs.addToHighscore(total, nickname);
				System.out.println("Highscore added! Exiting to start-menu!\n");
				printStartMenu();
				scan.close();
				
			} else {
				
				System.out.println("HOORAY! You made it! You almost made it into the highscore list!");
				System.out.println("Your points: " + total);
			}
		}

		
		scanner.close();
	}
	
	/**
	 * checkAnswer checks if the word in use contains the guessed letter.
	 * @param letter the guesses letter.
	 * @param wordIn the correct word.
	 * @return Boolean
	 */
	
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
	 * Prints the highscore-list.
	 */
	
	private void printHighscore () {
		System.out.println("Highscore-list");
		System.out.println(hs.print());
		System.out.println("");
		System.out.println("Press any b + enter to get back to the start-menu");
		Scanner scan = new Scanner(System.in);
		boolean b = true;
		while(b) {
		String str = scan.nextLine();
		if (str.charAt(0) == 'b') {
			printStartMenu();
			b = false;
		 }
		}
		scan.close();
		
	}
}
