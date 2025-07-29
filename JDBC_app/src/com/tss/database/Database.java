package com.tss.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tss.model.Student;

public class Database {

	private Connection connection = null;
	private Statement statement;

	public Database() {
		try {

			// Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tss_Students_db", "root",
					"priyank@2k25");

			System.out.println("Connected to Database.");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void readStudents() {

		try {
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM students");
			System.out.println();
			while (result.next()) {
				System.out.println(
						result.getInt("student_id") + "\t" + result.getInt("rollno") + "\t" + result.getString("name")
								+ "\t" + result.getInt("age") + "\t" + result.getDouble("percentage"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addStudent(Student student) {
		try {
			statement = connection.createStatement();
			
			//String sql2 = "DELETE FROM STUDENTS WHERE student_id=16";
			
			String sql = "INSERT INTO students VALUES(" + student.getStudentId() + ", " + student.getRollno() + ", '"
					+ student.getName() + "', " + student.getAge() + ", " + student.getPercentage() + ")";

			int updates = statement.executeUpdate(sql);

			if (updates > 0) {
				System.out.println("Student record Inserted successfully.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
