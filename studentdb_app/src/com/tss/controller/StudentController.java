package com.tss.controller;

import java.util.List;
import java.util.Scanner;

import com.tss.model.Student;
import com.tss.service.StudentService;

public class StudentController {

	private StudentService studentService;
	Scanner scanner = new Scanner(System.in);

	public StudentController() {
		super();
		this.studentService = new StudentService();
	}

	public void readAllRecords() {
		List<Student> students = studentService.readAllStudent();

		for (Student student : students) {
			System.out.printf("%-8d %-20s %-6d %-12.2f %-10d%n", student.getStudentId(), student.getName(),
					student.getAge(), student.getPercentage(), student.getRollno());
		}
	}

	public void addNewStudent() {
		System.out.print("Enter Id : ");
		int id = scanner.nextInt();

		System.out.print("Enter roll no : ");
		int rollno = scanner.nextInt();

		scanner.nextLine();

		System.out.print("Enter Name : ");
		String name = scanner.nextLine();

		System.out.print("Enter Age : ");
		int age = scanner.nextInt();

		System.out.print("Enter Percentage : ");
		double percentage = scanner.nextDouble();

		Student student = new Student(id, rollno, name, age, percentage);

		studentService.addNewStudent(student);

	}

	public void readStudentById() {

		System.out.print("Enter Id : ");
		int id = scanner.nextInt();
		Student student = new Student();
		student.setStudentId(id);

		List<Student> students = studentService.readStudentById(student);

		if (students.isEmpty()) {
			System.out.println("No student found.");
			return;
		}
		for (Student studentt : students) {
			System.out.printf("%-8d %-20s %-6d %-12.2f %-10d%n", studentt.getStudentId(), studentt.getName(),
					studentt.getAge(), studentt.getPercentage(), studentt.getRollno());
		}
	}

	public void updatePercentageById() {
		System.out.print("Enter Id : ");
		int id = scanner.nextInt();

		System.out.print("Enter New Percentage : ");
		double percentage = scanner.nextDouble();

		Student student = new Student();
		student.setStudentId(id);
		student.setPercentage(percentage);

		studentService.updatePercentageById(student);
	}

	public void deleteStudentById() {
		System.out.print("Enter Id : ");
		int id = scanner.nextInt();
		Student student = new Student();
		student.setStudentId(id);

		studentService.deleteStudentById(student);
	}

}
