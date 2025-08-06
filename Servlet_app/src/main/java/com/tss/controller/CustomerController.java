package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String theme = (String) request.getAttribute("theme");

		String username = "User";
		if (theme == null)
			theme = "black";

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if ("username".equals(c.getName())) {
					username = c.getValue();
				}
				if ("theme".equals(c.getName()) && (theme == null || theme.equals("black"))) {
					theme = c.getValue();
				}
			}
		}

		String textColor = "black";
		if ("Green".equalsIgnoreCase(theme))
			textColor = "green";
		else if ("Blue".equalsIgnoreCase(theme))
			textColor = "blue";

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<meta charset='UTF-8'><title>Customer Page</title>");
		out.println(
				"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("</head><body class='p-5'>");
		out.println("<div class='container'>");
		out.println("<h3 style='color:" + textColor + ";'>Welcome Customer " + username + "!</h3>");
		out.println("</div></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
