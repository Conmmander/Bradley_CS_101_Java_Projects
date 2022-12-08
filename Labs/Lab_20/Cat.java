public class Cat extends Animal {
	
	public Cat() {
		super("Meow", true, false, false, "Cat");
	}
	
	@Override
	public int numberOfLegs() {
		return 4;
	}
	
	@Override
	public int  numberOfWings() {
		throw new RuntimeException("Cats do not have wings!");
	}
	
	@Override
	public void breatheUnderwater() {
		throw new RuntimeException("Cats cannot breathe underwater!");
	}
}
