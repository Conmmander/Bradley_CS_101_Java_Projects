/**
@author (Ryan Dodd) 
 * <p>      (ChangeMachine.java) 
 * <p>      (CS 101 Project 2) 
 * <p>      (This program accepts an item price, amounts of payments, and will see if change is required, and if so, how much) 
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class ChangeMachine {

	/**
	 * Main Method
	 * @param args Takes any commandline arguments when started
	 */
	public static void main(String[] args) {
		// Various project constants that won't change.
		final Scanner INPUT = new Scanner(System.in); // The scanner object
		final DecimalFormat FORMATTER = new DecimalFormat("$#.00"); // Formatter for outputting money. Should be the same for everything.
		final double TAX_RATE = 0.05; // The tax rate
		final double MAX_PRICE = 500.00; // Maximum price the user can enter into the Change Machine.
		
		while(true) { // This is an infinate loop, but it is the best way to do this writing excess code for the cost of transaction (Session 2 wouldn't run properly if you used a do or while loop on it's own)
			System.out.print("Cost of transaction (enter 0 or negative to exit; max is $500.00): ");
			try { // Ensures users don't try to pass in Strings, rather than a double value.
				double amount = INPUT.nextDouble();
				if (amount <= 0) {
					break; // If the code meets the exist criteria, then we will break out of this loop.
				} else if (amount > MAX_PRICE){
					continue; // This will just return to the top of the loop, rather than executing additional code.
				} else {
					double taxAmount = amount * (1 + TAX_RATE);
					System.out.println("Amount due (with 5.00% tax): " + FORMATTER.format(taxAmount)); // Prints amounts due, and requests further user input to be used for calculating the change back.
					System.out.print("Please enter payment amount: ");
					double paymentAmount = INPUT.nextDouble();
					double changeBack = paymentAmount - taxAmount; 
					if (changeBack == 0) {
						System.out.println("Exact Change! Amazing!");
					} else if (changeBack < 0){
						System.out.println("You have not given enough change for this transction!"); // Strange edge case not covered in the scenarios/rubric, if a user provides too little change.
					} else {
						System.out.println("Change back: " + FORMATTER.format(changeBack));
						
						// Computes how many $100 bills are returned.
						int hundredBack = (int)(changeBack/100); 
						changeBack-= (hundredBack * 100);
						
						// Computes how many $50 bills are returned.
						int fiftyBack = (int)(changeBack/50);
						changeBack-= (fiftyBack * 50);
						
						// Computes how many $20 bills are returned.
						int twentyBack = (int)(changeBack/20);
						changeBack-= (twentyBack * 20);
						
						// Computes how many $10 bills are returned.
						int tenBack = (int)(changeBack/10);
						changeBack-= (tenBack * 10);
						
						// Computes how many $5 bills are returned.
						int fiveBack = (int)(changeBack/5);
						changeBack-= (fiveBack * 5);
						
						// Computes how many $1 bills are returned.
						int oneBack = (int)(changeBack/1);
						changeBack-= (oneBack * 1);
						
						// Computes how many $0.25 coins are returned.
						int twentyFiveCentBack = (int)(changeBack/0.25);
						changeBack-= (twentyFiveCentBack * 0.25);
						
						// Computes how many $0.10 coins are returned.
						int tenCentBack = (int)(changeBack/0.10);
						changeBack-= (tenCentBack * 0.10);
						
						// Computes how many $0.05 coins are returned.
						int fiveCentBack = (int)(changeBack/0.05);
						changeBack-= (fiveCentBack * 0.05);
						
						// Computes how many $0.01 coins are returned.
						int oneCentBack = (int)(changeBack/0.01);
						changeBack-= (oneCentBack * 0.01);
						
						System.out.println("$100: " + hundredBack + "\t$50: " + fiftyBack + "\t$20: " + twentyBack + "\t$10: " + tenBack + "\t$5: " + fiveBack + "\t$1: " + oneBack
							+ "\t$0.25: " + twentyFiveCentBack + "\t$0.10: " + tenCentBack + "\t$0.05: " + fiveCentBack + "\t$0.01: " + oneCentBack);
					}
				}
			} catch (Exception ex) {
				System.out.println("You may only pass integers into the change machine!");
				INPUT.next(); // If an InputMismatchException is thrown, then it will NOT pass the errored token, meaning it would produce an infinate loop without this line.
			}
		}
		INPUT.close();
		System.out.println("Done.");
	}

}
