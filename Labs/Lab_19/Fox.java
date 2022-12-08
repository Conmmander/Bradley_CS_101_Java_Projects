public class Fox extends Animal { // I've half a mind to extend this off the dog class
	public Fox() {
		super("AWOOOOO", true, false, false);
	}
	
	public int numberOfLegs() {
		return 4;
	}
	
	public int  numberOfWings() {
		throw new RuntimeException("Foxes do not have wings!");
	}
	
	public void breatheUnderwater() {
		throw new RuntimeException("Foxes cannot breathe underwater!");
	}
}
