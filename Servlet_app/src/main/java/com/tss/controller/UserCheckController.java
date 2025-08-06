package com.tss.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.model.User;
import com.tss.service.UserService;

@WebServlet("/UserCheckController")
public class UserCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String theme = request.getParameter("theme");

		boolean user = userService.validateLogin(username, password, role);

		if (user) {

			Cookie usernameCookie = new Cookie("username", username);
			usernameCookie.setMaxAge(60 * 60);
			response.addCookie(usernameCookie);

			Cookie themeCookie = new Cookie("theme", theme);
			themeCookie.setMaxAge(60 * 60);
			response.addCookie(themeCookie);

			request.setAttribute("theme", theme);

			RequestDispatcher requestDispatcher = null;
			if ("Admin".equalsIgnoreCase(role)) {
				requestDispatcher = request.getRequestDispatcher("AdminController");
			} else if ("Customer".equalsIgnoreCase(role)) {
				requestDispatcher = request.getRequestDispatcher("CustomerController");
			}
			requestDispatcher.forward(request, response);
		} else {
			response.getWriter().println("<h3>Invalid login! Please try again.</h3>");
		}
	}
}
