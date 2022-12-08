/**
 * @author Ryan Dodd
 * <p> StringPrinter.java
 * <p> CS_101_Lab_7
 * <p> This program accepts input until the sentinel value is entered. It then prints the entered characters as one string.
 */

import java.util.Scanner;
public class SentinelProgram {
	final static String SENTINEL = ".";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String builtString = "";
		while (true) {
			String theString = input.nextLine();
			builtString+= theString;
			if (theString.equals(SENTINEL)) { // assume a user will not enter multiple things on one line
				break;
			}
		}
		input.close();
		System.out.println(builtString);
	}

}
