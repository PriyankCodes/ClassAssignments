package com.tss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Invalidate session (removes all session data)
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Clear all cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(0);      
                c.setPath("/");       // Important: path must match to successfully delete
                response.addCookie(c); // Add to response to inform browser
            }
        }

        // Redirect to login page
        response.sendRedirect("Login.html");
    }
}
