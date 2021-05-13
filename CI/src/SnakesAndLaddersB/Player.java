package SnakesAndLaddersB;
import java.util.Scanner;

public class Player {

	private String name;
	private static Die die = new Die();
	private boolean hasBigStick;
	private boolean hasBiscuit;
	
	
	//Initialize the fields
	public Player(String name){
		this.name = name;
	}
	
	/**
	 * Sets hasBiscuit to true
	 */
	public void earnBiscuit(){
		this.hasBiscuit = true;
		System.out.println(name + " earned biscuit");
	}
	
	/**
	 * Sets hasBigStick to true
	 */
	public void earnBigStick(){
		this.hasBigStick = true;
		System.out.println(name + " earned big stick");
	}
	
	
	
	/**
	 * This method plays out the player's turn.
	 * @return The number of spaces to move on the board.
	 */
	public int takeTurn(){
		
		//Initialize scanner
		Scanner scan = new Scanner(System.in);
		//Prompt user for roll
		System.out.print(name+"'s turn: ");
		String input = scan.nextLine();
		
		//Translate the input to some numeric value between 1 and 9
		int val = 0;
		for (int idx = 0; idx < input.length(); idx++){
			val+= input.charAt(idx);
		}
		val = val % 10;
		if (val == 0){
			val = 1;
		}
		
		//Throw away the next 'val' random values
		for (int idx = 0; idx < val; idx++){
			die.rollD6();
		}
		
		//Get the roll
		int roll = 0;
	    
		roll = die.rollD6();
		
		//Get a 6 and get to roll again
		if (roll == 6) {
			roll = die.rollD6() + die.rollD6();
		}
			
		
		System.out.println(name + " rolled " + roll + ".");
		
		
		return roll;
	}
	
	
	public String toString(){
		return name;
	}
}