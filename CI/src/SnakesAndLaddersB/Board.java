package SnakesAndLaddersB;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

	//Constant values: Board size, and number of snakes and ladders
	private final int ROWS = 10;
	private final int COLS = 10;
	private final int NUM_SNAKES = 8;
	private final int NUM_LADDERS = 8;
	private final int NUM_BISCUIT = 2;
	private final int NUM_BIG_STICK = 2;
	

	//Board variables
	private int[][] gameBoard;
	private int[][] snakes;
	private int[][] ladders;
	private int[] biscuit;
	private int[] big_stick;
	

	//Map of player positions.
	//Key = player, Value = player position
	Map<Player, Integer> playerPositions;

	/**
	 * Initialize the fields.
	 * @param numPlayers The number of players.
	 */
	public Board(List<Player> players){

		//Initialize the player positions
		this.playerPositions = new HashMap<Player, Integer>();
		for (Player player : players){
			this.playerPositions.put(player, 0);
		}

		//Set up the ROWS X COLS board
		gameBoard = new int[ROWS][COLS];
		for (int row = 0; row < ROWS; row++){
			for (int col = 0; col < COLS; col++){
				gameBoard[row][col] = row*ROWS + col + 1;
			}
		}

		//Set the snakes, ladders, powerups, and disadvantages
		setSnakes();
		setLadders();
		setBiscuits();
		setBig_Stick();
		

	}

	/**
	 * Moves the given player based on the value provided.
	 * @param player The player to move.
	 * @param value The spaces to move.
	 * @return True if the player reaches the final (100) spot, else false.
	 */
	public boolean movePlayer(Player player, int value){

		//Compute the new position
		int position = playerPositions.get(player);
		position += value;


		if (position >= 100){
			//If the new position is 100 (or above), the player wins!
			playerPositions.put(player, 100);
			return true;
		} else {
			//If the new position is less than 100

			//Check if the new position is the starting point for a snake
			for (int idx = 0; idx < NUM_SNAKES; idx++){
				if (snakes[idx][0] == position){
					//If the new position is the starting point for a snake
					//Move the player to the end position for the snake
					position = snakes[idx][1];
					playerPositions.put(player, position);
					
					System.out.println("Uh oh. " + player + " takes snake from " + snakes[idx][0] + " to " + snakes[idx][1]);

					return false;
				}
			}

			//Check if the new position is the starting point for a ladder
			for (int idx = 0; idx < NUM_LADDERS; idx++){
				if (ladders[idx][0] == position){
					//If the new position is the starting point for a ladder
					//Move the player to the end position for the ladder
					position = ladders[idx][1];
					playerPositions.put(player, position);

					System.out.println("Yay! " + player + " takes ladder from " + ladders[idx][0] + " to " + ladders[idx][1]);
					
					return false;
				}
			}
			
			//Check if the new position contains a powerup or a disadvantage
			for (int idx = 0; idx < NUM_BISCUIT; idx++){
				if (biscuit[idx] == position){
					player.earnBiscuit();
				
				}
			}
			
			//Check if the new position contains a powerup or a disadvantage
			for (int idx = 0; idx < NUM_BIG_STICK; idx++){
				if (big_stick[idx] == position){
					player.earnBigStick();
				
				}
			}
			//If the player is not on a snake/ladder, then just update
			//its position normally
			playerPositions.put(player, position);
			return false;
		}

	}

	/**
	 * Sets the snakes for the board
	 */
	public void setSnakes(){
		snakes = new int[NUM_SNAKES][2];
		
		snakes[0][0] = 17 ;
		snakes[0][1] = 7  ;
		snakes[1][0] = 54 ;
		snakes[1][1] = 34 ;
		snakes[2][0] = 62 ;
		snakes[2][1] = 19 ;
		snakes[3][0] = 64 ;
		snakes[3][1] = 60 ;
		snakes[4][0] = 87 ;
		snakes[4][1] = 24 ;
		snakes[5][0] = 93 ;
		snakes[5][1] = 73 ;
		snakes[6][0] = 95 ;
		snakes[6][1] = 75 ;
		snakes[7][0] = 99 ;
		snakes[7][1] = 78 ;
	}

	/**
	 * Sets the ladders for the board
	 */
	public void setLadders(){
		ladders = new int[NUM_LADDERS][2];

		ladders[0][0] = 4;
		ladders[0][1] = 14;
		ladders[1][0] = 9;
		ladders[1][1] = 31;
		ladders[2][0] = 20;
		ladders[2][1] = 38;
		ladders[3][0] = 28;
		ladders[3][1] = 84;
		ladders[4][0] = 40;
		ladders[4][1] = 59;
		ladders[5][0] = 51;
		ladders[5][1] = 67;
		ladders[6][0] = 63;
		ladders[6][1] = 81;
		ladders[7][0] = 71;
		ladders[7][1] = 91;
	}
	
	/**
	 * Sets the Biscuit
	 */
	private void setBiscuits(){
		biscuit = new int[NUM_BISCUIT];
		
		biscuit[0] = 2;
		biscuit[1] = 21;
		
	}
	
	/**
	 * Sets the Big Stick
	 */
	public void setBig_Stick(){
		big_stick = new int[NUM_BIG_STICK];
		
		big_stick[0] = 3;
		big_stick[1] = 22;
		
	}
	

	/**
	 * @return A human readable version of the board
	 */
	public String toString(){
		//Use StringBuilder for creating the string
		StringBuilder sb = new StringBuilder();
		boolean oddRow = true;

		//Note: The rows will be in reverse order, with 1-10 at the bottom, and 91-100 at the top.
		//Note: 'Even' (1-10, 21-30, ..., 81-90)  are printed left to right.
		//Note: 'Odd' (11-20, 31-40, ..., 91-100)  are printed right to left.
		//Note: If the position is occupied by a player, we print the player, not the number.
		
		for (int row = ROWS-1; row >= 0; row--){
			for (int col = 0; col < COLS; col++){
				if (oddRow){
					//oddRow: row = 9, 7, 5, 3, 1
					//Check if any of the players occupy the current location
					String pl = "";
					boolean occupied = false;
					for (Player temp : playerPositions.keySet()){
						if (playerPositions.get(temp) == gameBoard[row][COLS-1-col]){
							//If a player occupies the current location, then set the flag
							//and update pl
							occupied = true;
							pl += temp + " ";
						}
					}
					
					if (occupied){
						//If at least one player occupies the location, then print those players
						pl += "\t";
						sb.append(pl);
					} else {
						//Else, print the position number
						sb.append(gameBoard[row][COLS-1-col] + "\t");						
					}
				} else {
					//evenRow: row = 8, 6, 4, 2, 0
					//Check if any of the players occupy the current location
					boolean occupied = false;
					String pl = "";
					for (Player temp : playerPositions.keySet()){
						if (playerPositions.get(temp) == gameBoard[row][col]){
							//If a player occupies the current location, then set the flag
							//and update pl
							occupied = true;
							pl += (temp + " ");
						}
					}
					
					if (occupied){
						//If at least one player occupies the location, then print those players
						pl += "\t";
						sb.append(pl);	
					} else {
						//Else,  print the position number
						sb.append(gameBoard[row][col] + "\t");
					}
				}
			} 
			//Switch oddRow flag and print new line
			oddRow = !oddRow;
			sb.append("\n");
		}
		sb.append("\n");

		return sb.toString();
	}

}