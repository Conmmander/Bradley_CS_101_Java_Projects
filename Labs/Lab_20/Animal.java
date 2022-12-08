public abstract class Animal
{
	private String soundMade;
	private boolean hasLegs;
	private boolean hasWings;
	private boolean hasGills;
	private String type;
	
	public Animal(String soundMade, boolean hasLegs, boolean hasWings, boolean hasGills, String type) {
		this.soundMade = soundMade;
		this.hasLegs = hasLegs;
		this.hasWings = hasWings;
		this.hasGills = hasGills;
		this.type = type;
	}
	
	public String getSoundMade() {
		return this.soundMade;
	}
	
	public String getType() {
		return this.type;
	}
	
	public abstract int numberOfLegs();

	public abstract int numberOfWings();

	public boolean hasLegs() {
		return this.hasLegs;
	}

	public boolean hasWings() {
		return this.hasWings;
	}

	public boolean hasGills() {
		return this.hasGills;
	}

	public abstract void breatheUnderwater();
	
	public static void PrintDetails( Animal a ) {
		if (a == null) 
			return;
		
		String outputDetails = "";
		if (a.hasLegs()) {
			outputDetails += "A " + a.getType() + " has " + a.numberOfLegs() + " legs.\n";
		}
		if (a.hasWings()) {
			outputDetails += "A " + a.getType() + " has " + a.numberOfWings() + " wings.\n";
		}
		if (a.hasGills()) {
			outputDetails += "A " + a.getType() + " can breathe under water.\n";
		}
		outputDetails += "A " + a.getType() + " makes the sound " + a.getSoundMade();
		System.out.println(outputDetails);
	}
}
