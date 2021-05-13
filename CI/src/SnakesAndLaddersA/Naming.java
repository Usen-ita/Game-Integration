package SnakesAndLaddersA;

public class Naming {

	private String name;
	private static DiceGenerator Dice;

	private int numBiscuits;
	private int numSticks;

	public Naming(String name) {
		Dice = new DiceGenerator();

		this.name = name;
	}

	// The player moves number of squares on the board.

	public int takeTurn() {

		int roll = Dice.rollD6();

		System.out.println(name + " rolled " + roll + ".");

		return roll;
	}

	// True if player has any sticks

	public boolean hasSticks() {
		return numSticks > 0;
	}

	// True if player has any biscuits

	public boolean hasBiscuit() {
		return numBiscuits > 0;
	}

	// Increases the number of biscuits player has by 1

	public void pickBiscuit() {
		numBiscuits++;
	}

	// Increases the number of sticks player has by 1

	public void pickStick() {
		numSticks++;
	}

	// Decreases the number of biscuits player has by 1

	public void useBiscuit() {
		numBiscuits--;
	}

	// Decreases the number of biscuits player has by 1

	public void useStick() {
		numSticks--;
	}

	// to.String method creates A human readable version of the players in the games
	public String toString() {
		return name;
	}
}