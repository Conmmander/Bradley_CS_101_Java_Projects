/**
* @author Ryan Dodd
* <p> PigDice.java
* <p> Project3
* <p> This class runs the pigdice 
 */

//
// The rules to the dice game Pig
//
// Number of Players: 2 + 
// Game Duration: 30 mins
// Players Aged: 6 +
//
// You will need: 2 dice and paper to score on.
//
// To Play: The players take turns to roll both dice, 
// they can roll as many times as they want in one turn.
//
// A player scores the sum of the two dice thrown and 
// gradually reaches a higher score as they continue to roll.
//
// If a single number 1 is thrown on either die, the score 
// for that whole turn is lost. However a double 1 counts as 25.
// The first player to 100 wins unless a player scores more 
// subsequently in the same round. This means that everyone in 
// the game must have the same number of turns.
//

// this class manages the state of the dice and the scoring
public class PigDice
{
	// keep track of total and round scores as well as the two dice.
	private int totalScore = 0;
	private int roundScore = 0;
	private Die die1;
	private Die die2;

	public PigDice()
	{
        die1 = new Die(5);
        die2 = new Die(10);
	}

	/**
	 * Accesses the current total score for this players PigDice;
	 * @return (int) - the total score.
	 */
	public int currentTotal()
	{
		return this.totalScore;
	}

	/**
	 * Accesses the current round score for this players PigDice.
	 * @return (int) - the round score.
	 */
	public int currentRound()
	{
		return this.roundScore;
	}

	/**
	 * Computes if the player pigged out and returns the result.
	 * @return (boolean) - Did the player roll a single 1.
	 */
	public boolean piggedOut()
	{
        return this.singleOneRolled() && !this.doubleOnesRolled();
	}

	/**
	 * Simulates the rolling of two dice.
	 */
	public void rollDice()
	{
		// Roll the die
		die1.roll();
		die2.roll();
	}

	/**
	 * Fetches what the last roll of the dice was.
	 * @return (String) - Gets the roll of each dice and returns their result.
	 */
	public String lastRoll()
	{
		return "D1 (" + die1.faceValue() + "), D2 (" + die2.faceValue() + ")";
	}

	/**
	 * Computes what the total of the dice is. rolling two 1's gives a 25. 0 for pigging out, and the die total for anything else.
	 * @return (int) - Returns the score for that roll of dice.
	 */
	public int evaluate()
	{
		if (this.piggedOut()) {
			return 0;
		} else if (this.doubleOnesRolled()) {
			this.roundScore += 25;
			return 25;
		} else {
			this.roundScore += this.die1.faceValue() + this.die2.faceValue();
			return this.die1.faceValue() + this.die2.faceValue();
		}
	}

	/**
	 * Helps decide if only one 1 was rolled.
	 * @return (boolean) - was only a singular 1 rolled. If 2 are rolled, returns false.
	 */
	private boolean singleOneRolled()
	{
		return (this.die1.faceValue() == 1 && this.die2.faceValue() != 1) || (this.die1.faceValue() != 1 && this.die2.faceValue() == 1);
	}

	/**
	 * Did 2 ones get rolled?
	 * @return (boolean) - Result of the dice
	 */
	private boolean doubleOnesRolled()
	{
		return this.die1.faceValue() == 1 && this.die2.faceValue() == 1;
	}
	
	/**
	 * Sets the round score to 0 if the player pigged out. Otherwise score carries to the next round.
	 */
	public void handlePiggedOut() {
		this.roundScore = 0;
	}

	/**
	 * Resets the round score, adds that score to the total score, and then returns the round score.
	 * @return (int) - Total round score
	 */
	public int save()
	{
		int roundTemp = this.currentRound();
		this.totalScore += this.currentRound();
		this.roundScore = 0;
        return roundTemp;
	}
}
