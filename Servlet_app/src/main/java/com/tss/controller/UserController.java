package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.db.UserDatabase;
import com.tss.model.User;
import com.tss.service.UserService;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;
	private UserService userService;

	public UserController() {
		super();
		connection = UserDatabase.connect();
		userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		if (action != null && action.equalsIgnoreCase("viewAll")) {
			displayAllUsers(writer);
		} else {
			addNewUser(request, writer);
		}

		writer.close();
	}

	private void displayAllUsers(PrintWriter writer) {
		List<User> users = userService.getAllUsers(connection);

		writer.println("<html><head><title>All Users</title>");
		writer.println("<style>");
		writer.println("body { background-color: #f0f2f5; padding: 20px; }");
		writer.println(
				"table { border-collapse: collapse; width: 60%; margin: auto; background: #fff; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }");
		writer.println("th, td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }");
		writer.println("th { background-color: #4CAF50; color: white; }");
		writer.println("tr:hover { background-color: #f1f1f1; }");
		writer.println("h2 { text-align: center; color: #333; margin-bottom: 20px; }");
		writer.println("</style></head><body>");

		writer.println("<h2>All Users</h2>");
		writer.println("<table>");
		writer.println("<tr><th>Username</th><th>Password</th></tr>");

		for (User user : users) {
			writer.println("<tr>");
			writer.println("<td>" + user.getUsername() + "</td>");
			writer.println("<td>" + user.getPassword() + "</td>");
			writer.println("</tr>");
		}
		writer.println("</table>");

		writer.println("</body></html>");
	}

	private void addNewUser(HttpServletRequest request, PrintWriter writer) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
			User user = new User(username, password);

			if (userService.addNewUser(connection, user)) {
				writer.print("<p style='color:green;text-align:center;'>User Added Successfully.</p>");
			} else {
				writer.print("<p style='color:red;text-align:center;'>Failed to Add User.</p>");
			}
		} else {
			writer.print("<p style='color:orange;text-align:center;'>Please enter both username and password.</p>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
