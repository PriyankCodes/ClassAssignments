package com.tss.test;

import java.util.Scanner;

import com.tss.database.Database;
import com.tss.model.Student;

public class DBTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Database studentDatabase = new Database();

        System.out.print("Enter Id : ");
        int id = scanner.nextInt();

        System.out.print("Enter roll no : ");
        int rollno = scanner.nextInt();

        scanner.nextLine(); // consume leftover newline

        System.out.print("Enter Name : ");
        String name = scanner.nextLine();

        System.out.print("Enter Age : ");
        int age = scanner.nextInt();

        System.out.print("Enter Percentage : ");
        double percentage = scanner.nextDouble();

        Student student = new Student(id, rollno, name, age, percentage);
        studentDatabase.addStudent(student);
        studentDatabase.readStudents(); 
    }
}
