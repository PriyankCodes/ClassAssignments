package com.tss.test;

import java.util.Scanner;

import com.tss.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Employee employee = new Employee();
		readData(employee);

		employee.displayData();
	}

	private static void readData(Employee employee) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Employee Deatils : ");

		System.out.print("Enter Employee ID : ");
		employee.setEmployeeId(scanner.nextInt());
		scanner.nextLine();

		System.out.print("Enter Name : ");
		employee.setName(scanner.nextLine());

		System.out.print("Enter Joining Date (dd-MM-yyyy) : ");
		employee.setJoiningDate(scanner.nextLine());

		System.out.print("Enter Salary : ");
		employee.setSalary(scanner.nextInt());
	}

}
