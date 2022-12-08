/**
 * @author Ryan Dodd
 * <p> TargetRadius.java
 * <p> CS_101_Lab_5
 * <p> (DESCRIPTION)
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class TargetRadius {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the radius (in cm) of the entire target as a double: ");
		if (input.hasNextDouble()) {
			final double TOTAL_RADIUS = input.nextDouble();
			final double TOTAL_AREA = Math.PI * Math.pow(TOTAL_RADIUS, 2.0);
			final double PART_RADIUS = TOTAL_RADIUS/5;
			double yellowArea = Math.PI * Math.pow(PART_RADIUS, 2.0);
			double redArea = (Math.PI * Math.pow(PART_RADIUS * 2, 2.0)) - yellowArea;
			double blueArea = (Math.PI * Math.pow(PART_RADIUS * 3, 2.0)) - yellowArea - redArea;
			double blackArea = (Math.PI * Math.pow(PART_RADIUS * 4, 2.0)) - yellowArea - redArea - blueArea;
			double whiteArea = (Math.PI * Math.pow(PART_RADIUS * 5, 2.0)) - yellowArea - redArea - blueArea - blackArea;
			double yellowPercent = yellowArea/TOTAL_AREA;
			double redPercent = redArea/TOTAL_AREA;
			double bluePercent = blueArea/TOTAL_AREA;
			double blackPercent = blackArea/TOTAL_AREA;
			double whitePercent = whiteArea/TOTAL_AREA;
			DecimalFormat areaFormat = new DecimalFormat("#.####");
			DecimalFormat percentFormat = new DecimalFormat("#%");
			System.out.printf("The color yellow has area %s cm^2 with %s of the total area.\n", areaFormat.format(yellowArea), percentFormat.format(yellowPercent));
			System.out.printf("The color red has area %s cm^2 with %s of the total area.\n", areaFormat.format(redArea), percentFormat.format(redPercent));
			System.out.printf("The color blue has area %s cm^2 with %s of the total area.\n", areaFormat.format(blueArea), percentFormat.format(bluePercent));
			System.out.printf("The color blue has area %s cm^2 with %s of the total area.\n", areaFormat.format(blackArea), percentFormat.format(blackPercent));
			System.out.printf("The color white has area %s cm^2 with %s of the total area.\n", areaFormat.format(whiteArea), percentFormat.format(whitePercent));
		}
		input.close();

	}

}
