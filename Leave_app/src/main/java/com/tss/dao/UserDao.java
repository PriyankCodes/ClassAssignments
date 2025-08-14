package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tss.model.User;
import com.tss.util.DBConnection;

public class UserDao {

	public User validateUser(String username, String password) {
		String sql = "SELECT user_id, name, username, role FROM users WHERE username=? AND password=?";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, username);
	        ps.setString(2, password);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                User u = new User();
	                u.setUserId(rs.getInt("user_id"));
	                u.setName(rs.getString("name"));
	                u.setUsername(rs.getString("username"));
	                u.setRole(rs.getString("role"));
	                return u;
	            }
	        }
	    } catch (Exception e) { e.printStackTrace(); }
	    return null;
	}
	
	public boolean saveUser(String name, String username, String password, String role) {
	    String sql = "INSERT INTO users (name, username, password, role) VALUES (?, ?, ?, ?)";
	    try (Connection conn = DBConnection.getConnection(); 
	         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        ps.setString(1, name);
	        ps.setString(2, username);
	        ps.setString(3, password);
	        ps.setString(4, role);
	        int inserted = ps.executeUpdate();
	        if (inserted > 0) {
	            try (ResultSet keys = ps.getGeneratedKeys()) {
	                if (keys.next()) {
	                    int newUserId = keys.getInt(1);
	                    
	                    String balSql = "INSERT INTO leave_balance (user_id, total_leaves, leaves_taken) VALUES (?, 20, 0)";
	                    try (PreparedStatement ps2 = conn.prepareStatement(balSql)) {
	                        ps2.setInt(1, newUserId);
	                        ps2.executeUpdate();
	                    }
	                }
	            }
	            return true;
	        }
	    } catch (Exception e) { e.printStackTrace(); }
	    return false;
	}
}
