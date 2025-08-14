package com.tss.controller;

import com.tss.model.User;
import com.tss.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User u = userService.authenticate(username, password);
        if (u != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", u); 
            if ("ADMIN".equalsIgnoreCase(u.getRole())) {
                response.sendRedirect("AdminController");
            } else {
                response.sendRedirect("EmployeeController");
            }
        } else {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
