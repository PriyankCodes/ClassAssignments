package com.tss.basics.whileloop;

import java.util.Scanner;

public class PalindromeChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a Number : ");
		int number = scanner.nextInt();
		int temp = number;
		int reverse = 0;
		int digit = 0;

		while(number>0) {
			digit = number % 10;
			reverse = reverse * 10 + digit;
			number = number / 10 ;
		}
		
		if(temp == reverse) {
			System.out.println(temp+" is Palindrome Number");
		}
		else {
			System.out.println(temp+" is not Palindrome Number");
		}
		

	}

}
