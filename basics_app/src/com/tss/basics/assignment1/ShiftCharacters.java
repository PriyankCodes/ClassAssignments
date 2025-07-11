package com.tss.basics.assignment1;

import java.util.Scanner;

public class ShiftCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a String : ");
		String string = scanner.next();
		System.out.print("Enter Shifts : ");
		int shift = scanner.nextInt();

		StringBuilder shifted = new StringBuilder();

		for (int i = 0; i < string.length(); i++) {

			char character = string.charAt(i);
			if (Character.isUpperCase(character)) {
				char shiftedChar = (char)('A' + (character - 'A' + shift) % 26);
				shifted.append(shiftedChar);
			} else if (Character.isLowerCase(character)) {
				char shiftedChar = (char)('a' + (character - 'a' + shift) % 26);
				shifted.append(shiftedChar);
			} else {
				shifted.append(character);
			}
		}

		System.out.println("Shifted String : " + shifted);
	}

}
