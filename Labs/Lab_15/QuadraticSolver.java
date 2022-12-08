public class QuadraticSolver {
	private double a;
	private double b;
	private double c;
	
	public QuadraticSolver() {
		this.a = 1;
		this.b = 2;
		this.c = 1;
	}
	
	public QuadraticSolver(double a, double b, double c) {
		if (a == 0) {
			throw new QuadraticException("a cannot be 0!");
		}
		
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double computeDiscriminant() {
		return (Math.pow(this.b, 2) - (4 * this.a * this.c));
	}
	
	public boolean realSolutions() {
		return computeDiscriminant() >= 0;
	}
	
	public double computeRootOne() {
		double discriminant = computeDiscriminant();
		if (discriminant < 0)
			throw new NonRealException("Root one does not exist!");
		
		return (this.b + Math.sqrt(discriminant))/(2 * this.a);
		
	}
	
	public double computeRootTwo() {
		double discriminant = computeDiscriminant();
			if (discriminant < 0)
				throw new NonRealException("Root two does not exist!");
		
		return (this.b - Math.sqrt(computeDiscriminant()))/(2 * this.a);
	}
	
	public String toString() {
		String output = "";
		output =  this.a + "x^2";
		output = output + (this.b < 0 ? this.b + "x" : "+" + this.b + "x");
		output = output + (this.c < 0 ? this.c : "+" + this.c);
		return output;
	}
}
