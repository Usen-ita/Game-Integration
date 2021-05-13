package SnakesAndLaddersA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainS {

	public static void main(String[] args) {

		System.out.println("SNAKES AND LADDERS GAME");

		// Initialising the scanner.
		Scanner scanning = new Scanner(System.in);
		// This will give option for 2-4 players
		int PlayerNumber = 0;
		// If the input is 2, 3 or 4 then the options are given again
		boolean loop = false;
		do {
			try {
				while (PlayerNumber <= 1 || PlayerNumber > 4) {
					System.out.print("Please enter how many players (2-4): ");
					PlayerNumber = scanning.nextInt();
				}
			} catch (Exception e) {
				System.out.println("INVALID INPUT please choose from options");
				loop = true;
				scanning.next();
			}
		} while (loop);

		// Making the Players.
		List<Naming> Charaters = new ArrayList<Naming>();
		String PlayerName;
		// Naming the number of players chosen
		for (int NumberList = 0; NumberList < PlayerNumber; NumberList++) {
			System.out.println("Enter name for player " + (NumberList + 1) + " : ");
			PlayerName = scanning.next();
			// Name the next player
			Naming player = new Naming(PlayerName);
			Charaters.add(player);

		}

		// Creating the game board.
		TheGameBoard board = new TheGameBoard(Charaters);

		// Players will be taking turns to roll the dice to move on the game board
		boolean Finish = false;
		int NewTurn = 0;
		// The turns will loop until the any player finishes the game
		while (!Finish) {
			Naming PlayerNow = Charaters.get(NewTurn);
			int DiceRoll = 0;
			// After dice roll the next play will have a go
			do {
				DiceRoll = PlayerNow.takeTurn();

				// This refreshes the game board to the players new position
				Finish = board.movePlayer(PlayerNow, DiceRoll);

				// Print the board
				System.out.println(board);
				System.out.println(
						"__________________________________________________________________________________________________\n");

				// If the player roll 6, then print this
				if (DiceRoll == 6)
					System.out.println("Nice! " + PlayerNow + " rolled 6 and gets to roll again.");

				// If the game is finish then print this
				if (Finish) {
					System.out.println(PlayerNow + " is the winner");
				}
				// Player gets to roll again when rolls a 6
			} while (!Finish && DiceRoll == 6);

			// The next player will have their turn
			NewTurn++;
			if (NewTurn == PlayerNumber) {
				NewTurn = 0;
			}
		}
	}
}