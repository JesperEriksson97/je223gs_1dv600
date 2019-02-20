import java.util.ArrayList;
import java.util.Scanner;

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
	int totalGuesses = 0;
	int score = 100;
	StringBuilder word = new StringBuilder(""); // The word the player guess against
	StringBuilder hiddenWord = new StringBuilder(""); // The word presented in the game, starts hidden (- - - -)
	ArrayList<String> guessedWords = new ArrayList<String>();
	public Highscore hs = new Highscore();
	
	/**
	 * Prints the start menu.
	 */
	
	public void printStartMenu () {
		totalGuesses = 0;
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
		    int choice = scanner.nextInt();


		    switch (choice) {
		        case 1:
		            System.out.println("Playing the game");
		            printGame();
		            break;
		        case 2:
		        	System.out.println("Viewing Highscore");
		        	printHighscore();
		            break;
		        case 3:
		        	System.out.println("Exiting.. Goodbye!");
		        	System.exit(0);
		            break;
		        default:
		            ;
		    }
		    
		  scanner.close();
	}
	
	private void printGame() {
		ArrayList<StringBuilder> words = new ArrayList<StringBuilder>();
		StringBuilder test = new StringBuilder("test");
		words.add(test);
		word = words.get(0);
		System.out.println("\nGuess the word!");
		System.out.println("Write 'exit' and press enter to go back to the start menu");
		
		for (int i = 0; i < word.length(); i++) {
			hiddenWord.append('-');
		}
		
		
		Scanner scanner = new Scanner(System.in);
		
		/* while start */
		
		while (failures < 10 && victory == false) {
			System.out.println("Wrong guesses: " + failures + "\n" ); // Exchange this row to the different hangman figures!
			System.out.println(hiddenWord + "\n");
			System.out.println("Already gussed words: " + guessedWords.toString());
			System.out.print("Guess on a letter: ");
			
			String choice = scanner.nextLine();
			
			if (choice.matches("exit")) {
				printStartMenu();
			} else {
				
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
			
			int cleared = 0;
			for (int i = 0; i < hiddenWord.length(); i++) {
				if (hiddenWord.charAt(i) != '-') {
					cleared++;
				}
				if (cleared == hiddenWord.length()) {
					victory = true;
				}
			}
		}
		
		/* while end */
		
		
		if (failures >= 10) {
			System.out.println("You lost... Transfering to start-menu.");
			printStartMenu();
		} else if (victory) {
			int total = (score - totalGuesses) - failures;
			if (hs.checkIfHighscore(total)) {
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
				System.out.println("HOORAY! You made it!");
				System.out.println("Your points: " + total);
			}
		}

		
		scanner.close();
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
	
	public void printHighscore () {
		System.out.println("Highscore-list");
		System.out.println(hs.print());
		System.out.println("");
		System.out.println("Press b to get back to the start-menu");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		if (str.charAt(0) == 'b') {
			printStartMenu();
		}
		scan.close();
		
	}
}
