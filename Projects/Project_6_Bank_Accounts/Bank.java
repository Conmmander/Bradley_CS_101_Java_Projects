import java.util.ArrayList;

/**
* @author Ryan Dodd
* <p> Bank.java
* <p> Project5
* <p> This class represents a basic bank
*/

public class Bank {
	private ArrayList<Account> accounts;
	
	/**
	 * Default constructor of a bank.
	 */
	public Bank() {
		this.accounts = new ArrayList<Account>();
	}
	
	/**
	 * Gets the amount of accounts in a bank.
	 * @return (int) - Returns the amount of accounts in the bank.
	 */
	public int size() {
		return this.accounts.size();
	}
	
	/**
	 * Adds an account to the bank.
	 * @param accountToAdd (Account) The account to be added into the bank.
	 * @return (boolean) - Whether adding the account to the bank was successful or not.
	 */
	public boolean addAccount(Account accountToAdd) {
		if (accountToAdd == null)
			return false;

		if (this.accounts.contains(accountToAdd))
			return false; // Bank already has this account.
					
		this.accounts.add(accountToAdd);
		return true;
	}
	
	public ArrayList<Account> getFiltered() {
		ArrayList<Account> filteredAccounts = new ArrayList<Account>();
		
		for (Account a : this.accounts) {
			if (a.accept())
				filteredAccounts.add(a);
		}
		
		return filteredAccounts;
	}
}
