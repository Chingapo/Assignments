package com.swabhav.basics.home;

import java.util.Random;
import java.util.Scanner;

public class PIGRevised {

	public static void main(String[] args) {

		int total = 0;
		int turn = 1;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("The goal is to reach higher than 20 without getting a 1");

		while (turn <= 5) {
			int subTotal=0;
			System.out.println("Turn no: " + turn);
			
			
			subTotal = getInput(scanner, subTotal, total);
			total+=subTotal;
			
			System.out.println("Total score till turn " + turn + " is " + total);
			
			if(isWin(total)) {
				System.out.println("You finished in " + turn + " turns");
				break;
			}
			
			turn++;
		}

	}

	private static boolean isWin(int total) {
		// TODO Auto-generated method stub
		if(total>20) {
			System.out.println("You win !! HALLELUJAH!!");
			
			return true;
		}
		return false;
	}

	private static int getInput(Scanner scanner, int subTotal, int total) {
	
		
		System.out.println("Roll or Hold ??? (r/h)");
		char input = scanner.next().charAt(0);
		if(input=='h') {
			return subTotal;
		}
		if (input == 'r') {
			subTotal = roll(subTotal);
			if(subTotal==0) return 0;
			System.out.println("Total: "+ total + "SubTotal: "+ subTotal);
			total+=subTotal;
			isWin(total);
			System.out.println("Score at the moment is: " + subTotal);
			subTotal=getInput(scanner, subTotal, total);
			return subTotal;
			
		}
		System.out.println("Choose correct option.");
		return getInput(scanner, subTotal, total);
		
	}

	private static int roll(int subTotal) {
		Random random = new Random();
		int currRoll = random.nextInt(6) + 1;
		System.out.println("your current roll was: " + currRoll);
		
		if (currRoll == 1) {
			System.out.println("turn skipped, bad luck");
			return 0;
		}
		subTotal+=currRoll;
		return subTotal;
	}

}
