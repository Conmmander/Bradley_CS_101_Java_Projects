public class Animal
{
	private String soundMade;
	private boolean hasLegs;
	private boolean hasWings;
	private boolean hasGills;
	
	public Animal(String soundMade, boolean hasLegs, boolean hasWings, boolean hasGills) {
		this.soundMade = soundMade;
		this.hasLegs = hasLegs;
		this.hasWings = hasWings;
		this.hasGills = hasGills;
	}
	
	public String getSoundMade() {
		return this.soundMade;
	}
	
	public int numberOfLegs() {
		return 0;
	};

	public int numberOfWings() {
		return 0;
	};

	public boolean hasLegs() {
		return this.hasLegs;
	}

	public boolean hasWings() {
		return this.hasWings;
	}

	public boolean hasGills() {
		return this.hasGills;
	}

	public void breatheUnderwater() {
		if (!this.hasGills) {
			throw new RuntimeException("Cannot breathe underwater!");
		}
	};
}
