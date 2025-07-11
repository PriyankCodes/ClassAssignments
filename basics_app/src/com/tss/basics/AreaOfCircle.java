package com.tss.basics;
import java.util.Scanner;

public class AreaOfCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Radius of Circle : ");
		double radius = sc.nextDouble();
		
		calculateArea(radius);

	}
	
	private static void calculateArea(double radius) {
		double area = 3.14*radius*radius;
		System.out.println("Area of Circle : "+area);
	}

}
