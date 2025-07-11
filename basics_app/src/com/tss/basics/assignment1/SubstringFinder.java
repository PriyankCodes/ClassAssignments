package com.tss.basics.assignment1;

import java.util.Scanner;

public class SubstringFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a String : ");
		String string = scanner.nextLine();

		System.out.print("Enter a Sub String to Find : ");
		String subString = scanner.nextLine();

		subStringFinder(string, subString);
	}

	private static void subStringFinder(String string, String subString) {

		int stringLength = string.length();
		int subStringLength = subString.length();
		int i, j;
		int position = 0;
		for (i = 0; i <= stringLength - subStringLength; i++) {

			for (j = 0; j < subStringLength; j++) {
				if (string.charAt(i + j) != subString.charAt(j)) {
					break;
				}
				
			}
			position = i+1;
			if (j == subStringLength) {
				System.out.println("Substring found at position : "+position);
				return;
			}
		}

		System.out.println("Substring not found.");
	}

}
