package br.com.erick.ac.model2D;

import br.com.erick.ac.Cell;

public class CellularAutomata2D {
	
	private Cell[][] matrix;
	private String rule;
	private int size;
	
	public CellularAutomata2D(int size, int rule) {
		setRule(rule);
		this.size = size;
		initMatrix(size);
	}
	
	public String getRule() {
		return this.rule;
	}
	
	public void setRule(int rule) {
		String num = Integer.toBinaryString(rule);
		while(num.length() < 32) {
			num = "0" + num;
		}
		this.rule = new StringBuilder(num).reverse().toString();
	}
	
	private void initMatrix(int size) {
		this.matrix = new Cell[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				matrix[i][j] = new Cell(this.rule);
			}
		}
	}
	
	public void nextGen() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				try {
					String lrn = "" + matrix[i - 1][j].getPreviousStateString() +
							matrix[i][j - 1].getPreviousStateString() +
							matrix[i][j] + 
							matrix[i][j + 1] +
							matrix[i + 1][j];
					matrix[i][j].applyRule(lrn);
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
	}
	
	public String getFormatedFrame() {
		String frame = "";
		for(int i = 1; i < size - 1; i++) {
			for(int j = 1; j < size - 1; j++){
				frame += matrix[i][j] + " ";
			}
			frame += "\n";
		}
		return frame;
	}
	
	public String getFrame() {
		String frame = "";
		for(int i = 1; i < size - 1; i++) {
			for(int j = 1; j < size - 1; j++){
				frame += matrix[i][j];
			}
		}
		return frame;
	}
	
	public void setDefaultInitialPoint() {
		matrix[size/2][size/2].setCurrentState(true);
	}
}
