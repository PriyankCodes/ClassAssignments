package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
    private EmployeeService service = new EmployeeService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Employee> emp = service.fetchEmployee();

        request.setAttribute("employees", emp);

        RequestDispatcher rd = request.getRequestDispatcher("showEmployee.jsp");
        rd.forward(request, response);
    }
}
