/**
 * @author Ryan Dodd
 * <p> Dog.java
 * <p> CS_101_Lab_10
 * <p> Dog class for the project. It is the model of all dogs.
 */

import java.util.regex.*;

public class Dog {
	public enum Tail {
		LONG,
		SHORT,
		NONE
	}
	
	private int age;
	private String name;
	private String bark;
	private boolean longHair;
	private float weight;
	private Tail tail;
	
	/**
	 * Main dog constructor class
	 * @return Dog Object
	 */
	public Dog() {
		this.age = 1;
		this.name = "Daisy";
		this.bark = "Wroof";
		this.longHair = false;
		this.weight = 15;
		this.tail = Tail.LONG;
	}
	
	/**
	 * Overloaded constructor for dog class. Accepts a parameter
	 * @param name - This is the name of the dog. It can only be alphabetical characters.
	 * @return Dog Object
	 */
	public Dog(String name) {
		this.name = validName(name) ? name : "Wolfy";
		this.age = 1;
		this.bark = "Wroof";
		this.longHair = false;
		this.weight = 15;
		this.tail = Tail.LONG;
	}
	
	/**
	 * This will change a dogs age based on human years.
	 * @return dog's age * 7 as an integer.
	 */
	public int humanAge() {
		return this.age * 7;
	}
	
	/**
	 * This method returns the dogs bark.
	 * @return will return the dogs bark as a string.
	 */
	public String speak() {
		return this.bark;
	}
	
	/**
	 * This is the validName method, to check if a dog's name is valid.
	 * @param dogName - A string value that is the dogs name
	 * @return boolean true or false based on if the dogs name is purely alphabetical or not.
	 */
	private boolean validName(String dogName) {
		for (int i = 0; i < dogName.length(); i++) {
			if (!Pattern.matches("[a-zA-Z]", Character.toString(dogName.charAt(i)))) {// Should hypothetically accept all characters from a-z, A-Z inclusive.
				// I'm sure there is a better way to do this with regex, but I don't want to spend the time figuring it out/dealing with counters and so on.
				return false;
			};
		}
		return true;
	}
	
	/* If this class is printed without this Override, then it will simply return its value in memory. We are people 
	 * of "great talent", so we tell Java that this is overrode, and that something other than that will be spat out.*/
	/**
	 * This will print the class when we call S.O.P or anything else.
	 * @return String that we want to return for whatever is calling this.
	 */
	@Override
	public String toString() {
		return this.name + ":\nAge: " + this.age + "\nWeight: " + this.weight + "\nBark: " + this.bark + "\nLong Hair: " + this.longHair + "\nTail Type: " + this.tail;
	}
}
