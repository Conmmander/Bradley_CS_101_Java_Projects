/**
 * @author Ryan Dodd
 * <p> Tester.java
 * <p> CS_101_Lab_17
 * <p> Drives the code to run
 */

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] mat = {{1, 5, 9},
					   {8, 3, 4},
					   {6, 7, 2}};
		int[][] mat2 = {{1, 5, 22},
				   		{8, 3, 4},
				   		{6, 7, 2}};
		int[][] mat3 = {{1, 5, 9, 10},
				   		{8, 3, 4},
				   		{6, 7, 2}};
		int[][] mat4 = {{2, 2},
						{3, 1}};
		Matrix matrix = new Matrix(mat);
		System.out.print(matrix);
		System.out.println("Row Magic: " + matrix.rowSemiMagic());
		System.out.println("Column Magic: " + matrix.columnSemiMagic());
		System.out.println("Magic: " + matrix.magic());
		Matrix matrix2 = new Matrix(mat2);
		System.out.print(matrix2);
		System.out.println("Magic: " + matrix2.magic());
		Matrix matrix4 = new Matrix(mat4);
		System.out.print(matrix4);
		System.out.println("Row Magic: " + matrix4.rowSemiMagic());
		System.out.println("Column Magic: " + matrix4.columnSemiMagic());
		System.out.println("Magic: " + matrix4.magic());
		Matrix matrix3 = new Matrix(mat3);
		System.out.print(matrix3);
	}

}
