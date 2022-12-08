/**
 * @author Ryan Dodd
 * <p> XOutput.java
 * <p> CS_101_Lab_8
 * <p> This program accepts an input integer and then outputs a pattern of x's.
 */

import java.util.Scanner;
public class XOutput {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int maxLength = Math.abs(input.nextInt()); // Assume users are good people and supply numbers.
		String xString = "";
		for (int i = 0; i < maxLength; i++) {
			xString+="x";
			System.out.print(xString + " ");
		}
		input.close();
	}

}
