
import java.security.InvalidParameterException;

/**
* @author Ryan Dodd
* <p> CappedChecking.java
* <p> Project5
* <p> This class represents a capped checking account
*/

public class CappedChecking extends Checking {
	
	final static double MAX_AMOUNT = 10000;
	
	/**
	 * Default Capped Checking Account Constructor
	 */
	public CappedChecking() {
		super();
	}
	
	/**
	 * Overloaded Capped Checking Account Constructor
	 * @param startingBalance (double) - The starting balance of the account
	 * @param name (String) - The name of the account.
	 * @throws InsufficientFundsException, LinkAccountException
	 */
	public CappedChecking(double startingBalance, String name) throws LinkAccountException, InsufficientFundsException {
		super(startingBalance, name);
		
		if (startingBalance > 10000)
			throw new LinkAccountException("You cannot put more than 10000 in a capped checking account!");
	}
	
	/**
	 * Overloaded Capped Checking Account Constructor
	 * @param name (String) - The name of the account.
	 */
	public CappedChecking(String name) {
		super(name);
	}
	
	/**
	 * @Override
	 * Adds an amount to a capped checking account.
	 * @param amt (double) - The amount to add to an account.
	 * @throws LinkAccountException, InvalidParameterException
	 */
	public void deposit(double amt) throws LinkAccountException, InvalidParameterException {
		if (this.getBalance() + amt > MAX_AMOUNT && this.getLink() == null)
			throw new LinkAccountException("You tried to deposit too many funds, and do not have a linked account!");
		
		if (this.getBalance() + amt > 10000) {
			double amountToDepositThere = (this.getBalance() + amt) - MAX_AMOUNT;
			amt = MAX_AMOUNT - this.getBalance();
			this.getLink().deposit(amountToDepositThere);
		}
		
		super.deposit(amt);
	}
	
	/**
     * @Override
     * Checks if two accounts are equal
     * @return (boolean) True if equal. False otherwise.
     */
    public boolean equals(Object obj) {
    	if (obj == null) return false;
    	
    	if (!(obj instanceof CappedChecking)) return false;

    	return super.equals(obj);
    }
	
    /**
     * @Override
     * Returns the Account as a String
     * @return (String) - The string repreentation of the account.
     */
    public String toString() {
    	return "Capped-Checking " + super.toString();
    }
}
