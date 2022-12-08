public class Fish extends Animal {
	public Fish() {
		super("Blub", false, false, true);
	}
	
	public int numberOfLegs() {
		throw new RuntimeException("Fish do not have legs!");
	}
	
	public int  numberOfWings() {
		throw new RuntimeException("Fish do not have wings!");
	}
}
