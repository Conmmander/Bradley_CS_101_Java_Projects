/* 
 *  @author (Ryan Dodd) 
 * <p>      (TimeInterpreter.java) 
 * <p>      (CS 101 Project 1) 
 * <p>      (This code accepts three inputs of time (hours, minutes, seconds) and will then properly display them in time units up to days.) 
 */
import java.util.Scanner;
public class TimeInterpreter {

	public static void main(String[] args) {
		final int MINUTES_FACTOR = 60;
		final int HOURS_FACTOR = 3600;
		final int DAYS_FACTOR = 86400; // All the factors are based off seconds. Defined constants as required by the rubric
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the time in the form <hours minutes seconds>:");
		
		boolean negative = false;
		int days = 0;
		int hours = input.nextInt();
		int minutes = input.nextInt();
		long seconds = input.nextLong(); // Initialize variables and accept input. We assume our users are benevolent beings in this case.
		String secondString = "";
		
		input.close();
		seconds += (minutes * MINUTES_FACTOR) + (hours * HOURS_FACTOR); // Convert everything to seconds
		secondString = "The time consists of " + Long.toString(seconds) + "\n";
		
		days = (int)seconds/DAYS_FACTOR;
		seconds -= DAYS_FACTOR * days;
		
		hours = (int)seconds/HOURS_FACTOR;
		seconds -= HOURS_FACTOR * hours;
		
		minutes = (int)seconds/MINUTES_FACTOR;
		seconds -= MINUTES_FACTOR * minutes; // Calculate the individual values. Casting from long to int is necessary as a long cannot be stored in an int.

		if (days < 0) { // Remove negative from days
			negative = true;
			days *= -1;
		}
		if (hours < 0) { // Remove negative from hours
			negative = true;
			hours *= -1;
		}
		if (minutes < 0) { // Remove negative from minutes
			negative = true;
			minutes *= -1;
		}
		if (seconds < 0) { // Remove negative from seconds
			negative = true;
			seconds *= -1;
		}
		
		String finalString = "";
		
		if (negative) { // Adds the negative into the string
			finalString = "-";
		}
		
		if (days > 0) { // Checks output Brevity
			finalString = finalString + days + ":" + hours + ":" + minutes + ":" + seconds;;
		} else if (hours > 0) {
			finalString = finalString + hours + ":" + minutes + ":" + seconds;;
		} else if (minutes > 0) {
			finalString = finalString + minutes + ":" + seconds;;
		} else {
			finalString = finalString + seconds;;
		}

		if (days == 0 && hours == 0 && minutes == 0 && seconds == 0) { // Check to make sure that everything is not zero. If it is, make it zero.
			finalString = "0";
		}
		
		finalString = secondString + finalString;
		
		System.out.println(finalString);
	}

}
