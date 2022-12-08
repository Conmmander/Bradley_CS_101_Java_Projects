public class Dog extends Animal {
	
	public Dog() {
		super("Woof", true, false, false);
	}
	
	public int numberOfLegs() {
		return 4;
	}
	
	public int  numberOfWings() {
		throw new RuntimeException("Dogs do not have wings!");
	}
	
	public void breatheUnderwater() {
		throw new RuntimeException("Dogs cannot breathe underwater!");
	}
}
