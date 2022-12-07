/**
* @author Ryan Dodd
* <p> Die.java
* <p> Project3
* <p> This class represents a dice class that will return values as needed.
*/

import java.util.Random;

/**
 * 
 * @author Ryan Dodd
 * Die Class, which provides various accessor and mutator methods for a singular dice.
 */
public class Die {
	private int pips = 1;
	private final int MAX_PIPS = 6;
	private Random randNum;
	
	/**
	 * Default constructor for a dice.
	 */
	public Die() {
		this.randNum = new Random();
		this.roll(); // Calls roll so that code is not reused.
	}

	/**
	 * Overloaded constructor for a dice.
	 * @param seed (int) - Allows you to set a seed. Mainly used for testing purposes to generate reliably recurring results.
	 */
	public Die(int seed) {
		this.randNum = new Random(seed);
		this.roll(); // Calls roll so that code is not reused.
	}
	
	/**
	 * Fetches the face value of the dice.
	 * @return (int) - Returns the face value of the dice.
	 */
	public int faceValue() {
		return this.pips;
	}

	/**
	 * Rolls the dice, and returns the result of that roll.
	 * @return (int) - Returns the face value of the dice.
	 */
	public int roll() {
		pips = this.randNum.nextInt(1, this.MAX_PIPS + 1);
		return this.faceValue(); // Uses the class accessor in case any other tasks needed to be done too.
	}
}
