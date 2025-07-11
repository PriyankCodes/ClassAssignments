package com.tss.basics;
import java.util.Scanner;

public class CalculateDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter x1 : ");
		double x1 = sc.nextDouble();
		
		System.out.print("Enter y1 : ");
		double y1 = sc.nextDouble();
		
		System.out.print("Enter x2 : ");
		double x2 = sc.nextDouble();
		
		System.out.print("Enter y2 : ");
		double y2 = sc.nextDouble();
		
		calculateDistance(x1, x2, y1, y2);
		
	}
	
	private static void calculateDistance(double x1, double x2, double y1, double y2) {
		double deltax = (x2 - x1)*(x2 - x1) ;
		double deltay = (y2 -y1 )*(y2 - y1);
		
		double distance = Math.sqrt(deltax + deltay);
		
		System.out.println("The distance is: " + distance);
	}

}
