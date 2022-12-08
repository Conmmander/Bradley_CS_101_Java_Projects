/**
 * @author Ryan Dodd
 * <p> IntegerType.java
 * <p> CS_101_Lab_9
 * <p> This program accepts an integer and outputs the amount of 0's, evens and odds.
 */

import java.util.Scanner;
public class IntegerType {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		String num = input.nextLine();
		int zeros = 0;
		int evens = 0;
		int odds = 0;
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) == '0') {
				zeros++;
			} else {
				int temp = num.charAt(i);
				if (temp % 2 == 0) {
					evens++;
				} else {
					odds++;
				}
			}
		}
		input.close();
		System.out.println("Evens: "+evens + "\nOdds: " + odds + "\nZeros: "+zeros);
	}

}
