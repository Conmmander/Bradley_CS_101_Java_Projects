
/**
* @author Ryan Dodd
* <p> Savings.java
* <p> Project5
* <p> This class represents a savings account
*/

public class Savings extends Account {
	
	final static double MIN_AMOUNT = 100;
	
	/**
	 * Default Savings Account Constructor
	 */
	public Savings() {
		super();
	}
	
	/**
	 * Overloaded Savings Account Constructor
	 * @param startingBalance (double) - The starting balance of the account
	 * @param name (String) - The name of the account.
	 * @throws InsufficientFundsException
	 */
	public Savings(double startingBalance, String name) throws InsufficientFundsException {
		super(startingBalance, name);
		
		if (startingBalance < MIN_AMOUNT )
			throw new InsufficientFundsException("You must have " + MIN_AMOUNT + " or more funds to start a savings account!");	
	}
	
	/**
	 * Overloaded Savings Account Constructor
	 * @param name (String) - The name of the account.
	 */
	public Savings(String name) {
		super(0, name);
	}
	
	/**
	 * @Override
	 * Determines if the account is acceptable or not.
	 * @return (boolean) - True if the account is above $100, false otherwise.
	 */
	public boolean accept() {
		if (this.getBalance() < MIN_AMOUNT)
			return false;
		
		return true;
	}
	
	/**
	 * @Override
	 * Facilitates withdraws from an account, keeping it at a minimum of 100 dollars.
	 * @throws InsufficientFundsException
	 */
	public void withdraw(double amt) throws InsufficientFundsException {
		if (this.getBalance() - amt < Savings.MIN_AMOUNT && this.getLink() == null) // No money in this account, and no link.
        	throw new InsufficientFundsException("You do not have enough money to withdraw this amount!");
		
        if (this.getBalance() - amt < Savings.MIN_AMOUNT && this.getLink() != null && (this.getLink().getBalance() + this.getBalance()) - amt < Savings.MIN_AMOUNT)
        	throw new InsufficientFundsException("You do not have enough money to withdraw this amount!"); // Neither account has enough to support this withdraw.
        
        if (this.getBalance() - amt < Savings.MIN_AMOUNT) {
        	double pullFromOther = Savings.MIN_AMOUNT - Math.abs(this.getBalance() - amt);
        	
        	amt = this.getBalance() - Savings.MIN_AMOUNT; // We need to set this balance to the minimum
        	this.getLink().withdraw(pullFromOther);
        }
        
        super.withdraw(amt);
	}
	
	/**
	 * @Override
	 * Allow accounts be be linked together.
	 * @return (boolean) - If the linkage was successful
	 */
    public boolean link(Account linkAcct) {
    	if (linkAcct == null) return false;
    	
		if (linkAcct instanceof Savings) return false;
		
		return super.link(linkAcct);
    }
	
	/**
     * @Override
     * Checks if two accounts are equal
     * @return (boolean) True if equal. False otherwise.
     */
    public boolean equals(Object obj) {
    	if (obj == null) return false;
    	
    	if (!(obj instanceof Savings)) return false;

    	return super.equals(obj);
    }
	
    /**
     * @Override
     * Returns the Account as a String
     * @return (String) - The string repreentation of the account.
     */
    public String toString() {
    	return "Savings " + super.toString();
    }
}
