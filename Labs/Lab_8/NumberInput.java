/**
 * @author Ryan Dodd
 * <p> NumberInput.java
 * <p> CS_101_Lab_8
 * <p> This program will accept a number n, and loop until -13<= n <= 13
 */

import java.util.Scanner;
public class NumberInput {
	final static Scanner INPUT = new Scanner(System.in); // Decided to put it here because I can.

	public static void main(String[] args) {
		int n = 0;
		do {
			System.out.print("Enter a number between -13 and 13 inclusive: ");
			n = INPUT.nextInt();
		} while (n < -13 || n > 13);
	}

}