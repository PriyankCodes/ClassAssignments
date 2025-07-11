package com.tss.basics.whileloop;

import java.util.Random;

public class FindFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();

		int num = random.nextInt(6) + 1;
		int number = findFactorial(num);
		System.out.println("Number is : " + num);
		System.out.println("Factorial is : " + number);
		
	}

	private static int findFactorial(int num) {

		int factorial = 1;
		for (int i = 1; i <= num; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}
	
}
