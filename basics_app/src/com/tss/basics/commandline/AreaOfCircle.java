package com.tss.basics.commandline;
import java.util.Scanner;

public class AreaOfCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		double radius = Double.parseDouble(args[0]);
		
		calculateArea(radius);

	}
	
	private static void calculateArea(double radius) {
		double area = 3.14*radius*radius;
		System.out.println("Area of Circle : "+area);
	}

}
