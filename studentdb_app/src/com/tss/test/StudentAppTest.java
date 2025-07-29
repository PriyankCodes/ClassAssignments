package com.tss.test;

import java.util.Scanner;
import com.tss.controller.StudentController;

public class StudentAppTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		StudentController controller = new StudentController();
		int choice;

		do {
			System.out.println("\n1. Read All Students");
			System.out.println("2. Add New Student");
			System.out.println("3. Read A Student By ID");
			System.out.println("4. Update Students Percentage By Id");
			System.out.println("5. Delete a Student By Id");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				controller.readAllRecords();
				break;
			case 2:
				controller.addNewStudent();
				break;
			case 3:
				controller.readStudentById();
				break;
			case 4:
				controller.updatePercentageById();
				break;
			case 5:
				controller.deleteStudentById();
				break;
			case 6:
				System.out.println("Exiting... Thank you!");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}

		} while (choice != 6);

		scanner.close();
	}
}
