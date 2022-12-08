/**
 * @author Ryan Dodd
 * <p> IntegerMachine.java
 * <p> CS_101_Lab_5
 * <p> (DESCRIPTION)
 */

import java.util.Scanner;
public class IntegerMachine {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		if (input.hasNextInt()) {
			Integer intMachine = input.nextInt();
			System.out.println("The integer\'s value in binary is: " + Integer.toBinaryString(intMachine));
			System.out.println("The integer\'s value in octal is: " + Integer.toOctalString(intMachine));
			System.out.println("The integer\'s value in hexadecimal is: " + Integer.toHexString(intMachine));
		}
		input.close();
	}

}
