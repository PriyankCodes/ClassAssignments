package com.tss.basics.switchcase;

import java.util.Scanner;

public class CheckSeason {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Month : ");
		String month = scanner.nextLine().toLowerCase();

		switch (month) {

		case "january":
			System.out.println("Winter");
			break;
		case "february":
			System.out.println("Winter");
			break;
		case "march":
			System.out.println("Summer");
			break;
		case "april":
			System.out.println("Summer");
			break;
		case "may":
			System.out.println("Summer");
			break;
		case "june":
			System.out.println("Summer");
			break;
		case "july":
			System.out.println("Monsoon");
			break;
		case "august":
			System.out.println("Monsoon");
			break;
		case "september":
			System.out.println("Monsoon");
			break;
		case "october":
			System.out.println("Monsoon");
			break;
		case "november":
			System.out.println("Winter");
			break;
		case "december":
			System.out.println("Winter");
			break;

		default:
			System.out.println("Enter Correct Month Name");
		}

	}

}
