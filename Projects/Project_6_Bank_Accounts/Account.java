import java.security.InvalidParameterException;

/**
* @author Ryan Dodd
* <p> Account.java
* <p> Project5
* <p> This class represents a basic Account
*/

public class Account implements Filterable {
    protected double balance;
    
    /**
     * Gets the balance of the account
     * @return (double) - The account balance.
     */
    public double getBalance() { 
    	return this.balance; 
    }
    
    protected String name;
    
    /**
     * Gets the name of the bank account.
     * @return (String) the bank account name.
     */
    public String getName() { 
    	return this.name; 
    }
    
    protected Account link;
    
    /**
     * Returns a linked bank account.
     * @return (Account) - The linked Account or null.
     */
    public Account getLink() { 
    	return this.link; 
    }

    /**
     * Default constructor for an account.
     */
	public Account() {
		this.balance = 0;
		this.name = "";
	}
	
	/**
	 * Overloaded constructor for an account.
	 * @param balance (double) - The starting account balance.
	 * @param name (String) - The name of the bank account.
	 */
	public Account(double balance, String name) {
		this.balance = balance;
		this.name = name;
	}
	
	/**
	 * Implements the accept method. As this is a base account, it is always deemed acceptable.
	 * @return (boolean) - Always returns true.
	 */
	public boolean accept() {
		return true;
	}
    
    /**
     * Links two accounts in both directions
     * @param linkAcct (Account) - The account to link to this one.
     * @return (boolean) - True or false depending on if the link can be made.
     */
    public boolean link(Account linkAcct) {
    	if (linkAcct == null)
    		return false;
    	
		if (linkAcct.equals(this.getLink()))
			return false;
		
		if (this.getLink() != null && linkAcct.getLink() != null && linkAcct.getLink().equals(this))
			return true; // Breaks out of an infinite loop when linking in both directions.
		
		this.unlink();
		
		this.link = linkAcct;
		linkAcct.link(this);
		return true;
		
    }

    /**
     * Withdraws money from accounts.
     * @param amt (double) - Amount of money to withdraw.
     * @throws InsufficientFundsException
     */
    public void withdraw(double amt) throws InsufficientFundsException {
        this.balance -= amt;
    }
    
    /**
     * Adds the specified amount to the bank account.
     * @param amt (double) The amount to add to the account.
     * @throws LinkAccountException, InvalidParameterException
     */
    public void deposit(double amt) throws InvalidParameterException, LinkAccountException {
    	if (amt < 0)
    		throw new InvalidParameterException("You cannot deposit a negative number into an account!");
    	
    	this.balance += amt;
    }
    
    /**
     * Unlinks two accounts from each other.
     */
    public void unlink() {
    	Account tempLink = this.getLink();
    			
    	this.link = null;
		if (tempLink != null) {
			tempLink.unlink();
		}
    }
       
    /**
     * @Override
     * Checks if this object is equal to that object.
     */
    public boolean equals(Object obj) {
    	if (obj == null) return false;
    	
    	if (!(obj instanceof Account)) return false;

    	Account that = (Account)obj;
    	
    	if (Math.abs(this.getBalance() - that.getBalance()) > 0.001) return false; 

    	if (!this.getName().equals(that.getName())) return false;
    	
    	if (this.getLink() != that.getLink()) return false;
    	
    	return this == obj;
    }
    
    /**
     * @Override
     * Returns this object as a string.
     * @return (String) the string representation of this object.
     */
    public String toString() {
    	String retS = "";
    	
    	retS += "Account: " + this.getName() + "\n";
    	retS += "\tBalance: " + this.getBalance() + "\n";
    	retS += "\tLinked account name: " + (this.getLink() == null ? "" : this.getLink().getName());
    	
    	return retS;
    }
}