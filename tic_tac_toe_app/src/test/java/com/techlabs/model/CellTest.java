package com.techlabs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {
	
	Cell cell;
	
	@BeforeEach
	void init() {
		cell=new Cell();
	}

	@Test
	void testIsEmpty() {
		assertEquals(true, cell.isEmpty());
	}
	
	@Test
	void testMarkX() {
		cell.mark('X');
		assertEquals('X', cell.getMark());
	}
	
	@Test
	void testMarkO() {
		cell.mark('O');
		assertEquals('O', cell.getMark());
	}
	
	@Test
	void testMarkTwice() {
		cell.mark('O');
		assertThrows(IllegalStateException.class, ()->cell.mark('O'));
	}
	

}
