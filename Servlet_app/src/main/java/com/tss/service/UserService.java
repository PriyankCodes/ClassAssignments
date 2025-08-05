package com.tss.service;

import java.sql.Connection;
import java.util.List;

import com.tss.dao.UserDao;
import com.tss.model.User;

public class UserService {

	private UserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}

	public boolean addNewUser(Connection connection, User user) {
		return userDao.addNewUser(connection, user);
	}

	public List<User> getAllUsers(Connection connection) {
		return userDao.getAllUsers(connection);
	}
}
