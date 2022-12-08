/**
 * @author Ryan Dodd
 * <p> StringPrinter.java
 * <p> CS_101_Lab_7
 * <p> This program will print out a string character by character on a new line.
 */

import java.util.Scanner;
public class StringPrinter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Tell me something: ");
		String theMasterString = input.nextLine();
		for (int i = 0; i < theMasterString.length(); i++) {
			System.out.println(theMasterString.substring(i, i+1)); // Could use charAt as well.
		}
		input.close();
	}

}
