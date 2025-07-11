package com.tss.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.tss.model.Employee;
import com.tss.model.EmployeeNameComparator;
import com.tss.model.EmployeeSalaryComparator;

public class EmployeeTest {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> employees = new ArrayList<Employee>();

		while (true) {
			System.out.println("\n1. Enter Employee Data \n2. Display Employee Data");
			System.out.println("3. Sort By EmployeeID ");
			System.out.println("4. Sort By Name ");
			System.out.println("5. Sort By Salary ");
			System.out.println("6. Exit");

			System.out.print("Enter Choice : ");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				readEmployee(employees);
				break;

			case 2:
				printEmployee(employees);
				break;

			case 3:
				Collections.sort(employees);
				printEmployee(employees);
				break;

			case 4:
				Collections.sort(employees, new EmployeeNameComparator());
				printEmployee(employees);
				break;

			case 5:
				Collections.sort(employees, new EmployeeSalaryComparator());
				printEmployee(employees);
				break;

			case 6:
				System.exit(0);
				break;

			default:
				System.out.println("Enter Valid Choice...");
			}
		}

	}

	private static void printEmployee(List<Employee> employees) {
		// TODO Auto-generated method stub
		System.out.println();
		for (Employee employee : employees) {
			System.out.println(employee);
		}

	}

	private static void readEmployee(List<Employee> employees) {

		System.out.print("Enter Employee ID : ");
		int employeeId = scanner.nextInt();
		System.out.print("Enter Employee Name : ");
		String name = scanner.next();
		System.out.print("Enter Employee Salary : ");
		double salary = scanner.nextDouble();

		employees.add(new Employee(employeeId, name, salary));
	}

}
