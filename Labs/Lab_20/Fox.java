public class Fox extends Animal { // I've half a mind to extend this off the dog class
	public Fox() {
		super("Ring-ding-ding-ding-dingeringeding", true, false, false, "Fox");
	}
	
	@Override
	public int numberOfLegs() {
		return 4;
	}
	
	@Override
	public int  numberOfWings() {
		throw new RuntimeException("Foxes do not have wings!");
	}
	
	@Override
	public void breatheUnderwater() {
		throw new RuntimeException("Foxes cannot breathe underwater!");
	}
}
