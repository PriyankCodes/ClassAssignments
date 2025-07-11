package com.tss.test;

import java.util.Scanner;

import com.tss.model.Students;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		Students student1 = new Students();

		System.out.println("Enter Student 1 Details : ");
		System.out.print("Enter RollNumber : ");
		student1.setRollNumber(scanner.nextInt());
		System.out.print("Enter Name : ");
		student1.setName(scanner.next());
		System.out.print("Enter Age : ");
		student1.setAge(scanner.nextInt());
		System.out.print("Enter marks of 3 Subject : ");
		student1.setSubjectMarks(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

		Students student2 = new Students();
		System.out.println();
		System.out.println("Enter Student 2 Details : ");
		System.out.print("Enter RollNumber : ");
		student2.setRollNumber(scanner.nextInt());
		System.out.print("Enter Name : ");
		student2.setName(scanner.next());
		System.out.print("Enter Age : ");
		student2.setAge(scanner.nextInt());
		System.out.print("Enter marks of 3 Subject : ");
		student2.setSubjectMarks(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

		student1.displayData();
		student2.displayData();

		
	}

}
