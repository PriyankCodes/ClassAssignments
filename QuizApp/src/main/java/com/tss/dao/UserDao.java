package com.tss.dao;

import com.tss.model.User;
import com.tss.util.DBConnection;

import java.sql.*;

public class UserDao {

	private Connection conn;

	public UserDao() {
		conn = DBConnection.getConnection();
	}

	public boolean registerUser(User user) {
		String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword()); 
			ps.setString(3, user.getEmail());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public User validateUser(String username, String password) {
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			ps.setString(2, password); 

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
