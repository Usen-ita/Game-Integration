package MastermindA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MastermindGame {
	private static final Character BLACK = 'B';
	private static final Character WHITE = 'W';
	private static final Character PURPLE = 'P';
	private static final Character GREEN = 'G';
	private static final Character YELLOW = 'Y';
	private static final Character RED = 'R';
	private static final Character INDIGO = 'I';
	private static final Character CYAN = 'C';
	private static final Character TURQOISE = 'T';
	private static final Character ORANGE = 'O';
	private static final int MAX_NUMBER_OF_COLOURS = 10;
	private static final int MIN_NUMBER_OF_COLOURS = 6;
	private static final int MAX_CODE_SIZE = 4;
	private static final int MIN_CODE_SIZE = 3;

	private static final ArrayList<Character> RANGE_OF_COLOURS = new ArrayList<>(
			Arrays.asList(BLACK, WHITE, PURPLE, GREEN, YELLOW, RED, INDIGO, CYAN, TURQOISE, ORANGE));

	public static void main(String[] arg) {
		System.out.println(getInstructions());

		boolean wantToPlay = true;
		while (wantToPlay) {
			// ask for the size of the random range of colours
			int randomRangeOfColoursSize = getRandomRangeOfColoursSize();
			System.out.println(randomRangeOfColoursSize);

			// create the random range of colours
			List<Character> randomRangeOfColours = getRandomRangeOfColours(randomRangeOfColoursSize);
			System.out.println(randomRangeOfColours);

			// ask for the number of colours in the code to guess
			int randomCodeSize = getRandomCodeSize();
			System.out.println(randomCodeSize);

			// create random code to guess with the requested size
			String randomCode = getRandomCodeOfSize(randomCodeSize, randomRangeOfColours);

			// ask for the max number of guesses
			int maxNumberOfGuesses = getMaxNumberOfGuesses();
			System.out.println(maxNumberOfGuesses);

			// Start the guessing of the random code. It returns the final score.
			int score = startGuessingTheRandomCode(randomCode, maxNumberOfGuesses, randomRangeOfColoursSize);

			System.out.println("Game score: " + score);
			wantToPlay = shouldRestartGame();
		}

	}

	private static int startGuessingTheRandomCode(String randomCode, int maxNumberOfGuesses,
			int randomRangeOfColoursSize) {
		boolean hasWon = false;
		int score = randomCode.length() + randomRangeOfColoursSize;
		while (maxNumberOfGuesses > 0 && !hasWon) {
			System.out.println("Enter a guess of the colours: ");
			Scanner guessScanner = new Scanner(System.in);
			String guess = guessScanner.nextLine();
			StringBuilder resultGuessBuilder = new StringBuilder();
			String randomCodeToGuessCopy = randomCode;
			for (int i = 0; i < guess.length(); i++) {
				char aGuessedColour = guess.charAt(i);
				char randomCodeColour = randomCode.charAt(i);
				if (aGuessedColour == randomCodeColour) {
					resultGuessBuilder.append("+");
					// remove the correctly guessed colour from the randomCodeToGuessCopy.
					randomCodeToGuessCopy = randomCodeToGuessCopy.replace(String.valueOf(randomCodeColour), "");
				}
			}
			// if we didn't guess the exact position of all the colours
			if (randomCodeToGuessCopy.length() > 0) {
				// check if there is any correct guess in a wrong position
				for (int i = 0; i < randomCodeToGuessCopy.length(); i++) {
					char aRandomColourToGuess = randomCodeToGuessCopy.charAt(i);
					if (guess.contains(String.valueOf(aRandomColourToGuess))) {
						resultGuessBuilder.append("-");
					}
				}
			}
			String resultGuess = resultGuessBuilder.toString();
			if (randomCode.length() == MAX_CODE_SIZE && resultGuess.equalsIgnoreCase("++++")) {
				hasWon = true;
				System.out.println("Congratulations, you won the game.");

			} else if (randomCode.length() == MIN_CODE_SIZE && resultGuess.equalsIgnoreCase("+++")) {
				hasWon = true;
				System.out.println("Congratulations, you won the game.");
			} else {
				maxNumberOfGuesses = maxNumberOfGuesses - 1;
			}
			System.out.println(resultGuess);
		}

		if (!hasWon) {
			System.out.println("You have lost the game");
			System.out.println("The code was: " + randomCode);
		}

		score = score + maxNumberOfGuesses;
		return score;
	}

	private static boolean shouldRestartGame() {
		System.out.println("Do you want to play again? Y/N");
		Scanner restartGameScanner = new Scanner(System.in);
		while (true) {
			try {
				String restartGameAnswer = restartGameScanner.nextLine();
				if (restartGameAnswer.equalsIgnoreCase("Y")) {
					return true;
				} else if (restartGameAnswer.equalsIgnoreCase("N")) {
					return false;
				} else {
					System.out.println("Please insert Y or N");
				}
			} catch (Exception e) {
				System.out.println("Input not valid: " + e.getMessage());
			}
		}
	}

	private static Integer getRandomRangeOfColoursSize() {
		String rangeMessage = "Enter the number of colors you want in the range, the number should be between %s - %s:\r";
		System.out.println(String.format(rangeMessage, MIN_NUMBER_OF_COLOURS, MAX_NUMBER_OF_COLOURS));
		Scanner rangeScanner = new Scanner(System.in);
		while (true) {
			try {
				int value = Integer.valueOf(rangeScanner.nextLine());
				if (value < MIN_NUMBER_OF_COLOURS || value > MAX_NUMBER_OF_COLOURS) {
					throw new Exception("Invalid Number, Please pick a number between 6-10.\n");
				}
				return value;
			} catch (Exception e) {
				System.out.println("Input not valid: " + e.getMessage());
			}
		}
	}

	private static List<Character> getRandomRangeOfColours(int rangeSize) {
		List<Character> randomRangeOfColours = new ArrayList<>();
		// Randomly shuffle the range of colours. All permutations occur with
		// approximately equal likelihood.
		Collections.shuffle(RANGE_OF_COLOURS);
		for (int i = 0; i < rangeSize; i++) {
			randomRangeOfColours.add(RANGE_OF_COLOURS.get(i));
		}
		return randomRangeOfColours;
	}

	private static Integer getRandomCodeSize() {
		String message = "Would you like to have %s or %s colours in your code? \r\n";
		System.out.println(String.format(message, MIN_CODE_SIZE, MAX_CODE_SIZE));
		Scanner randomCodeSizeScanner = new Scanner(System.in);
		while (true) {
			try {
				int value = Integer.valueOf(randomCodeSizeScanner.nextLine());
				if (value < MIN_CODE_SIZE || value > MAX_CODE_SIZE) {
					throw new Exception(
							String.format("Invalid entry. Please only enter %s or %s", MIN_CODE_SIZE, MAX_CODE_SIZE));
				}
				return value;
			} catch (Exception e) {
				System.out.println("Input not valid: " + e.getMessage());
			}
		}
	}

	private static String getRandomCodeOfSize(int randomCodeSize, List<Character> randomRangeOfColours) {
		Collections.shuffle(randomRangeOfColours);
		StringBuilder randomCodeBuilder = new StringBuilder();
		for (int i = 0; i < randomCodeSize; i++) {
			randomCodeBuilder.append(randomRangeOfColours.get(i));
		}
		return randomCodeBuilder.toString();
	}

	private static Integer getMaxNumberOfGuesses() {
		System.out.println("How many guesses would you like to have?");
		Scanner numberOfGuessesScanner = new Scanner(System.in);
		while (true) {
			try {
				return Integer.valueOf(numberOfGuessesScanner.nextLine());
			} catch (Exception e) {
				System.out.println("Input not valid: " + e.getMessage());
			}
		}

	}

	private static String getInstructions() {
		return "                --Welcome to the game MasterMind--\r\n"
				+ "		Please read the instructions prior tp starting the game\r\n"
				+ "		This is a game played against the computer\r\n"
				+ "	        You have 3 options to complete before starting the game: 		\r\n"
				+ "		-- You can choose how many colours you want in the range (6-10)\r\n"
				+ "		-- You can choose weather you would like 3 or 4 colours in the code\r\n"
				+ "		-- You are allowed to choose as many guesses as you want before you begin\r\n" + "		\r\n"
				+ "	    \r\n" + "		A code of random colours will be generated\r\n"
				+ "	        There is no repition of colours in the same code\r\n"
				+ "		A correct colour in the correct position will result in a '+'\r\n"
				+ "		A correct colour in the wrong position will result in a '-'\r\n"
				+ "		You have as many guesses as desired to guess the correct colours\r\n"
				+ "		The code will not be revealed until the very end\r\n"
				+ "		To win the game '+++' or '---' is needed\r\n" + "		\r\n"
				+ "		The game will end if you have used all your guesses\r\n"
				+ "		Once you have used all your guesses , the game will end\r\n"
				+ "		Your score will displayed at the end and the code will be revealed\r\n" + "		\r\n"
				+ "	\r\n" + "		-- The game will end once you have guessed the correct code --\r\n"
				+ "		-- Your score will be displayed at the end --\r\n"
				+ "		-- You will be asked to exit the game or start again -- " + "     \r\n" + "     \r\n"
				+ "                The colours that you can guess from are listed below : \r\n"
				+ "                -- black (b), white (w), purple (p), green (g), yellow (y), red (r), indigo (i), cyan (c), turqoise (t), orange (o)--\r\n"
				+ "                 Please enter the  first letter e.g 'y' for yellow for guessing the colours. \r\n"
				+ "                 !! The entire word will not be accepted \r\n";

	}
}