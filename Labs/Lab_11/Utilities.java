/**
 * @author Ryan Dodd
 * <p> Utilities.java
 * <p> CS_101_Lab_11
 * <p> Utilities class to hold all our utilities.
 */

import java.math.BigInteger;
public class Utilities {
	/**
	 * A private constructor, as all methods are static, so we shouldn't need a user to call the constructor.
	 */
	private Utilities() {}
	
	/**
	 * This method returns the absolute value of any integer without using Math.abs();
	 * @param number - an integer to get the absolute value of.
	 * @return the absolute value of number as an integer.
	 */
	public static int abs(int number) {
		return number >= 0 ? number : number * -1; 
	}

	/**
	 * This method accepts a double and returns the next largest integer for both positive and negative numbers.
	 * @param number This is a double that you are finding the next largest integer for.
	 * @return The next largest integer.
	 */
	public static int ceiling(double number) {
		if (number <= 0) {
			return (int)(number);
		} else {
			return (int)(Math.round(number + 0.5));
		}
	}
	
	/**
	 * This method accepts an integer, and will perform a factorial operation on it.
	 * @param number The integer to find the factorial of. MUST BE POSITIVE!
	 * @return The BigInteger factorial.
	 */
	public static BigInteger factorial(int number) {
		BigInteger fact = BigInteger.valueOf(number);
		if (number != 0) {
			if (number < 0) {
				throw new Error("You cannot find the factorial of a negative number!");
			} else {
				for (int i = number-1; i > 0; i--) {
					fact = fact.multiply(BigInteger.valueOf(i));
				}
			}
		} else {
			fact = BigInteger.valueOf(1);
		}
		return fact;
	}
	
	/**
	 * This accepts a positive or negative integer length and will return an "x" pattern
	 * @param length the integer defining the length to return
	 * @return A String value that has "x" specified in the length pattern.
	 */
	public static String xCreator(int length) {
		String returnString = "";
		String tempString = "";
		length = abs(length); // Most people look down on changing parameter values. Too bad I did it anyway.
		for (int i = 1; i <= length; i++) {
			tempString+= "x";
			returnString+= tempString + " ";
		}
		return returnString;
	}
	
}
