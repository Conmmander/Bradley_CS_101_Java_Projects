/**
 * @author Ryan Dodd
 * <p> Main.java
 * <p> CS_101_Lab_14
 * <p> This will compute a quotient from two numbers.
 */

import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource") // Makes input stop having a yellow squiggle. Don't feel like closing the scanner.
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			String output = "";
			
			try {
				System.out.print("Enter an integer as the numerator (0 to exit): ");
				int numerator = Integer.parseInt(input.next());
				System.out.print("Enter an integer as the denominator (0 to exit): ");
				int denominator = Integer.parseInt(input.next());
				
				if (numerator == 0 && denominator == 0) {
					System.exit(0);
				}
				
				if (denominator == 0) {
					throw new ArithmeticException("You cannot divide by zero!");
				}
		
				output = numerator + "/" + denominator + " = " + numerator/denominator;
			} catch(Exception e) {
				if (e.getClass().getCanonicalName().equals("java.lang.NumberFormatException")) {
					e.printStackTrace(System.out);
					output = "You may only enter integers as input!";
				} else if (e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
					output = "You cannot divide by zero!";
				} else {
					output = "Some other error occured that I handled properly, but do not know what it was!";
				}
				input.nextLine();
			} finally {
				System.out.println(output);
			}
		}
	}

}
