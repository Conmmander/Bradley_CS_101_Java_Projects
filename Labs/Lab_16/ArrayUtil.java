import java.util.Random;

/**
 * @author Ryan Dodd
 * <p> ArrayUtil.java
 * <p> CS_101_Lab_16
 * <p> This provides static methods for Arrays
 */

public class ArrayUtil {
	private ArrayUtil() {};
	
	/**
	 * Finds the index of the smallest value in an array.
	 * @param array (int[]) - An integer array of length greater than 0
	 * @return (int) - The index of the smallest value in the array.
	 */
	public static int findMin(int[] array) {
		if (array.length <= 0)
			throw new RuntimeException("Cannot pass this method an array of length 0!");
		
		int min = 0;
		for (int i = 1; i < array.length; ++i) {
			if (array[min] > array[i]) {
				min = i;
			}
		}
		return min;
	}
	
	/**
	 * Finds the index of the largest value in an array.
	 * @param array (int[]) - An integer array of length greater than 0
	 * @return (int) - The index of the largest value in the array.
	 */
	public static int findMax(int[] array) {
		if (array.length <= 0)
			throw new RuntimeException("Cannot pass this method an array of length 0!");
		
		int max = 0;
		for (int i = 1; i < array.length; ++i) {
			if (array[max] < array[i]) {
				max = i;
			}
		}
		return max;
	}
	
	/**
	 * Returns the mean value of all the array values.
	 * @param array (int[]) An integer array of length greater than 0.
	 * @return (double) - The mean of all the values in the array.
	 */
	public static double mean(int[] array) {
		if (array == null || array.length <= 0)
			throw new RuntimeException("Cannot pass this method an array of length 0!");
		
		double total = 0;
		for (int i = 0; i < array.length; ++i) {
			total += array[i];
		}
		total /= array.length;
		
		return total;
	}
	
	/**
	 * This populates an array with random values from 0 to 100 inclusive.
	 * @param array (int[]) An integer array of length greater than 0.
	 */
	public static void populate(int[] array) {
		if (array.length <= 0)
			throw new RuntimeException("Cannot pass this method an array of length 0!");
		
		Random rnd = new Random();
		for (int i = 0; i < array.length; ++i) {
			array[i] = rnd.nextInt(0, 101);
		}
	}
}
