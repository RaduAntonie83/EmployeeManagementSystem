package com.employee.employeemanagementsystem.servlets;

import com.employee.employeemanagementsystem.ejb.EmployeeBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_EMPLOYEES"}))


@WebServlet(name = "AddEmployee", value = "/AddEmployee")
public class AddEmployee extends HttpServlet {
    @Inject
    EmployeeBean employeeBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/addEmployee.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        int salary = Integer.parseInt(request.getParameter("salary"));
        String religion = request.getParameter("religion");
        String password = request.getParameter("password");
        int workingHours = Integer.parseInt(request.getParameter("workinghours"));
        String gender = request.getParameter("gender");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateofbirth"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String email = request.getParameter("email");
        employeeBean.createEmployee(name, gender, dateOfBirth, address, salary, religion, password, email, workingHours);
        response.sendRedirect(request.getContextPath() + "/Employees");
    }
}