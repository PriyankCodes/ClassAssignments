package com.tss.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.tss.model.Students;

public class StudentsGradeTest {

	public static void main(String[] args) {

		List<Students> students = new ArrayList<Students>();

		students.add(new Students("Priyank", 1, 100));
		students.add(new Students("Devang", 2, 95));
		students.add(new Students("Dharmik", 3, 89));
		students.add(new Students("Vivek", 4, 92));
		students.add(new Students("Dev", 5, 85));
		students.add(new Students("Anjali", 6, 70));
		students.add(new Students("Sneha", 7, 65));
		students.add(new Students("Amit", 8, 60));
		students.add(new Students("Neha", 9, 72));
		students.add(new Students("Karan", 10, 68));

		Predicate<Students> marks = (student) -> {
			return (student.getMarks() > 75) ? true : false;
		};

		Consumer<Students> congratulate = (student) -> {
			System.out.println("Congratulations " + student.getName());
		};

		for (Students student : students) {
			if (marks.test(student)) {
				congratulate.accept(student);
			}
		}
	}

}
