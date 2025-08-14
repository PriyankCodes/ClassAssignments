package com.example.service;

import java.util.List;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;

public class EmployeeService {
    private EmployeeDao dao = new EmployeeDao();

    public List<Employee> fetchEmployee() {
        return dao.getAllEmployees();
    }

}
