package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Employee;
import com.example.util.DBConnection;

public class EmployeeDao {
	public List<Employee> getAllEmployees() {
	    List<Employee> empList = new ArrayList<>();
	    String sql = "SELECT * FROM employee";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        
	        while (rs.next()) {
	            Employee emp = new Employee(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getDouble("salary")
	            );
	            empList.add(emp);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return empList;
	}

}
