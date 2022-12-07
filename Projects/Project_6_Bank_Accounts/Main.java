/**
* @author Ryan Dodd
* <p> Main.java
* <p> Project6
* <p> This is the main driver class for the bank stuff.
*/

public class Main {
	public static void main(String[] args) {
        AccountTester acctTester = new AccountTester();
        BankTester bankTester = new BankTester();

		System.out.println("\nAccount Tests:\n");
        acctTester.runAll();
        
		System.out.println("\nBank Tests:\n");
        bankTester.runAll();			
	}
}
