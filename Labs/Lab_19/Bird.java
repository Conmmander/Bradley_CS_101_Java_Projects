public class Bird extends Animal {
	public Bird() {
		super("Tweet", true, true, false);
	}
	
	public int numberOfLegs() {
		return 2;
	}
	
	public int  numberOfWings() {
		return 2;
	}
	
	public void breatheUnderwater() {
		throw new RuntimeException("Birds cannot breathe underwater!");
	}
}
