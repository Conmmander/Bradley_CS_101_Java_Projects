public class Kaboom implements HasWings {
	private int wings;
	
	public Kaboom() {
		this.wings = 2;
	}
	
	public int getNumberOfWings() {
		return this.wings;
	}
	
	public String toString() {
		return "I am Kaboom.";
	}
}
