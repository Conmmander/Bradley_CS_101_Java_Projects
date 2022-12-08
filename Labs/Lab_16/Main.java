import java.util.Scanner;

/**
 * @author Ryan Dodd
 * <p> Main.java
 * <p> CS_101_Lab_16
 * <p> This is the driver class for the array utility class.
 */

public class Main {

	private static int[] buildArray() {
		System.out.print("Enter the length of the array: ");
		Scanner input = new Scanner(System.in);
		int arrayLength = input.nextInt();
		System.out.println("Enter all the values in the array, separated by whitespace: ");
		int[] arr = new int[arrayLength];
		for (int i = 0; i <arrayLength; ++i) {
			arr[i] = input.nextInt();
		}
		input.close();
		return arr;
	}
	
	public static void main(String[] args) {
		int[] array = buildArray();
		System.out.println("Max Index: " + ArrayUtil.findMax(array));
		System.out.println("Min Index: " + ArrayUtil.findMin(array));
		System.out.println("Mean: " + ArrayUtil.mean(array));
		ArrayUtil.populate(array);
		for (int i = 0; i <array.length; ++i) {
			System.out.print(array[i] + " ");
		}
		
	}

}
