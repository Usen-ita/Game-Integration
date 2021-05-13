package SnakesAndLaddersA;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheGameBoard {

	private int[][] ShowBoard;
	private int[] ShowBiscuits;
	private int[] ShowBigSticks;
	private int[][] ShowLadders;
	private int[][] ShowSnakes;

	// Board size and number of biscuits, sticks, snakes, ladders

	private final int ROWS = 10;
	private final int COLUMNS = 10;
	private final int BISCUITS = 2;
	private final int BIGSTICKS = 2;
	private final int SNAKES = 5;
	private final int LADDERS = 6;

	// Classifies PositionNow as Integer
	Map<Naming, Integer> PositionNow;

	public TheGameBoard(List<Naming> players) {

		// Making the 10*10 game board
		ShowBoard = new int[ROWS][COLUMNS];
		for (int x = 0; x < ROWS; x++) {
			for (int y = 0; y < COLUMNS; y++) {
				ShowBoard[x][y] = x * ROWS + y + 1;
			}

			// Puts players on the map
			this.PositionNow = new HashMap<Naming, Integer>();
			for (Naming player : players) {
				this.PositionNow.put(player, 0);
			}

		}

		// Set the snakes and ladders

		setBiscuits();

		setLadders();

		setSnakes();

		setSticks();

	}

	// Squares is the number squares a player moves

	public boolean movePlayer(Naming player, int Squares) {

		// Compute the new position
		int PositionNext = PositionNow.get(player);
		PositionNext += Squares;
		// If the player reaches the 100 square then return true
		if (PositionNext >= 100) {

			PositionNow.put(player, 100);
			return true;
		} else

		{
			// If the new position is less than 100 return false (Game keeps going)

			for (int i = 0; i < BISCUITS; i++)
				// Check if the next position has a biscuit
				if (PositionNext == ShowBiscuits[i]) {
					// remove the biscuit from that position
					ShowBiscuits[i] = -1;
					// let player pick the biscuit
					player.pickBiscuit();
					PositionNow.put(player, PositionNext);

					System.out.println(player + " picked up a biscuit.");
					return false;
				}

			for (int i = 0; i < BIGSTICKS; i++)
				// Check if the new position has a stick
				if (PositionNext == ShowBigSticks[i]) {
					// remove the stick from that position
					ShowBigSticks[i] = -1;
					// let player pick the stick
					player.pickStick();
					PositionNow.put(player, PositionNext);

					System.out.println(player + " picked up a stick.");
					return false;
				}

			for (int idx = 0; idx < SNAKES; idx++) {
				// Check if the new position is the starting point for a snake
				if (ShowSnakes[idx][0] == PositionNext) {
					// If the new position is the starting point for a snake
					// Move the player to the end position for the snake,but
					// If player has biscuit,then don't move him to end position,
					// Keep the player in the position
					if (player.hasBiscuit()) {
						PositionNow.put(player, PositionNext);
						player.useBiscuit();

						System.out.println(
								"OH NO!!! " + player + " lands on a snake but uses the biscuit to not go down.");

						return false;
					} else {
						PositionNext = ShowSnakes[idx][1];
						PositionNow.put(player, PositionNext);

						System.out.println("OH NO!!! " + player + " lands on a snake and goes from "
								+ ShowSnakes[idx][0] + " to " + ShowSnakes[idx][1]);

					}
					return false;
				}
			}

			// Check if the new position is the starting point for a ladder
			for (int VariablePosition = 0; VariablePosition < LADDERS; VariablePosition++) {
				if (ShowLadders[VariablePosition][0] == PositionNext) {
					// If the new position is the starting point for a ladder
					// Move the player to the end position for the ladder
					// but if player has stick move him 10 extra spaces up
					if (player.hasSticks()) {
						PositionNext = ShowLadders[VariablePosition][1] + 10;
						PositionNow.put(player, PositionNext);
						player.useStick();
						System.out.println("NICE!!! " + player + " takes ladder from "
								+ ShowLadders[VariablePosition][0] + " to " + ShowLadders[VariablePosition][1]);
						System.out.println(player + " also used his stick to move 10 extra spaces.");

						return false;
					} else {
						PositionNext = ShowLadders[VariablePosition][1];
						PositionNow.put(player, PositionNext);

						System.out.println("NICE!!! " + player + " lands on a ladder and goes from "
								+ ShowLadders[VariablePosition][0] + " to " + ShowLadders[VariablePosition][1]);

						return false;
					}
				}
			}

			// If the player did not land on a biscuit, stick, snake, ladder, then just
			// refresh the board game
			// its position normally
			PositionNow.put(player, PositionNext);
			return false;
		}

	}

	// Set the biscuits for the board

	private void setBiscuits() {
		ShowBiscuits = new int[BISCUITS];

		ShowBiscuits[0] = 14;
		ShowBiscuits[1] = 56;
	}

	// Set the snakes for the board

	private void setSnakes() {
		ShowSnakes = new int[SNAKES][2];

		ShowSnakes[0][0] = 33;
		ShowSnakes[0][1] = 7;
		ShowSnakes[1][0] = 58;
		ShowSnakes[1][1] = 23;
		ShowSnakes[2][0] = 73;
		ShowSnakes[2][1] = 46;
		ShowSnakes[3][0] = 94;
		ShowSnakes[3][1] = 66;
		ShowSnakes[4][0] = 98;
		ShowSnakes[4][1] = 62;
	}

	// Set the sticks for the board

	private void setSticks() {
		ShowBigSticks = new int[BIGSTICKS];

		ShowBigSticks[0] = 9;
		ShowBigSticks[1] = 47;
	}

	// Set the ladders for the board

	private void setLadders() {
		ShowLadders = new int[LADDERS][2];

		ShowLadders[0][0] = 4;
		ShowLadders[0][1] = 25;
		ShowLadders[1][0] = 15;
		ShowLadders[1][1] = 34;
		ShowLadders[2][0] = 22;
		ShowLadders[2][1] = 42;
		ShowLadders[3][0] = 32;
		ShowLadders[3][1] = 53;
		ShowLadders[4][0] = 57;
		ShowLadders[4][1] = 76;
		ShowLadders[5][0] = 69;
		ShowLadders[5][1] = 87;

	}

	// to.String method creates A human readable version of the board

	public String toString() {
		// Using StringBuilder for creating the string
		StringBuilder stringbuilder = new StringBuilder();
		boolean oddRow = true;

		// Even rows (1-10, 21-30, 41-50, 61-70, 81-90) make players move from left to
		// right.
		// Odd rows (11-20, 31-40, 51-60, 71-80, 91-100) make players move from right to
		// left.

		for (int x = ROWS - 1; x >= 0; x--) {
			for (int y = 0; y < COLUMNS; y++) {
				if (oddRow) {
					// If a player is on an odd row square
					// If the square has a player on it, the square must show the player name and
					// not the number of the square

					String PlayerLocation = "";
					boolean PlayerHere = false;
					for (Naming Template : PositionNow.keySet()) {
						if (PositionNow.get(Template) == ShowBoard[x][COLUMNS - 1 - y]) {
							// Refresh the player location
							PlayerHere = true;
							PlayerLocation += Template + " ";
						}
					}

					if (PlayerHere) {
						// If one player or more are on a square, then print the players names
						PlayerLocation += "\t";
						stringbuilder.append(PlayerLocation);
					} else {
						// Else, then print the number shown on the square
						stringbuilder.append(ShowBoard[x][COLUMNS - 1 - y] + "\t");
					}
				} else {
					// If the row is not odd (Even)
					// Check if any of the players occupy the current location
					boolean PlayerHere = false;
					String PlayerLocation = "";
					for (Naming Template : PositionNow.keySet()) {
						if (PositionNow.get(Template) == ShowBoard[x][y]) {
							// Refresh player location
							PlayerHere = true;
							PlayerLocation += (Template + " ");
						}
					}

					if (PlayerHere) {
						// If one player or more are on a square, then print the players names
						PlayerLocation += " \t";
						stringbuilder.append(PlayerLocation);
					} else {
						// Else, then print the number shown on the square
						stringbuilder.append(ShowBoard[x][y] + "\t");
					}
				}
			}
			// After an odd row, then a non-odd row (even) then after is an odd row
			oddRow = !oddRow;
			stringbuilder.append("\n");
		}
		stringbuilder.append("\n");

		return stringbuilder.toString();
	}

}