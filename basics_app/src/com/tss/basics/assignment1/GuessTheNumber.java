package com.tss.basics.assignment1;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		randomNumberGenerate();
	}

	private static void randomNumberGenerate() {
		Random random = new Random();
		int min = 1;
		int max = 100;
		int randomNumber = random.nextInt(max - min + 1) + min;
//		System.out.println(randomNumber);
		numberGuess(randomNumber);
	}

	private static void playAgain() {
		System.out.print("Do you want to play again? (YES/NO) : ");
		String choice = scanner.nextLine();

		if (choice.equalsIgnoreCase("yes")) {
			randomNumberGenerate();
		} else {
			System.out.println("Thanks for playing!");
		}
	}

	private static void numberGuess(int randomNumber) {
		int chance = 1;
		int number;

		while (chance < 11) {
			System.out.print("Guess the Number: ");

			number = scanner.nextInt();
			scanner.nextLine();

			if (number == randomNumber) {
				System.out.println("You guessed Correct...You Won in " + chance + " Attempts");
				playAgain();
				break;
			}

			if (number < randomNumber) {
				System.out.println("Sorry, Too Low");
			} else {
				System.out.println("Sorry, Too High");
			}

			if (chance == 10) {
				System.out.println("You Lost!! The number was: " + randomNumber);
				playAgain();
				break;
			}

			chance++;
		}
	}
}
