public class Bird extends Animal {
	public Bird() {
		super("Tweet", true, true, false, "Bird");
	}
	
	@Override
	public int numberOfLegs() {
		return 2;
	}
	
	@Override
	public int  numberOfWings() {
		return 2;
	}
	
	@Override
	public void breatheUnderwater() {
		throw new RuntimeException("Birds cannot breathe underwater!");
	}
}
