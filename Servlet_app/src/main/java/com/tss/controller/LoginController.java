package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");

        String[] languages = request.getParameterValues("language");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (!password.equals(confirmPassword)) {
            writer.println("<h3 style='color:red;'>Error: Password and Confirm Password do not match!</h3>");
            writer.println("<a href='Login.html'>Go Back to Form</a>");
            writer.close();
            return; 
        }

        writer.println("<h2>Form Data Received</h2>");
        writer.println("Name : <b>" + name + "</b><br>");
        writer.println("Address : <b>" + address + "</b><br>");
        writer.println("Gender : <b>" + gender + "</b><br>");
        writer.println("City : <b>" + city + "</b><br>");

        writer.print("Languages : <b>");
        if (languages != null) {
            for (String lang : languages) {
                writer.print(lang + " ");
            }
        } else {
            writer.print("None");
        }
        writer.println("</b><br>");

        writer.println("Username : <b>" + username + "</b><br>");

        writer.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
