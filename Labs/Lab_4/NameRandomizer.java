/**
 * @author Ryan Dodd
 * <p> NameRandomizer.java
 * <p> CS_101_Lab_4
 * <p> This program prompts a user for their first name, last name, and spits out the first letter of the first name, first 5 letters of the last name, and a random two digit integer.
 */

import java.util.Scanner;
import java.util.Random;

public class NameRandomizer {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name in the format <first last>:");
		String first = input.next();
		String last = input.next();
		Random randomNumber = new Random();
		int doubleDigit = randomNumber.nextInt(10, 100);
		System.out.println(first.substring(0, 1).toLowerCase() + last.substring(0, 5).toLowerCase() + doubleDigit);
	}
}
