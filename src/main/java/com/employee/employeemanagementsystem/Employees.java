package com.employee.employeemanagementsystem;

import com.employee.employeemanagementsystem.ejb.EmployeeBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Employees", value = "/Employees")
public class Employees extends HttpServlet {
    @Inject
    EmployeeBean employeeBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        employeeBean.findAllEmployees();
        request.setAttribute("numberOfEmployees", 2);
        request.setAttribute("activePage", "Employees");
        request.getRequestDispatcher("/WEB-INF/pages/employees.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }
}