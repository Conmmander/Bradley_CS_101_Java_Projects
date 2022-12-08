/**
 * @author Ryan Dodd
 * <p> Tester.java
 * <p> CS_101_Lab_11
 * <p> This is the tester class for the Utilities.java
 */

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("-1, should return 1: " + Utilities.abs(-1));
		System.out.println("-20, should return 20: " + Utilities.abs(20));
		System.out.println("0, should return 0: " + Utilities.abs(0));
		System.out.println("5, should return 5: " + Utilities.abs(5));
		System.out.println();
		System.out.println("0, should return 0: " + Utilities.ceiling(0.0));
		System.out.println("3, should return 3: " + Utilities.ceiling(3.0));
		System.out.println("-1.2, should return -1: " + Utilities.ceiling(-1.2));
		System.out.println("1.2, should return 2: " + Utilities.ceiling(1.2));
		System.out.println();
		System.out.println("6 x's: " + Utilities.xCreator(6));
		System.out.println("0 x's: " + Utilities.xCreator(0));
		System.out.println("1 x's: " + Utilities.xCreator(1));
		System.out.println("2 x's: " + Utilities.xCreator(2));
		System.out.println();
		System.out.println("1!, should be 1: " + Utilities.factorial(1));
		System.out.println("0!, should be 1: " + Utilities.factorial(0));
		System.out.println("13!, should be 6227020800: " + Utilities.factorial(13));
		System.out.println("35!, should be 1.0333148e+40: " + Utilities.factorial(35));
		System.out.println("2!, should be 1: " + Utilities.factorial(2));
		System.out.println("3!, should be 6: " + Utilities.factorial(3));
		System.out.println("-2!, should error: " + Utilities.factorial(-2));
	}

}
