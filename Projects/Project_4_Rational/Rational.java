/**
* @author Ryan Dodd
* <p> Rational.java
* <p> Project4
* <p> This class represents a rational value with a numerator and denominator.
*/

import java.lang.Math.*; 

public class Rational implements Comparable {
	
	private long numerator; // numerator of the rational that the class represents.
	private long denominator; // denominator of the rational that the class represents.
	
	/**
	 * Default constructor. Initializes rational to 0.
	 */
	public Rational() {
		this.numerator = 0;
		this.denominator = 1;
	}

	/**
	 * Overloaded constructor that takes a singular long value.
	 * @param a (long) - The long value which initializes rational to a/1
	 */
	public Rational(long a) {
		this.numerator = a;
		this.denominator = 1;
	}

	/**
	 * Overloaded constructor that takes two long values for a/b
	 * @param a (long) - The numerator of the rational
	 * @param b (long) - The denominator of the rational.
	 * @throws ArithmeticException Only throws if b is 0.
	 */
	public Rational(long a, long b) throws ArithmeticException {
		if (b == 0) {
			throw new ArithmeticException("b may not be zero!");
		}
		
		long[] fixedRational = this.createReducedRational(a, b); // Required to reduce any potential unsimplified user inputs, and simplify math.
		this.numerator = fixedRational[0];
		this.denominator = fixedRational[1];
	}

	/**
	 * Returns the denominator of the rational.
	 * @return (long) - The denominator of the rational.
	 */
	public long getDenominator() {
		return this.denominator;
	}

	/**
	 * Returns the numerator of the rational.
	 * @return (long) - The numerator of the rational.
	 */
	public long getNumerator() {
		return this.numerator;
	}
	
	/**
	 * Returns a reduced and properly formatted rational.
	 * @param numerator (long) - The numerator of a rational.
	 * @param denominator (long) - The denominator of a rational
	 * @return (long[]) - Returns an array of two long values, the numerator and denominator.
	 */
	private long[] createReducedRational(long numerator, long denominator) { // Private because we don't need outside forces to access it.
		if ((numerator < 0 && denominator < 0) || (numerator > 0 && denominator < 0)) { // Formats for negatives
			numerator *= -1;
			denominator *= -1;
		}
		
		long divisor = Math.abs(this.gcd(numerator, denominator)); // Abs required or negative formatting is messed up.
		numerator /= divisor;
		denominator /= divisor;
		long[] arrayLong = {numerator, denominator};
		return arrayLong;
	}

	/**
	 * Adds two rationals.
	 * @param r (Rational) - The rational to add this one by.
	 * @return (Rational) - The new rational that has been created by adding these.
	 */
	public Rational add(Rational r) {
		if (r == null) r = new Rational(); // If null, adds 0.
		
		long numerator = (this.getDenominator() * r.getNumerator()) + (r.getDenominator() * this.getNumerator());
		long denominator = this.getDenominator() * r.getDenominator();
		return new Rational(numerator, denominator);
	}

	/**
	 * Subtracts two rationals.
	 * @param r (Rational) - The rational to subtrack this one by.
	 * @return (Rational) - The new rational that has been created by subtracking these.
	 */
	public Rational subtract(Rational r) {
		if (r == null) r = new Rational(); // If null, subtracts 0.
		
		long numerator = (r.getDenominator() * this.getNumerator()) - (this.getDenominator() * r.getNumerator());
		long denominator = this.getDenominator() * r.getDenominator();
		return new Rational(numerator, denominator);
	}

	/**
	 * Multiplies two rationals together.
	 * @param r (Rational) - The rational to multiply this one by.
	 * @return (Rational) - The new rational that has been created by multiplying these.
	 */
	public Rational multiply(Rational r) {
		if (r == null) r = new Rational(); // If null, multiplies 0.
		
		long numerator = this.getNumerator() * r.getNumerator();
		long denominator = this.getDenominator() * r.getDenominator();
		return new Rational(numerator, denominator);
	}

	/**
	 * Divides two rationals together.
	 * @param r (Rational) - The rational to divide this one by.
	 * @throws ArithmeticException Only throws if the denominator of the new rational is 0.
	 * @return (Rational) - The new rational that has been created by dividing these.
	 */
	public Rational divide(Rational r) throws ArithmeticException { // Flips the bottom rational up.
		if (r == null) r = new Rational(); // If null, divides 0.
		
		long numerator = this.getNumerator() * r.getDenominator();
		long denominator = this.getDenominator() * r.getNumerator();
		return new Rational(numerator, denominator); // This constructor already throws an ArithmeticException, and it will be sent back up the stack if the denominator is 0.
	}

	/**
	 * Firsts the greatest common divisor.
	 * @param p (long) - Number A of the GCD.
	 * @param q (long) - Number B of the GCD	
	 * @return The greatest integer of division;
	 */
	public long gcd(long p, long q)
	{
		if (p == 0)
            return q;
 
        return gcd(q % p, p);
	}

	public String toString() {
		if (this.getDenominator() == 1) return "" + this.getNumerator();

		if (this.getNumerator() == 0) return "0";
		
		return this.getNumerator() + "/" + this.getDenominator();
	}

	public int compareTo(Object obj) {
      if (obj == null) return -1;

		if (!(obj instanceof Rational)) return 1;

		if (this.equals((Rational)(obj))) return 0;

		return (this.subtract((Rational)(obj)).getNumerator() > 0 ? 1 : -1);
	}

	// Returns true if and only if obj are the same number or reference the same object
	public boolean equals(Object obj) {
		if (obj == null) return false;

		if (obj == this) return true;

		if (this.subtract((Rational)obj).getNumerator() == 0) return true;

		return false;
	}
}