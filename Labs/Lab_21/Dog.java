public class Dog implements HasLegs {
	private int legs;
	
	public Dog() {
		this.legs = 4;
	}
	
	public int getNumberOfLegs() {
		return this.legs;
	}
	
	public String toString() {
		return "I am a Dog.";
	}
}
