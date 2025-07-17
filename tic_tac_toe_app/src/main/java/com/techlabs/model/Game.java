package com.techlabs.model;

import java.util.Scanner;

public class Game {
	Player currentPlayer;
	Player player1;
	Player player2;

	public void changePlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
			return;
		}
		currentPlayer = player1;
		return;
	}

	public void start() {
		System.out.println("Welcome to the game of Tic Tac Toe");
		System.out.println("This is a 2 player game, hope you have a friend nearby.");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter name of Player 1 (X)");
		String name = scanner.nextLine();
		player1 = new Player(name, 'X');

		System.out.println("Enter name of Player 2 (O)");
		name = scanner.nextLine();
		player2 = new Player(name, 'O');

		Board board = new Board();

		int turns = 1;
		int row;
		int col;
		currentPlayer = player1;

		for (int i = 0; i < 9; i++) {
			System.out.println("Turn number: " + turns);
			System.out.println("Player: " + currentPlayer.getName());
			System.out.println("Your symbol is: " + currentPlayer.getSymbol());
			board.displayCurrentBoard();

			System.out.println("Enter coordinates where you wish to put your symbol");
			System.out.println("Row number: ");
			row = scanner.nextInt()-1;
			scanner.nextLine();
			System.out.println("Column number: ");
			col = scanner.nextInt()-1;
			scanner.nextLine();

			board.markAt(row, col, currentPlayer.getSymbol());

			board.displayCurrentBoard();
			if (board.checkWin(currentPlayer.getSymbol())) {
				System.out.println(currentPlayer.getName() + " Wins !!!");
				break;
			}
			changePlayer();
			turns++;
		}
		if(board.isFull()) {
			System.out.println("Its a DRAW !!!");
		}
	}
}
