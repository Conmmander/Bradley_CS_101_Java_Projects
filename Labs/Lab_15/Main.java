import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("A: ");
			double a = input.nextDouble();
			System.out.print("B: ");
			double b = input.nextDouble();
			System.out.print("C: ");
			double c = input.nextDouble();
			QuadraticSolver quad = new QuadraticSolver(a, b, c);
			System.out.println(quad);
			System.out.println("Roots: " + quad.computeRootOne() + ", " + quad.computeRootTwo());
		} catch (Exception e) {
			System.out.println(e);
		}
		input.close();
	}

}
