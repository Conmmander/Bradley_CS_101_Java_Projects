/**
 * @author Ryan Dodd
 * <p> Player.java
 * <p> CS_101_Lab_12
 * <p> This is the driver class for the Die and PairOfDice classes.
 */

public class Player {

	/**
	 * The driver class for the player class.
	 * @param args (String[]) - Strings you can pass from the command line
	 */
	public static void main(String[] args) {
		PairOfDice set1 = new PairOfDice();
		System.out.println(set1);
		set1.roll();
		System.out.println(set1);
		set1.roll();
		System.out.println(set1);
		
		System.out.println();
		
		PairOfDice set2 = new PairOfDice(20, 2);
		System.out.println(set2);
		set2.roll();
		System.out.println(set2);
		set2.roll();
		System.out.println(set2);
		set2.roll();

	}

}
