/**
 * @author Ryan Dodd
 * <p> Kennel.java
 * <p> CS_101_Lab_10
 * <p> This shows how classes are made, and contains a kennel. The kennel is a very happy place!
 */

public class Kennel {

	public static void main(String[] args) {
		Dog daisy = new Dog();
		Dog christmas = new Dog("Christmas");
		Dog wolfy = new Dog("3L0N MU2K N4M3 H3R3");
		System.out.println("Daisy Age in Human Years: " + daisy.humanAge());
		System.out.println("Christmas's Bark: " + christmas.speak());
		System.out.println();
		System.out.println(daisy);
		System.out.println();
		System.out.println(christmas);
		System.out.println();
		System.out.println(wolfy);
	}

}
