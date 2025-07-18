package com.techlabs.model;

public class Cell {
	private Character mark;

	public Cell() {
		this.mark = null;
	}

	public Character getMark() {
		if(mark==null) {
			return '_';
		}
		return mark;
	}

	public void mark(char symbol) {
		if(mark!=null) {
			throw new IllegalStateException("Cell is already marked");
		}
		if(symbol!='X' && symbol!='O') {
			throw new IllegalArgumentException("Only X or O are allowed");
		}
		this.mark = symbol;
	}
	
	public boolean isEmpty() {
		return mark==null;
	}
}
