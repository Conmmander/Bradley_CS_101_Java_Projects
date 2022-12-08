public class Desk implements HasLegs {
	private int legs;
	
	public Desk() {
		this.legs = 4;
	}
	
	public int getNumberOfLegs() {
		return this.legs;
	}
	
	public String toString() {
		return "I am a Desk.";
	}
}
