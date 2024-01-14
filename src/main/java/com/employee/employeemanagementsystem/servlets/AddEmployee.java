package com.employee.employeemanagementsystem.servlets;

import com.employee.employeemanagementsystem.ejb.EmployeeBean;
import com.employee.employeemanagementsystem.entities.Bonus;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        String employeeType = request.getParameter("employeeClass");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        Integer salary = Integer.parseInt(request.getParameter("salary"));
        String religion = request.getParameter("religion");
        String password = request.getParameter("password");
        Integer workingHours = Integer.parseInt(request.getParameter("workinghours"));
        String gender = request.getParameter("gender");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateofbirth"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String email = request.getParameter("email");
        String bonus = request.getParameter("bonus");
        Integer numberOfShares = Integer.parseInt(request.getParameter("numberOfShares"));
        String taxClass = request.getParameter("taxClass");
        String bank = request.getParameter("bank");
        String account = request.getParameter("account");
        employeeBean.createEmployee(employeeType, name, gender, dateOfBirth, address, salary, religion, password, email, workingHours, bonus, numberOfShares, taxClass, bank, account);
        response.sendRedirect(request.getContextPath() + "/Employees");
    }
}