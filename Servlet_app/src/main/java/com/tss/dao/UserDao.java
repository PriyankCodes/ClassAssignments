package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tss.model.User;

public class UserDao {

	// Insert user with username, password, and role
	public boolean addNewUser(Connection connection, User user) {
		String sql = "INSERT INTO user (username, password, role) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getRole());
			return stmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<User> getAllUsers(Connection connection) {
		List<User> users = new ArrayList<>();
		String sql = "SELECT username, password, role FROM user";
		try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				users.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("role")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public boolean validateUser(Connection connection, String username, String password, String role) {
		String sql = "SELECT username, password, role FROM user WHERE username = ? AND password = ? AND role = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, role);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return true;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
