/**
 * @author Ryan Dodd
 * <p> RandomTelephone.java
 * <p> CS_101_Lab_4
 * <p> This program spits out random phone numbers where the first 3 digits lack an 8 and 9, and the middle digits are greater than 100 and less than 888.
 */
import java.util.Random;

public class RandomTelephone {
	public static void main(String[] args) {
		Random generateRandom = new Random(); 
		String first = Integer.toString(generateRandom.nextInt(0, 8)) + Integer.toString(generateRandom.nextInt(0, 8)) + Integer.toString(generateRandom.nextInt(0, 8));
		String middle = Integer.toString(generateRandom.nextInt(101, 888));
		String last = Integer.toString(generateRandom.nextInt(0, 10)) + Integer.toString(generateRandom.nextInt(0, 10)) + Integer.toString(generateRandom.nextInt(0, 10)) + Integer.toString(generateRandom.nextInt(0, 10));
		
		System.out.println("(" + first + ") " + middle + " - " + last);
	}
}
