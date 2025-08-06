package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SecondController")
public class SecondController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SecondController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		String lastName = request.getParameter("lastName");

		//Cookie cookies[] = request.getCookies();

	    HttpSession session = request.getSession(false); 
        String firstname = (String) session.getAttribute("firstName");

		System.out.println(firstname);
//		writer.print("Firstname : " + cookies[0].getValue());
		writer.print("Firstname : " + firstname);

		writer.print("<br/>");
		writer.print("Lastname : " + lastName);
		session.invalidate();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
