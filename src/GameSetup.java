import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @class GameSetup is the class that sets up the game, making it ready to play
 * @author Jesper
 *
 */

public class GameSetup {
	
	/*
	  The Strings that are supposed to represent a hanging man.
	 */
	
	String error1 = 
			"	  -----\n" +
			"	  |   |\n" +
			"	      |\n" +
			"	      |\n" +
			"	      |\n" +
			"	      |\n" +
			"	______|\n";
	String error2 = 
			"	  -----\n" +
			"	  |   |\n" +
			"	  0   |\n" +
			"	      |\n" +
			"	      |\n" +
			"	      |\n" +
			"	______|\n";
	String error3 = 
			"	  -----\n" +
			"	  |   |\n" +
			"	  0   |\n" +
			"	  |   |\n" +
			"	      |\n" +
			"	      |\n" +
			"	______|\n";
	String error4 = 
			"	  -----\n" +
			"	  |   |\n" +
			"	  0   |\n" +
			"	  |\\  |\n" +
			"	      |\n" +
			"	      |\n" +
			"	______|\n";
	String error5 = 
			"	  -----\n" +
			"	  |   |\n" +
			"	  0   |\n" +
		    "	 /|\\  |\n" +
			"	      |\n" +
			"	      |\n" +
			"	______|\n";
	String error6 = 
			"	  -----\n" +
			"	  |   |\n" +
			"	  0   |\n" +
			"	 /|\\  |\n" +
			"	   \\  |\n" +
			"	      |\n" +
			"	______|\n";
	String error7 = 
			"	  -----\n" +
			"	  |   |\n" +
			"	  0   |\n" +
			"	 /|\\  |\n" +
			"	 / \\  |\n" +
			"	      |\n" +
			"	______|\n";
	String error8 = 
			"	  -----\n" +
			"	  |   |\n" +
			"	  0   |\n" +
			"	 /|\\  |\n" +
			"	_/ \\  |\n" +
			"	      |\n" +
			"	______|\n";
	String error9 =
			"	  -----\n" +
			"	  |   |\n" +
			"	  0   |\n" +
			"	 /|\\  |\n" +
			"	_/ \\_ |\n" +
			"	      |\n" +
			"	______|\n";
	String error10 = 
			"	  -----\n" +
			"	  |   |\n" +
			"	  X   |\n" +
			"	 /|\\  |\n" +
			"	_/ \\_ |\n" +
			"	      |\n" +
			"	______|\n";
	private String[] errors = {error1, error2, error3, error4, error5, error6, error7, error8, error9, error10};
	
	private boolean victory = false;
	private int failures = 0;
	private int score = 10;
	String word;   // The word the player guess against
	ArrayList<String> words = new ArrayList<String>(Arrays.asList("calculator","programming","piano","church","microphone"));

	 // The words to choose from
	StringBuilder hiddenWord = new StringBuilder("");   // The word presented in the game, starts hidden (- - - -)
	ArrayList<String> guessedWords = new ArrayList<String>(); // The letters that the player guessed on previously.
	private Highscore hs = new Highscore(); // The highscore-list.
	
	/**
	 * Prints the start menu.
	 */
	
	public void printStartMenu () {
		victory = false;
		word = "";
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
		System.out.println("1 Play Game      	  | press 1");
		System.out.println("2 View Highscore 	  | press 2");
		System.out.println("3 Exit          	  | press 3");
		System.out.println("4 Add Custom Word     	  | press 4");
		System.out.print("Your choice: ");
		
		 Scanner scanner = new Scanner(System.in);
		 try {
		    int choice = scanner.nextInt();

		    if (choice > 4) {
		    	System.err.println("\nWrong input! Enter a single number 1,2,3 or 4.\n");
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
		        case 4:
		        	System.out.println("\nEnter a word containg only letters between A-Z");
		   		 	System.out.println("Enter 'exit' to go back to the start-menu ('exit' can therefore not be the word to be added)");
		        	addWord();
		        	break;
		      }
		    }
		    } catch (Exception e) {
		    	System.err.println("Wrong input! Enter 1, 2 or 3");
		    	printStartMenu();
		    }
		    
		  scanner.close();
	}
	
	/**
	 * addWord adds a custom word to the words ArrayList later to be used in the game.
	 */
	
	public void addWord() {
		 Scanner scanner = new Scanner(System.in);
		 String word = scanner.next();
		 if (word.length() < 1) {
			 System.out.println("The word needs to be atleast one character long, try again");
			 addWord();
			 scanner.close();
		 } else if ((!Pattern.matches("[a-zA-Z]+", word))) { // If the word contains anything but letters from A-Z do:
			 System.out.println("The word needs to contain only letters between A-Z, try again");
			 addWord();
			 scanner.close();
		 } else if (word.matches("exit")) {
			 printStartMenu();
		 } else {
			 System.out.println("Your word was added! Transfering you to the start-menu");
			 words.add(word);
			 printStartMenu();
			 scanner.close();
		 }
		 scanner.close();
		
	}

	/**
	 * printGame handles all the game logic.
	 */
	
	private void printGame() {
		
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
			String print = printHangMan(failures);
			System.out.println(print); // Exchange this row to the different hangman figures!
			System.out.println(hiddenWord + "\n");
			System.out.println("Already gussed letters: " + guessedWords.toString());
			System.out.print("Guess on a letter: ");
			
			String choice = scanner.nextLine();
			
			if (choice.matches("exit")) {
				printStartMenu();
			} else if (choice.length() > 1) {
				System.err.println("\nWrong input! Enter only 1 letter! \n"); 
			} else if (!choice.matches("[A-Za-z]{1}")) {
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
		
		// End game, either victorious or lost
		
		if (failures >= 10) { // Guessing wrong 10 times.
			System.out.println("You lost... Transfering to start-menu.");
			printStartMenu();
		} else if (victory) { // Guessing the right word.
			int total = score - failures;
			if (hs.checkIfHighscore(total)) {
				System.out.println("HOORAY! You made it! New Highscore!!");
				System.out.println("The word was: " + word);
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
				System.out.println("The word was: " + word);
				System.out.println("Your points: " + total);
			}
		}

		
		scanner.close();
	}
	
	/**
	 * checkAnswer checks if the word in use contains the guessed letter.
	 * @param letter the guesses letter.
	 * @param word2 the correct word.
	 * @return Boolean
	 */
	
    public boolean checkAnswer (String letter, String word2) {
		// If the guess is correct set the hiddenWord character to the guess character.
		for (int i = 0; i < word2.length(); i++) {
			if (letter.charAt(0) == word2.charAt(i)) {
				//hiddenWord.setCharAt(i, letter.charAt(0));
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
	
	/**
	 * printHangMan is supposed to print an image of a hanging man
	 * @param failures the amount of failed guesses the player have made
	 * @return String , the hangman in string format
	 */
	
	// This is the method that is going to be used
	public String printHangMan (int failures) {
		int i = failures;
		return errors[i];
	}
	
}
