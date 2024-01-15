package com.employee.employeemanagementsystem.servlets;

import com.employee.employeemanagementsystem.ejb.EmployeeBean;
import common.EmployeeDto;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_EMPLOYEES"}))
@WebServlet(name = "EditEmployee", value = "/EditEmployee")
public class EditEmployee extends HttpServlet {
    @Inject
    EmployeeBean employeeBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        Long employeeId = Long.parseLong(request.getParameter("id"));
        EmployeeDto employee = employeeBean.findById(employeeId);
        request.setAttribute("employee", employee);
        request.setAttribute("employeeGroups", new String[] {"READ_EMPLOYEES", "WRITE_EMPLOYEES"});
        request.getRequestDispatcher("/WEB-INF/pages/editEmployee.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("employee_id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        int salary = Integer.parseInt(request.getParameter("salary"));
        String religion = request.getParameter("religion");
        String password = request.getParameter("password");
        int workingHours = Integer.parseInt(request.getParameter("workinghours"));
        String gender = request.getParameter("gender");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateofbirth"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String email = request.getParameter("email");
        int numberOfShares = 0;
        if(!Objects.equals(request.getParameter("numberOfShares"), ""))
            numberOfShares = Integer.parseInt(request.getParameter("numberOfShares"));
        String taxClass = request.getParameter("taxClass");
        employeeBean.updateEmployee(id, name, gender, dateOfBirth, address, salary, religion, password, email, workingHours, numberOfShares, taxClass);
        response.sendRedirect(request.getContextPath() + "/Employees");
    }
}