package com.tss.service;

import com.tss.dao.UserDao;
import com.tss.model.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public User authenticate(String username, String password) {
        return userDao.validateUser(username, password);
    }
    
    public boolean registerUser(String name, String username, String password, String role) {
        return userDao.saveUser(name, username, password, role);
    }

}
