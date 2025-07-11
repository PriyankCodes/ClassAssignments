package com.tss.basics.selectionstatements;

import java.util.Scanner;

public class TreasureIslandGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Treasure Island Game !!!");
		System.out.print("Enter your choice (Left/Right) : ");
		String choice = scanner.nextLine();

		if (choice.equalsIgnoreCase("RIGHT")) {
			System.out.println("You Fall Into a Hole. Game Over !!!");
		} else if (choice.equalsIgnoreCase("LEFT")) {
			System.out.print("Enter your choice (Swin/Wait) : ");
			choice = scanner.nextLine();

			if (choice.equalsIgnoreCase("SWIM")) {
				System.out.println("You Attacked By Trout. Game Over !!!");
			} else if (choice.equalsIgnoreCase("WAIT")) {
				System.out.print("Choose which door you want to go (Red/Blue/Yellow/Else) : ");
				choice = scanner.nextLine();

				if (choice.equalsIgnoreCase("RED")) {
					System.out.println("You Burned BY Fire. Game Over !!!");
				} else if (choice.equalsIgnoreCase("BLUE")) {
					System.out.println("You Eaten By Beasts. Game Over !!!");
				} else if (choice.equalsIgnoreCase("YELLOW")) {
					System.out.println("Congratulations. You Won !!!!!");
				} else {
					System.out.println("Game Over !!!");
				}

			} else {
				System.out.println("You Attacked By Trout. Game Over !!!");
			}
		} else {
			System.out.println("You Fall Into a Hole. Game Over !!!");
		}
	}

}
