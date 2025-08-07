package com.tss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tss.model.User;
import com.tss.service.UserService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
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
        
        Cookie usernameCookie = new Cookie("username", username);
        usernameCookie.setMaxAge(60 * 60); 
        response.addCookie(usernameCookie);


        User user = userService.validateUser(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);
            response.sendRedirect("QuestionController?page=1");
        } else {
            response.getWriter().println("Invalid credentials. Please try again.");
            //request.getRequestDispatcher("Login.html").forward(request, response);

        }
    }
}
