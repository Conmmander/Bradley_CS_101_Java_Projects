/**
 * @author Ryan Dodd
 * <p> PairOfDice.java
 * <p> CS_101_Lab_12
 * <p> This class takes sets of dice and manages them.
 */

public class PairOfDice {
	private Die dice1;
	private Die dice2;

	/**
	 * This creates two dice of side 6.
	 */
	public PairOfDice() {
		this.dice1 = new Die((long)5);
		this.dice2 = new Die((long)5);
	}
	
	/**
	 * This creates two dice with the specified amount of sides.
	 * @param sides1 - Sides of dice 1.
	 * @param sides2 - Sides of dice 2.
	 */
	public PairOfDice(int sides1, int sides2) {
		this.dice1 = new Die(sides1, 5);
		this.dice2 = new Die(sides2, 5);
	}
	
	/**
	 * Gets the face values of two dice.
	 * @return int - The sum of the face value of two dice.
	 */
	public int getSum() {
		return this.dice1.getFace() + this.dice2.getFace();
	}
	
	/**
	 * Rolls two dice and returns their sums.
	 * @return int - returns the sum of the face values of two dice.
	 */
	public int roll() {
		this.dice1.roll();
		this.dice2.roll();
		return this.getSum();
	}
	
	/**
	 * Prints the pair of dice to string.
	 * @return The dice as strings.
	 */
	public String toString() {
		return "Dice 1: " + this.dice1.getFace() + "\nDice 2: " + this.dice2.getFace() + "\nSum: " + this.getSum();
	}
}
