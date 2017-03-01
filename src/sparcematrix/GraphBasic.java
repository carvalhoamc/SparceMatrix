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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphBasic {


	private int totalRow;
	private int totalCol;
	private int totalNotNullElement;
	private GraphVertex[] vertexList;
	private LinkedList[] adjacencyList;
	private static List<String> dataFromFile = new ArrayList<>();


	public GraphBasic() {
		totalRow = 0;
		totalCol = 0;
		totalNotNullElement = 0;
	}


	public LinkedList[]  loadSparceMatrix(File arquivo) throws IOException {
		/**
		 * 4,4         	Matrix dimentions
		 * 1,1,50.0		row,col,value
		 * 2,1,10.0
		 * 2,3,20.0
		 * 4,1,-30.0
		 * 4,3,-60.0
		 * 4,4,5.0
		 *
		 * In this case there are 6 vertex
		 */

		String s;
		try(BufferedReader reader = new BufferedReader(new FileReader(arquivo))){

			while((s = reader.readLine()) != null)
			{
				dataFromFile.add(s);
				totalNotNullElement++;
			}
		}
		totalNotNullElement--;
		int j = 1;
		int coma1Position;
		int coma2Position;
		int row;
		int col;
		double vAux;
		String aux;
		s = dataFromFile.get(0);
		coma1Position = s.indexOf(',');
		aux = s.substring(0, coma1Position);
		totalRow = Integer.parseInt(aux);
		aux = s.substring(coma1Position + 1);
		totalCol = Integer.parseInt(aux);

		vertexList = new GraphVertex[totalNotNullElement];
		adjacencyList = new LinkedList[totalRow];



		for (int i = 0; i < totalNotNullElement; i++) {
			s = dataFromFile.get(j);
			coma1Position = s.indexOf(',');
			aux = s.substring(0, coma1Position);
			row = Integer.parseInt(aux);
			row--; //because JAVA begin with index 0
			coma2Position = s.indexOf(',', coma1Position + 1);
			aux = s.substring(coma1Position + 1, coma2Position);
			col = Integer.parseInt(aux);
			col--;
			aux = s.substring(coma2Position + 1);
			vAux = Double.parseDouble(aux);
			j++;
			GraphVertex v = new GraphVertex(row, col, vAux);
			vertexList[i] = v;
		}

		for(int i = 0; i < totalRow; i++){
			adjacencyList[i] = new LinkedList();
		}

		for (int i = 0; i < totalNotNullElement; i++){
			row = vertexList[i].getRow();
			adjacencyList[row].addLast(vertexList[i]);



		}

		return adjacencyList;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getTotalCol() {
		return totalCol;
	}

	public void setTotalCol(int totalCol) {
		this.totalCol = totalCol;
	}

	public int getTotalNotNullElement() {
		return totalNotNullElement;
	}

	public void setTotalNotNullElement(int totalNotNullElement) {
		this.totalNotNullElement = totalNotNullElement;
	}

	public GraphVertex[] getVertexList() {
		return vertexList;
	}

	public void setVertexList(GraphVertex[] vertexList) {
		this.vertexList = vertexList;
	}

	public LinkedList[] getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(LinkedList[] adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public static List<String> getDataFromFile() {
		return dataFromFile;
	}

	public static void setDataFromFile(List<String> dataFromFile) {
		GraphBasic.dataFromFile = dataFromFile;
	}
}
