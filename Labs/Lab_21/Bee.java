public class Bee implements HasWings {
	private int wings;
	
	public Bee() {
		this.wings = 2;
	}
	
	public int getNumberOfWings() {
		return this.wings;
	}
	
	public String toString() {
		return "I am a Bee.";
	}
}
