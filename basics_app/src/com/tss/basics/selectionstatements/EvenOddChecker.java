package com.tss.basics.selectionstatements;
import java.util.Scanner;

public class EvenOddChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Number to check Even/Odd : ");
		int number = scanner.nextInt();
		
		checkEvenOdd(number);
	}
	
	private static void checkEvenOdd(int number) {
		if(number%2 == 0) {
			System.out.println(number+" is Even Number");
		}
		else {
			System.out.println(number+" is Odd Number");
		}
	}

}
