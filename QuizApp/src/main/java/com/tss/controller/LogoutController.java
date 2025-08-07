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

        // Invalidate session
        HttpSession session = request.getSession(false); // false = don't create new session
        if (session != null) {
            session.invalidate();
        }

        // Clear the "username" cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("username".equals(c.getName())) {
                    c.setMaxAge(0); // delete cookie
                    c.setPath("/"); // must match the path it was set with
                    response.addCookie(c);
                }
            }
        }

        // Redirect to login page
        response.sendRedirect("Login.html");
    }
}
