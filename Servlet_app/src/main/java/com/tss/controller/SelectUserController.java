package com.tss.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectUserController")
public class SelectUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userType = request.getParameter("userTypeText"); // matches HTML name
		String name = request.getParameter("name");

		request.setAttribute("name", name);
		RequestDispatcher dispatcher = null;

		if ("Customer".equalsIgnoreCase(userType)) {
		    dispatcher = request.getRequestDispatcher("CustomerController");
		} else if ("Admin".equalsIgnoreCase(userType)) {
		    dispatcher = request.getRequestDispatcher("AdminController");
		}

		if (dispatcher != null) {
		    dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
