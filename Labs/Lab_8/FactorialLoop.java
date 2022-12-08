/**
 * @author Ryan Dodd
 * <p> NumberInput.java
 * <p> CS_101_Lab_8
 * <p> This program will accept a number n, and loop until 0<= n <= 13, printing n!
 */

import java.util.Scanner;
public class FactorialLoop {
	final static Scanner INPUT = new Scanner(System.in); // Decided to put it here because I can.

	public static void main(String[] args) {
		int n = INPUT.nextInt();
		// While loop used, because a do loop will run and not consider the value of n. (I could make this work that way, but I won't).
		while (n < 0 || n > 13) {
			n = INPUT.nextInt();
		}
		long factorialN = 1;
		for (int i = n; i > 0; i--) {
			factorialN *= i;
		}
		System.out.println(factorialN);
	}

}