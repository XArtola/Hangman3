import java.util.Scanner;

import com.zubiri.hangman.*;

public class HangmanKoldoJar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		Words words = new Words();

		words.addWord(new Word("intxausti"));
		words.addWord(new Word("gonzalez"));
		words.addWord(new Word("lazkano"));
		words.addWord(new Word("artola"));

		boolean playAgain = true;

		while (playAgain) {

			System.out.println("Welcome to the famous HANGMAN game.");
			System.out.println(
					"You will have to guess which surname of the people in class is hidden between the voids.");
			System.out.println(
					"For this, you will be able to enter 3 letters that may appear in the surname, or not. After this, you will only have a chance to guess the surname and win the game.");
			System.out.println(
					"WARNING: Invalid or repeated letter will count as a missed try. The same for the last word");

			Word secretWord = words.getRandomWord();

			Letters letters = new Letters();

			secretWord.printUnderscores(letters);

			System.out.println("\n");

			for (int i = 0; i < 3; i++) {

				System.out.println("Enter a letter\n");

				String usersTry = sc.next();

				sc.nextLine();

				letters.setPossibleLetter(usersTry);

				secretWord.printUnderscores(letters);

				System.out.println("\n");

			}

			System.out.println("Is the last chance, try with a word.\n");
			String lastChance = sc.next();

			if (secretWord.checkWord(lastChance)) {

				if (secretWord.getWord().matches(lastChance)) {

					System.out.println("Congratulations you guessed!!\n");

				}

				else {

					System.out.println("Better luck next time.\n");

				}

			}

			else {

				System.out.println("This is not a valid word. You have lost your oportunity. Better luck next time\n");

			}

			System.out.println("Would you like to play again?(y/n)");
			boolean askAgain = true;
			while (askAgain == true) {
				String back = sc.next().toLowerCase();
				sc.nextLine();
				switch (back) {
				case "y":
					// Get out of the loop and play again
					askAgain = false;
					break;
				case "n":
					// Get out of the loop and terminate the program
					playAgain = false;
					askAgain = false;
					break;
				default:
					// Ask for a possible value again
					System.out.println("Please, select a possible value(y/n)");
					break;
				}

			}

		}

	}

}
