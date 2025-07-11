package com.tss.basics.switchcase;
import java.util.Random;

public class SwitchCaseBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		int number = random.nextInt(7);
		System.out.println("Generated Number : "+number);

		switch (number) {
		case 1:
			System.out.println("ONE");
			break;
		case 2:
			System.out.println("TWO");
			break;
		case 3:
			System.out.println("THREE");
			break;
		case 4:
			System.out.println("FOUR");
			break;
		case 5:
			System.out.println("FIVE");
			break;
		case 6:
			System.out.println("SIX");
			break;
		default:
			System.out.println("OUT OF 6");

		}
	}

}
