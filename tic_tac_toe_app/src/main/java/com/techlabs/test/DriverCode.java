package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.Game;

public class DriverCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String value="y";
		while(value!="n") {
			Game game = new Game();
			game.start();
			
			System.out.println("Play again ?");
			value = scanner.nextLine();
		}
		
				
	}

}
