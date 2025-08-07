package com.tss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.model.User;
import com.tss.service.UserService;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		User user = new User(username, password, email);

		boolean isRegistered = userService.registerUser(user);

		if (isRegistered) {
			response.sendRedirect("Login.html");
		} else {
			response.getWriter().println("Registration failed. Try again.");
		}
	}
}
