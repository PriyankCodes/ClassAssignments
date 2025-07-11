package com.tss.basics.commandline;
import java.util.Scanner;

public class SwapVar {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int number1 = Integer.parseInt(args[0]);
		
		int number2 = Integer.parseInt(args[1]);
		
		
		System.out.println("Before Swapping : ");
		System.out.println("Number1 : "+number1+", Number2 : "+number2);
		
		swapNumberWith(number1, number2);
		swapNumberWithout(number1, number2);

	}
	
	private static void swapNumberWith(int number1, int number2) {
		int temp = number1;
		number1 = number2;
		number2 = temp;
		
		System.out.println("After Swapping(With third Variable) : ");
		System.out.println("Number1 : "+number1+", Number2 : "+number2);
	}
	
	private static void swapNumberWithout(int number1, int number2) {
		number1 = number1 ^ number2;
		number2 = number1 ^ number2;
		number1 = number1 ^ number2;
		
		System.out.println("After Swapping(Without Third variable) : ");
		System.out.println("Number1 : "+number1+", Number2 : "+number2);
	}

}

