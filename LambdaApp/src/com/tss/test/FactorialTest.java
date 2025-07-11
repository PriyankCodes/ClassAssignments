package com.tss.test;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

public class FactorialTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number to find Factorial : ");
		int num = scanner.nextInt();

		Function<Integer, Integer> factorial = (number) -> {
			int fact = 1;
			for (int i = 1; i <= number; i++) {
				fact *= i;
			}
			return fact;
		};

		Supplier random = ()->{
			Random randomNumber = new Random();
			return randomNumber.nextInt();
		};
		
		System.out.println(random.get());
		System.out.println("Factorial is : " + factorial.apply(num));

	}

}
