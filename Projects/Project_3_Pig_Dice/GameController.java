/**
* @author Ryan Dodd
* <p> GameController.java
* <p> Project3
* <p> This class allows the game to be played, and will take all the user input.
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

import java.util.Scanner;

public class GameController {
	private int maxScore;
	private PigDice pd1;
	private PigDice pd2;
	
	/**
	 * Runner method called by the driver class to start the game.
	 */
	public void play() {
        Scanner input = new Scanner(System.in);
        
        while (true) {
        	pd1 = new PigDice();
            pd2 = new PigDice();
        	this.maxScore = this.getInitialMax(input);
        	while(true) {
        		playerTurn(input, pd1, "1"); // Handles player 1's turn
        		playerTurn(input, pd2, "2"); // Handles player 2's turn
        		if (evaluateRound()) {
        			printScore();
        			break; // A player has won the game.
        		};
        	}
        	System.out.println("Would you like to play again? Response (Y/N) only.");
        	if (!yesResponse(input)) { // If y is inputted, then the game will restart
        		System.out.println("Goodbye");
        		System.exit(0);
        	}
        }
	}

	/**
	 * Gets the max score for the game. Will repeat until a valid score is entered.
	 * @param input (Scanner) - The game controller scanner
	 * @return (int) - The max score that is passed.
	 */
	private int getInitialMax(Scanner input) {
		while (true) {
        	System.out.println("What score would you like to play to? (100 max)");
        	try {
        		int goalScore = input.nextInt();
        		if (goalScore <= 100 && goalScore > 0) {
        			return goalScore;
        		}
        	} catch(Exception e) {
        		input.nextLine();
        	}
        }
	}
	
	/**
	 * Takes a turn as a player.
	 * @param input (Scanner) - The game controller scanner
	 * @param pd (PigDice) - The players pigdice
	 */
	private void takeTurn(Scanner input, PigDice pd) {
		//String response;
		boolean keepRolling = true;

		do {
			// Roll the dice
			pd.rollDice();

			// Report the result
			System.out.println(pd.lastRoll() + " scored " + pd.evaluate() + " points.");

			// Did the player pig out?
			if (pd.piggedOut()) {	
				System.out.println("You pigged out this turn.");
				pd.handlePiggedOut(); // Added to change round score to 0. Otherwise it adds to total score anyway on the next round.
			} else {
				//
				// Roll again; see if the user wants to roll again to add to total or pass and keep current points
				//
				System.out.println("Your current roll is " + pd.currentRound() + " points. Keep rolling? Respond (Y/N) only.");
				
				if (!yesResponse(input)) {
					keepRolling = false;
					int roundScore = pd.save();
					System.out.printf("Your total for the round was %d and your total score is %d.\r\n", roundScore, pd.currentTotal());
				}
			}

		} while (!pd.piggedOut() && keepRolling);
	}
	
	/**
	 * 
	 * @param input (Scanner) - Game controllers scanner.
	 * @param pd (PigDice) - The Players pigdice
	 * @param plrNumber (String) - the number player who's turn it is.
	 */
	private void playerTurn(Scanner input, PigDice pd, String plrNumber) {
		System.out.println("PLAYER " + plrNumber);
		takeTurn(input, pd);
	}
	
	/**
	 * Has the selected PigDice met the goal score.
	 * @param pd (PigDice) - The player's pigdice
	 * @return (boolean) - If the player equals or has a greater goal score.
	 */
	private boolean reachedGoalScore(PigDice pd) {
		return (pd.currentTotal() >= this.maxScore);
	}
	
	/**
	 * Determines if both players have tied.
	 * @return (boolean) - True if the game is a tie.
	 */
	private boolean isTie() {
		return (this.reachedGoalScore(this.pd1) && this.reachedGoalScore(this.pd2) && this.pd1.currentTotal() == this.pd2.currentTotal());
	}
	
	/**
	 * Determines who the winner is, if any.
	 * @return (int) 1 if Player 1 wins, 2 if Player 2 wins, -1 if no one has won.
	 */
	private int determineWinner() {
		if (this.pd1.currentTotal() > this.pd2.currentTotal() && reachedGoalScore(this.pd1)) {
			return 1;
		} else if (this.pd1.currentTotal() < this.pd2.currentTotal() && reachedGoalScore(this.pd2)) {
			return 2;
		} else {
			return -1; // Returns -1 to indicate no one has won yet. Ties would be handled, so they don't need handling here.
		}
	}
	
	/**
	 * Prints the score for the game thus far.
	 */
	private void printScore() {
		System.out.println("Player 1: " + this.pd1.currentTotal() + " -- Player 2: " + this.pd2.currentTotal());
	}
	
	/**
	 * Decides if the round meets the end conditions or not.
	 * @return (boolean) - Decides if the game is over or not based on ties and win conditions.
	 */
	private boolean evaluateRound() {
		printScore();
		if (isTie()) {
			System.out.println("The result is a tie");
			return true; // Does not execute further code below this line, since we do not need to detect a winner.
		}
		
		int winner = this.determineWinner();
		if (winner == 1) {
			System.out.println("Player 1 wins!");
			return true;
		} else if (winner == 2) {
			System.out.println("Player 2 wins!");
			return true;
		} // Will ignore the -1 case, because no one has won at that point.
		return false; // All other cases didn't return, so no one has won yet.
	}
	
	final String YES = "Y";
	/**
	 * 
	 * @param input (Scanner) the game controller scanner.
	 * @return (boolean) - If the passed string is equal to y (ignores caps)
	 */
	private boolean yesResponse(Scanner input) { // Swapped visibility to private. No reason that anyone outside this class needs to see it.
		return input.next().substring(0, 1).toUpperCase().equals(this.YES);
	}
}
