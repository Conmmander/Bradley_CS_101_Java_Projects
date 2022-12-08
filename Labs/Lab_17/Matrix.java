/**
 * @author Ryan Dodd
 * <p> Matrix.java
 * <p> CS_101_Lab_17
 * <p> Matrix class which implements matrix functions
 */

public class Matrix {
	private int[][] matrix;
	
	public Matrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; ++i) { // Could check 1 row and column, but that won't catch every case.
			if (matrix[i].length != matrix.length) {
				throw new MatrixException("Matrix is not square!");
			}
		}
		
		this.matrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; ++i) {
			for (int k = 0; k < matrix[i].length; ++k) {
				this.matrix[i][k] = matrix[i][k];
			}
		}
	}
	
	public boolean rowSemiMagic() {
		int[] totals = new int[this.matrix.length];
		for (int i = 0; i < this.matrix.length; ++i) {
			for (int j = 0; j < this.matrix[i].length; ++j) {
				totals[i] = totals[i] + this.matrix[i][j];
			}
		}
		if (totals.length == 1) {
			return true;
		}
		
		for (int i = 0; i < totals.length - 1; ++i) {
			if (totals[i] != totals[i+1]) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean columnSemiMagic() {
		int[] totals = new int[this.matrix.length];
		for (int i = 0; i < this.matrix.length; ++i) {
			for (int j = 0; j < this.matrix[i].length; ++j) {
				totals[i] = totals[i] + this.matrix[j][i];
			}
		}
		if (totals.length == 1) {
			return true;
		}
		
		for (int i = 0; i < totals.length - 1; ++i) {
			if (totals[i] != totals[i+1]) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean magic() {
		return columnSemiMagic() && rowSemiMagic();
	}
	
	public String toString() {
		String output = "";
		for (int i = 0; i < this.matrix.length; ++i) {
			for (int k = 0; k < this.matrix[i].length; ++k) {
				output += this.matrix[i][k] + " ";
			}
			output += "\n";
		}
		return output;
	}
}
