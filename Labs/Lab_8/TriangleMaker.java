/**
 * @author Ryan Dodd
 * <p> TriangleMaker.java
 * <p> CS_101_Lab_8
 * <p> This program takes an integer and outputs a triangle.
 */

import java.util.Scanner;
public class TriangleMaker {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of the equal sides in an isosceles triangle: ");
		int triangleSize = input.nextInt(); // Assume input brevity
		String triangle = "*\n";
		for (int i = 1; i < triangleSize; i++) {
			triangle = triangle + "*";
			for (int j = 0; j < i-1; j++) {
				if (i == triangleSize - 1) {
					triangle += "*";
				} else {
					triangle += " ";
				}
			}
			triangle += "*\n";
		}
		System.out.print(triangle);
		input.close();
	}

}
