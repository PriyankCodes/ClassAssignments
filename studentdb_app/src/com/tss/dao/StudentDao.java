package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tss.database.DBConnection;
import com.tss.model.Student;

public class StudentDao {

	private Connection connection = null;
	private Statement statement;
	private PreparedStatement preparedStatement = null;

	public StudentDao() {
		super();
		this.connection = DBConnection.connect();
	}

	public List<Student> readAllStudents() {

		List<Student> students = new ArrayList<>();
		try {
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM students");

			while (result.next()) {
				Student student = new Student();
				student.setStudentId(result.getInt("student_id"));
				student.setName(result.getString("name"));
				student.setRollno(result.getInt("rollno"));
				student.setPercentage(result.getDouble("percentage"));
				student.setAge(result.getInt("age"));
				students.add(student);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return students;

	}

	public void addNewStudent(Student student) {

		try {
			preparedStatement = connection.prepareStatement("INSERT INTO students VALUES(?,?,?,?,?)");
			preparedStatement.setInt(1, student.getStudentId());
			preparedStatement.setInt(2, student.getRollno());
			preparedStatement.setString(3, student.getName());
			preparedStatement.setInt(4, student.getAge());
			preparedStatement.setDouble(5, student.getPercentage());

			int updates = preparedStatement.executeUpdate();

			if (updates > 0) {
				System.out.println("Record Inserted Successfully.");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public List<Student> readStudentById(Student student) {

		List<Student> students = new ArrayList<>();
		try {
			statement = connection.createStatement();
			ResultSet result = statement
					.executeQuery("SELECT * FROM students WHERE student_id=" + student.getStudentId());

			while (result.next()) {
				student.setStudentId(result.getInt("student_id"));
				student.setName(result.getString("name"));
				student.setRollno(result.getInt("rollno"));
				student.setPercentage(result.getDouble("percentage"));
				student.setAge(result.getInt("age"));
				students.add(student);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return students;

	}

	public void updatePercentageById(Student student) {
		try {
			preparedStatement = connection
					.prepareStatement("UPDATE students SET percentage = ? WHERE student_id=" + student.getStudentId());

			preparedStatement.setDouble(1, student.getPercentage());

			int updates = preparedStatement.executeUpdate();

			if (updates > 0) {
				System.out.println("Record Updated Successfully.");
			} else {
				System.out.println("No such student to update.");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void deleteStudentById(Student student) {
		// TODO Auto-generated method stub

		try {
			preparedStatement = connection
					.prepareStatement("DELETE FROM students WHERE student_id=" + student.getStudentId());

			int updates = preparedStatement.executeUpdate();

			if (updates > 0) {
				System.out.println("Record Deleted Successfully.");
			} else {
				System.out.println("No such student to delete.");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
