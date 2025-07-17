package com.techlabs.model;

public class Board {
	public final int SIZE = 3;
	Cell[][] cells;
	
	public Board() {
		cells = new Cell[SIZE][SIZE];
		for(int row=0; row< SIZE; row++) {
			for(int col=0; col<SIZE; col++) {
				cells[row][col] = new Cell();
			}
		}
	}
	
	public boolean isFull() {
		for(int row=0; row<SIZE; row++) {
			for(int col=0; col<SIZE; col++) {
				if(cells[row][col].getMark()=='_') {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public boolean checkWin(char symbol) {
		//check for horizontal wins
		for(int row=0; row<SIZE; row++) {
			if(cells[row][0].getMark() == symbol && cells[row][1].getMark() == symbol && cells[row][2].getMark() == symbol) {
				return true;
			}
		}
		
		//check for vertical wins
		for(int col=0; col<SIZE; col++) {
			if(cells[0][col].getMark() == symbol && cells[1][col].getMark() == symbol && cells[2][col].getMark() == symbol) {
				return true;
			}
		}
		
		//check for diagonal top left to bottom right
		if(cells[0][0].getMark() == symbol && cells[1][1].getMark() == symbol && cells[2][2].getMark() == symbol) {
			return true;
		}
		
		//check for diagonal top right to bottom left
		if(cells[0][2].getMark() == symbol && cells[1][1].getMark() == symbol && cells[2][0].getMark() == symbol) {
			return true;
		}
		
		return false;
		
	}
	
	
	public void markAt(int row, int col, char symbol) {
		if(row<0 ||row>=SIZE || col<0 || col>=SIZE) {
			throw new IllegalArgumentException("Row and column out of bounds.");
		}
		cells[row][col].mark(symbol);
	}
	
	
	public void displayCurrentBoard() {
		System.out.println("Current Board: ");
		for(int row=0; row< SIZE; row++) {
			for(int col=0; col<SIZE; col++) {
				System.out.print(cells[row][col].getMark()+" ");
			}
			System.out.println();
		}
	}
}
