/**
 * @author Ryan Dodd
 * <p> LetterMachine.java
 * <p> CS_101_Lab_6
 * <p> This program accepts an input and then decides what that letter grade is equal to, as well as handles invalid letters.
 */

import java.util.Scanner;
public class LetterMachine {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a letter grade: ");
		String character = input.next();
		character = character.toLowerCase();
		String printMessage = "";
		input.close();
		if (character.length() > 1) {
			printMessage = "ERROR, I can only accept a single letter!";
		} else {
			if (character.equals("a")) {
				printMessage = "Superior";
			} else if (character.equals("b")) {
				printMessage = "Good";
			} else if (character.equals("c")) {
				printMessage = "Average";
			} else if (character.equals("d")) {
				printMessage = "Just Passing";
			} else if (character.equals("f")) {
				printMessage = "Failure";
			} else {
				printMessage = "ERROR";
			}
		}
		System.out.println(printMessage);

	}

}
