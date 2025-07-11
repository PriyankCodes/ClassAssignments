package com.tss.test;

import java.util.Scanner;
import java.util.function.Predicate;

public class EvenOddChecker {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number to Check Even or Odd : ");
		int num = scanner.nextInt();

		Predicate<Integer> evenOddCheck = (number) -> {
			if (number % 2 != 0)
				return false;

			return true;
		};

		if (evenOddCheck.test(num)) {
			System.out.println(num + " is Even");
		} else {
			System.out.println(num + " is Odd");
		}

	}

}
