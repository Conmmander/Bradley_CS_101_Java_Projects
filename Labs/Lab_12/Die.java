/**
 * @author Ryan Dodd
 * <p> Die.java
 * <p> CS_101_Lab_12
 * <p> This is the dice class, which will roll and perform actions of a dice.
 */

import java.util.Random;

public class Die {
	private int face = 1;
	private int sides;
	private Random randomizer;
	
	/**
	 * This creates a 6 sided die.
	 */
	public Die() {
		this.randomizer = new Random();
		this.sides = 6;
		this.roll(); // Randomizes the face up
	}
	
	/**
	 * This creates a 6 sided die with the specified seed. An overloaded constructor used for testing purposes.
	 * @param randomSeed (long) - A parameter to get consistently predictable rolls by setting the seeds.
	 */
	public Die(long randomSeed) {
		this.randomizer = new Random(randomSeed);
		this.sides = 6;
		this.roll();
	}
	
	/**
	 * Creates a die with the specified sides. An overloaded constructor.
	 * @param sides (int) - Specified sides the die has. Must be 2 or greater.
	 */
	public Die(int sides) {
		if (sides <= 1) {
			throw new Error("You cannot have a die with a side of less than or equal to 1!");
		}
		
		this.randomizer = new Random();
		this.sides = sides ;
		this.roll();
	}
	
	/**
	 * Creates a die with the specified sides and a random number string. An overloaded constructor used for testing purposes.
	 * @param sides (int) - Specified sides the die has. Must be 2 or greater.
	 * @param randomString (long) - Random string for testing the dice.
	 */
	public Die(int sides, long randomSeed) {
		if (sides <= 1) {
			throw new Error("You cannot have a die with a side of less than or equal to 1!");
		}
		
		this.randomizer = new Random(randomSeed);
		this.sides = sides ;
		this.roll();
	}
	
	/**
	 * Returns the face of the die that is up.
	 * @return int - face of the die.
	 */
	public int getFace() {
		return this.face;
	}
	
	/**
	 * Rolls the die to change the face up side of the die.
	 * @return Returns an integer
	 */
	public int roll() {
		face = randomizer.nextInt(1, this.sides + 1);
		return this.getFace();
	}
	
	/**
	 * Overrides the default tostring.
	 * @return Returns the face up of the dice.
	 */
	public String toString() {
		return "Face Up: " + this.getFace();
	}
}
