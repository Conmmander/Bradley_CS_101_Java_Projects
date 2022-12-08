public class Cat extends Animal {
	
	public Cat() {
		super("Meow", true, false, false);
	}
	
	public int numberOfLegs() {
		return 4;
	}
	
	public int  numberOfWings() {
		throw new RuntimeException("Cats do not have wings!");
	}
	
	public void breatheUnderwater() {
		throw new RuntimeException("Cats cannot breathe underwater!");
	}
}
