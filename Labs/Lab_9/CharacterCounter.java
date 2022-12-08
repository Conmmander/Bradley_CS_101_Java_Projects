/**
 * @author Ryan Dodd
 * <p> CharacterCounter.java
 * <p> CS_101_Lab_9
 * <p> This counts the number of vowels, punctuation, and special characters.
 */

import java.util.Scanner;
public class CharacterCounter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter something: ");
		String theSomething = input.nextLine();
		int vowels = 0;
		int punctuation = 0;
		int special = 0;
		int constants = 0;
		for (int i = 0; i < theSomething.length(); i++) {
			String atPoint = theSomething.substring(i, i+1).toLowerCase();
			if (atPoint.equals("a") || atPoint.equals("e") || atPoint.equals("i") || atPoint.equals("o") || atPoint.equals("u")) {
				vowels++;
			} else if (atPoint.equals(".") || atPoint.equals("?") || atPoint.equals(";") || atPoint.equals(",")) {
				punctuation++;
			} else if (atPoint.equals(" ") || atPoint.equals("\n") || atPoint.equals("/t")) {
				special++;
			} else if (!atPoint.equals("1") && !atPoint.equals("2") && !atPoint.equals("3") && !atPoint.equals("4") && !atPoint.equals("5") && !atPoint.equals("6") && !atPoint.equals("7") && !atPoint.equals("8") && !atPoint.equals("9") && !atPoint.equals("0")) {
				constants++;//Technically this will count a few other characters as constants
			}
		}
		System.out.println("Vowels: " + vowels + "\nPunctuation: " + punctuation + "\nWhitespace: " + special + "\nConstants: " + constants);
		input.close();
	}

}
