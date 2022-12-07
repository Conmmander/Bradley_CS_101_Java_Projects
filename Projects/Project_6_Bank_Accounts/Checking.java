
/**
* @author Ryan Dodd
* <p> Checking.java
* <p> Project5
* <p> This class represents a checking account.
*/

public class Checking extends Account {
	
	/**
	 * Default Checking Account Constructor
	 */
	public Checking() {
		super();
	}
	
	/**
	 * Overloaded Checking Account Constructor
	 * @param startingBalance (double) - The starting balance of the account
	 * @param name (String) - The name of the account.
	 * @throws InsufficientFundsException
	 */
	public Checking(double startingBalance, String name) throws InsufficientFundsException {
		super(startingBalance, name);
	}

	/**
	 * Overloaded Checking Account Constructor
	 * @param name (String) - The name of the account.
	 */
	public Checking(String name) {
		super(0, name);
	}
	
	/**
	 * @Override
	 * Decides if the class is acceptable or not.
	 * @return (boolean) - True if it is linked to an acceptable account. False otherwise
	 */
	public boolean accept() {
		if (this.getLink() == null)
			return false;
		
		return this.getLink().accept();
	}
	
	/**
	 * @Override
	 * Withdraws an amount from the account.
	 * @param amt (double) - Amount to withdraw
	 * @throws InsufficientFundsException
	 */
	public void withdraw(double amt) throws InsufficientFundsException {
		if (this.getBalance() - amt < 0 && this.getLink() == null) // No money in this account, and no link.
        	throw new InsufficientFundsException("You do not have enough money to withdraw this amount!");
        
        if (this.getBalance() - amt < 0 && this.getLink() != null && (this.getLink().getBalance() + this.getBalance()) - amt < Savings.MIN_AMOUNT)
        	throw new InsufficientFundsException("You do not have enough money to withdraw this amount!"); // Neither account has enough to support this withdraw.
        
        if (this.getBalance() - amt < 0) {
        	double pullFromOther = Math.abs(this.getBalance() - amt);
        	
        	amt = this.getBalance(); // We need to set this balance to the minimum
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
    	if (linkAcct == null) 
    		return false;
    	
		if (linkAcct instanceof Checking) 
			return false;
		
		return super.link(linkAcct);
    }
	
    /**
     * @Override
     * Checks if two accounts are equal
     * @return (boolean) True if equal. False otherwise.
     */
    public boolean equals(Object obj) {
    	if (obj == null) return false;
    	
    	if (!(obj instanceof Checking)) return false;

    	return super.equals(obj);
    }
	
    /**
     * @Override
     * Returns the Account as a String
     * @return (String) - The string repreentation of the account.
     */
    public String toString() {
    	return "Checking " + super.toString();
    }
}
