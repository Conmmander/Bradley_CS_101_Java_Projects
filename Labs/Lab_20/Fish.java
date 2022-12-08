public class Fish extends Animal {
	public Fish() {
		super("Blub", false, false, true, "Fish");
	}
	
	@Override
	public int numberOfLegs() {
		throw new RuntimeException("Fish do not have legs!");
	}
	
	@Override
	public int  numberOfWings() {
		throw new RuntimeException("Fish do not have wings!");
	}
	
	@Override
	public void breatheUnderwater() {
		return;
	}
}
