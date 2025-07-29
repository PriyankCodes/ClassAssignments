package com.tss.service;

import java.util.List;

import com.tss.dao.StudentDao;
import com.tss.model.Student;

public class StudentService {
	private StudentDao studentDao;

	public StudentService() {
		super();
		this.studentDao = new StudentDao();
	}

	public List<Student> readAllStudent() {
		return studentDao.readAllStudents();
	}

	public void addNewStudent(Student student) {

		if (student.getPercentage() < 0 || student.getPercentage() > 100) {
			System.out.println("Invalid Percentage.");
			return;
		}

		if (student.getAge() < 18) {
			System.out.println("Invalid Student Age");
			return;
		}
		studentDao.addNewStudent(student);
	}

	public List<Student> readStudentById(Student student) {
		return studentDao.readStudentById(student);

	}

	public void updatePercentageById(Student student) {
		if (student.getPercentage() < 0 || student.getPercentage() > 100) {
			System.out.println("Invalid Percentage.");
			return;
		}
		studentDao.updatePercentageById(student);

	}

	public void deleteStudentById(Student student) {
		studentDao.deleteStudentById(student);

	}

}
