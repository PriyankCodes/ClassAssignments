package com.tss.service;

import java.sql.Connection;
import java.util.List;

import com.tss.dao.UserDao;
import com.tss.db.UserDatabase;
import com.tss.model.User;

public class UserService {

	private UserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}

	public boolean addNewUser(User user) {
		try {
			Connection connection = UserDatabase.connect();
			return userDao.addNewUser(connection, user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<User> getAllUsers() {
		try {
			Connection connection = UserDatabase.connect();
			return userDao.getAllUsers(connection);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean validateLogin(String username, String password, String role) {
		try {
			Connection connection = UserDatabase.connect();
			return userDao.validateUser(connection, username, password, role);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
