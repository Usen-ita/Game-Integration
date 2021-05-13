package HangmanB;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Startofthegame extends hangman {
// this is a class i have created where it will extends to the main class i have created
	public static void MainGame() throws IOException {
		// i have created a boolean for a loop for the user to press P to continue the
		// game.
		boolean repeat1 = true;// these are the booleans which i have created
		boolean repeat2 = true;

		String userinput;// this is the string where we will get the userinput
		Scanner w1 = new Scanner(System.in);// this is the scanner which will scan the userinput without it we wouldnt
											// be able to type onto the console

// this is the main menu i have created, this is to make it easier for the user to understand my game.
		System.out.println("<><><><><><><><><><><><><>");
		System.out.print("\t+--+\n\t|  |\n\t|  0\n\t| /|\\\n\t|  |\n\t| / \\\n\t|\n\t|\n");
		System.out.println("Welcome to Vivek's Hangman");
		System.out.println("<><><><><><><><><><><><><>");
		System.out.println(
				" ____________________________________________________________________________________________________________________");
		System.out.println(
				"|Instructions:                                                                                                       |");
		System.out.println(
				"|____________________________________________________________________________________________________________________|");
		System.out.println(
				"|You have got 10 Lives for every category,                                                                           |"
						+ "\n|I have chosen 10 lives so that the user has the best chance of winning the game                                     |");
		System.out.println(
				"|You have 9 Categories to choose from                                                                                |");
		System.out.println(
				"|If you don't enter a letter , i.e (Number) then you will get a warning to discourage you to do it again.            | "
						+ "\n|Once you have received 3 warnings. You will lose a life                                                             |");
		System.out.println(
				"|Once you have guessed the word, you will be asked to enter your name and if you wish to play again.                 |");
		System.out.println(
				"|If you have run out of lives, the game will end, and you will be asked if you wish to play again                    |");
		System.out.println(
				"|____________________________________________________________________________________________________________________|");

		System.out.println("<><><><><><><><><><><><><><><><><><><><>");

// this is where it starts where it asks for the user input and if they want to continue then they press P

		System.out.println("Would you like to Play? Press P to Play or N to Exit");
		System.out.println("<><><><><><><><><><><><><><><><><><><><>");
		userinput = w1.next();
		if (userinput.equalsIgnoreCase("P"))
			repeat1 = true; // if it is going to be P then it will run the code again

		else {

			if (userinput.equalsIgnoreCase("N"))
				repeat1 = false; // if they enter anything else which is not a P or N then the game will end
			System.out.println("Thanks for Playing Vivek's Hangman");
			System.exit(1); // this is where the system will exit

		}
		System.out.print("Please input your name: ");
		String name = w1.next();

		while (repeat2 = true) { // if repeat2=true, then it will run this code.

			String[] words; // this is the words from words to be guessed
			String Guess; // this is another string which is called guess so if it matches with the main
							// hangman which i have in the main method then it should mean that the user has
							// won and they will increase the wincounter.

			boolean playGame = true; // i have

			int winCounter = 0, lostCounter = 0;
			int counter = 0;

			words = wordstobeguessed(); // this is where it will get the words from and see if they match the userguess
			// this is where if the playgame is true and counter is 0 but the words length
			// are bigger then we increment the counter each time if Guess is == words then
			// it means the user has won.
			while (playGame && counter < words.length) {
				Guess = words[counter++]; // this increments each time until counter is bigger than words length ***
											// reminder check this again
				if (mainHangman(Guess)) { // if the main hangman which is a method on the main class then if it is
											// guess, then the user has won, then we have got a counter which increments
											// each time the user plays.

					winCounter++; // this is a win counter which i have created to show how many games the user
									// has won.

					System.out.println("\nCongratulations" + "\t" + name + "!" + " You have won " + winCounter
							+ " games." + " You have lost " + lostCounter + " games."); // this is printing out the
																						// amount of times the user has
																						// won or lost.
					System.out.println("The word is:" + Guess.toUpperCase());
					// this is a integer i have initalised for score
					try {

						int lives = 0;// lives are according to the user's guesses
						lives++;

						// this is something which i did from c++ ,
						// https://hplusacademy.com/c-language-program-to-count-the-number-of-lowercase-letters-in-a-text-file/
						boolean[] chars = new boolean[25]; // this is a boolean i created where the dimension expression
															// is 25
						// Nested loop to increment i each time.
						for (int i = 0; i < Guess.length(); ++i) { // this is where the game increments each time
																	// depending on the length of the guess

							char ch = Guess.charAt(i); // the character where the char at is i, The Java String
														// charAt(int index) method returns the character at the
														// specified index in a string
							if (ch >= 97 && ch < 122) { // The ASCII value of â€˜aâ€™ is 97 and that of â€˜zâ€™ is 122.
														// In this if statement, we checking the value of ch is in the
														// range between 97 and 122. If any character is found in this
														// range, then we will just increment the value count by 1.
								chars[ch - 'a'] = true; // i have set the character "a" to true

							}
						}
						int count = 0;// this is what it will be the score would be count * the lives
						for (int i = 0; i < chars.length; ++i) { // this is another nested loop where we increment i
																	// each time.
							if (chars[i])
								count++; // count ++ is increased each team if chars is i

						}

						int score = count * (lives);// this is how we would calculate everything

						FileWriter myWriter = new FileWriter("HangmanBMemory/score1.txt"); // this is where the
																							// score is going to
																							// be written to the
																							// file.
						System.out.println("Your score is:" + score);// this is what it would print in the console
						myWriter.write("Your name is:" + name + "'\n" + "Your Score is:" + score);// this is what it
																									// will be written
																									// in the file
						myWriter.close();// this closes the file
						System.out.println("\nThe File has been created.");// this just shows that the file has been
																			// created.
						System.out.println("____________Leaderboard__________________________________"); // this is the
																											// leaderboard
																											// i have
																											// created
																											// it is
																											// going to
																											// be
																											// different
																											// each time
																											// according
																											// to the
																											// player.
						System.out.println(
								"|                                                                            ");

						System.out.println("Your name is:" + "------" + name + "------" + "Your score is:" + "------"
								+ score + "------");
						System.out.println(
								"|                                                                            ");
						System.out.println("|__________________________________________________________");
					} catch (IOException e) {// this is to catch an exceptions that might happen
						System.out.println("An error occurred.");// if this has been printed it means that an error has
																	// occured
						e.printStackTrace();

					}

					{
						{

						}

						// this is similar to what i did above, if the user wants to play again then
						// they will be able to if they input Y and if they N then it will exit the game
						// and print a bye message.
						System.out.println("Would you like to Play Again? Press Y to Continue or N to Exit");
						// this is a normal scanner which is going to be inspecting the user input
						userinput = w1.next();
						if (userinput.equalsIgnoreCase("Y"))
							repeat2 = true; // if repeat 2 is true then it will run the code again

						else {
							// if the user says No then repeat 2 automatically means its false and the game
							// should end.
							userinput.equalsIgnoreCase("N");

							repeat2 = false;
							System.out.println("Thanks for Playing Vivek's Hangman");// the game ends and this message
																						// is printed
							System.exit(1);

						}

					}

				}

				// otherwise it means that the user has lost and that the commiserations message
				// is printed
				else {
					// this is the lose counter where it increments each time the user has lost.
					lostCounter++;
					System.out.println("\nCommiserations " + name + "!" + " You have lost " + lostCounter + " games."
							+ " You have won " + winCounter + " games.");
					// it asks the same question as above if they want to continue

					try {
						int lives = 0;// lives are according to the user's guesses
						lives++;

						// this is something which i did from c++ ,
						// https://hplusacademy.com/c-language-program-to-count-the-number-of-lowercase-letters-in-a-text-file/
						boolean[] chars = new boolean[25]; // this is a boolean i created where the dimension expression
															// is 25
						// Nested loop to increment i each time.
						for (int i = 0; i < Guess.length(); ++i) { // this is where the game increments each time
																	// depending on the length of the guess

							char ch = Guess.charAt(i); // the character where the char at is i, The Java String
														// charAt(int index) method returns the character at the
														// specified index in a string
							if (ch >= 97 && ch < 122) { // The ASCII value of â€˜aâ€™ is 97 and that of â€˜zâ€™ is 122.
														// In this if statement, we checking the value of ch is in the
														// range between 97 and 122. If any character is found in this
														// range, then we will just increment the value count by 1.
								chars[ch - 'a'] = true; // i have set the character "a" to true

							}
						}
						int count = 0;// this is what it will be the score would be count * the lives
						for (int i = 0; i < chars.length; ++i) { // this is another nested loop where we increment i
																	// each time.
							if (chars[i])
								count++; // count ++ is increased each team if chars is i

						}

						int score = count * (lives);// this is how we would calculate everything

						FileWriter myWriter = new FileWriter("HangmanBMemory/score1.txt"); // this is where the
																							// score is going to
																							// be written to the
																							// file.
						System.out.println("Your score is:" + score);// this is what it would print in the console
						myWriter.write("Your name is:" + name + "'\n" + "Your Score is:" + score);// this is what it
																									// will be written
																									// in the file
						myWriter.close();// this closes the file
						System.out.println("\nThe File has been created.");// this just shows that the file has been
																			// created.
						System.out.println("____________Leaderboard__________________________________"); // this is the
																											// leaderboard
																											// i have
																											// created
																											// it is
																											// going to
																											// be
																											// different
																											// each time
																											// according
																											// to the
																											// player.
						System.out.println(
								"|                                                                            ");

						System.out.println("Your name is:" + "------" + name + "------" + "Your score is:" + "------"
								+ score + "------");
						System.out.println(
								"|                                                                            ");
						System.out.println("|__________________________________________________________");
					} catch (IOException e) {// this is to catch an exceptions that might happen
						System.out.println("An error occurred.");// if this has been printed it means that an error has
																	// occured
						e.printStackTrace();

					}

					System.out.println("Would you like to Play Again? Press Y to Continue or N to Exit");// this is
																											// asking
																											// the user
																											// if they
																											// want to
																											// play
																											// again

					userinput = w1.next();
					if (userinput.equalsIgnoreCase("Y"))
						repeat2 = true;// this is going to repeat the game again.
					else {

						userinput.equalsIgnoreCase("N");
						repeat2 = false;
						System.out.println("Thanks for Playing Vivek's Hangman");

						System.exit(1);// this is where it would end the game and exit it

					}
				}
			}
		}
	}
}