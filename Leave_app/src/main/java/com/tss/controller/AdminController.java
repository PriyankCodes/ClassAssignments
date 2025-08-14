package com.tss.controller;

import com.tss.model.LeaveRequest;
import com.tss.model.User;
import com.tss.service.LeaveService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
    private LeaveService leaveService = new LeaveService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) { response.sendRedirect("login.jsp"); return; }
        User user = (User) session.getAttribute("user");
        if (!"ADMIN".equalsIgnoreCase(user.getRole())) { response.sendRedirect("login.jsp"); return; }

        String start = request.getParameter("start_date");
        String end   = request.getParameter("end_date");
        String status= request.getParameter("status"); // "", ALL, PENDING, APPROVED, REJECTED

        List<LeaveRequest> all;
        if ((start != null && !start.isEmpty()) || (end != null && !end.isEmpty()) ||
            (status != null && !status.isEmpty())) {
            Date sd = (start != null && !start.isEmpty()) ? Date.valueOf(start) : null;
            Date ed = (end   != null && !end.isEmpty())   ? Date.valueOf(end)   : null;
            all = leaveService.getAllRequestsFiltered(sd, ed, status);
        } else {
            all = leaveService.getAllRequests();
        }

        request.setAttribute("allLeaves", all);
        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) { response.sendRedirect("login.jsp"); return; }
        User admin = (User) session.getAttribute("user");
        if (admin == null || !"ADMIN".equalsIgnoreCase(admin.getRole())) { response.sendRedirect("login.jsp"); return; }

        String action  = request.getParameter("action"); // approve / reject
        int id         = Integer.parseInt(request.getParameter("id"));
        String comment = request.getParameter("comment");
        if (comment == null) comment = "";
        String status   = null;

        if ("approve".equalsIgnoreCase(action)) status = "APPROVED";
        else if ("reject".equalsIgnoreCase(action)) status = "REJECTED";

        if (status != null) {
            leaveService.updateStatus(id, status, admin.getUserId(), comment);
        }
        response.sendRedirect("AdminController");
    }
}
