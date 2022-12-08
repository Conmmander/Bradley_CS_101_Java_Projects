public class Dog extends Animal {
	
	public Dog() {
		super("Woof", true, false, false, "Dog");
	}
	
	@Override
	public int numberOfLegs() {
		return 4;
	}
	
	@Override
	public int  numberOfWings() {
		throw new RuntimeException("Dogs do not have wings!");
	}
	
	@Override
	public void breatheUnderwater() {
		throw new RuntimeException("Dogs cannot breathe underwater!");
	}
}
