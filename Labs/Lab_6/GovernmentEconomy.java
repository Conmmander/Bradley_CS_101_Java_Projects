/**
 * @author Ryan Dodd
 * <p> GovernmentEconomy.java
 * <p> CS_101_Lab_6
 * <p> This program takes into account various economic factors and recommends changes based on inputs read in.
 */

import java.util.Scanner;
public class GovernmentEconomy {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter in a growth rate as a decimal: ");
		double growthRate = input.nextDouble();
		System.out.print("Enter in inflation rate as a decimal: ");
		double inflation = input.nextDouble();
		input.close();
		String policyChange = "No change in economic policy";
		if (growthRate < 0.01) {
			if (inflation < 0.03) {
				policyChange = "Increase welfare spending, reduce personal taxes, and decrease discount rate.";
			} else {
				policyChange = "Reduce business taxes.";
			}
		} else if (growthRate > 0.04) {
			if (inflation < 0.01) {
				policyChange = "Increase personal and business taxes, and decrease discount rate.";
			} else if (inflation > 0.03) {
				policyChange = "Increase discount rate.";
			}
		}
		System.out.println(policyChange);
	}

}
