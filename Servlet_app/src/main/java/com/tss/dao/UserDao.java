package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.model.User;

public class UserDao {

	public boolean addNewUser(Connection connection, User user) {
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO user VALUES (?,?)");
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());

			int updates = statement.executeUpdate();
			if (updates > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<User> getAllUsers(Connection connection) {
		List<User> users = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT username, password FROM user");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				users.add(new User(username, password));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
