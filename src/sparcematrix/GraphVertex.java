/**
 * Created by Alexandre Miguel de Carvalho on 26/02/17, 12:12.
 * orcid.org/0000-0002-8801-4321
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */
package sparcematrix;


public class GraphVertex {

	private double matrixValue;
	private int row;
	private int col;



	public GraphVertex(int r, int c, double value) {
		matrixValue = value;
		row = r;
		col = c;
	}

	public double getMatrixValue() {
		return matrixValue;
	}

	public void setMatrixValue(double matrixValue) {
		this.matrixValue = matrixValue;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
}

