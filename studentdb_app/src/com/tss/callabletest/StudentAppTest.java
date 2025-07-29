package com.tss.callabletest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import com.tss.callablemodel.Student;

public class StudentAppTest {
	public static void main(String[] args) {
		int studentId = 1;

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/callabledemo", "root",
				"priyank@2k25")) {

			CallableStatement cs = conn.prepareCall("{call getStudentMarks(?, ?, ?)}");

			cs.setInt(1, studentId); // IN parameter
			cs.registerOutParameter(2, Types.VARCHAR); // OUT name
			cs.registerOutParameter(3, Types.INTEGER); // OUT marks

			cs.execute();

			String name = cs.getString(2);
			int marks = cs.getInt(3);

			Student s = new Student(studentId, name, marks);
			System.out.println(s);

			cs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
