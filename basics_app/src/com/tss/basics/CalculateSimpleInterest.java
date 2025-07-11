package com.tss.basics;
import java.util.Scanner;

public class CalculateSimpleInterest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Principle Amount : ");
		double principle = sc.nextDouble();
		
		System.out.print("Enter Rate of Interest : ");
		double rateOfInterest = sc.nextDouble();
		
		System.out.print("Enter Duration : ");
		double duration = sc.nextDouble();
		
		calculateSimpleInterest(principle, rateOfInterest, duration);
		
	}
	
	private static void calculateSimpleInterest(double principle, double rateOfInterest, double duration) {
		
		double simpleInterest = (principle * rateOfInterest * duration)/100;
		
		System.out.println("Simple Interest is : "+simpleInterest);

	}

}
