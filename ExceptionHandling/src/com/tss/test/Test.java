package com.tss.test;

import java.util.Scanner;

public class Test  {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

			System.out.print("Enter Number 1 : ");
			int number1 = scanner.nextInt();

			System.out.print("Enter Number 2 : ");
			int number2 = scanner.nextInt();

			float result = number1 / number2;
			System.out.println("Division is = " + result);


		System.out.println("Executed...");
	}

}
