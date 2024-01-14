package com.employee.employeemanagementsystem.servlets;

import com.employee.employeemanagementsystem.ejb.EmployeeBean;
import common.EmployeeDto;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@DeclareRoles({"READ_EMPLOYEES","WRITE_EMPLOYEES"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"READ_EMPLOYEES"}),
        httpMethodConstraints = {@HttpMethodConstraint(value = "POST",rolesAllowed = {"WRITE_EMPLOYEES"})})
@WebServlet(name = "Employees", value = "/Employees")
public class Employees extends HttpServlet {
    @Inject
    EmployeeBean employeeBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
            List<EmployeeDto> employees = employeeBean.findAllEmployees();
            request.setAttribute("employeeList", employees);

            request.setAttribute("numberOfEmployees", employees.size());
            request.setAttribute("activePage", "Employees");

            request.getRequestDispatcher("/WEB-INF/pages/employees.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String[] employeeIdsAsString = request.getParameterValues("employee_ids");
        if (employeeIdsAsString != null) {
            List<Long> employeeIds= new ArrayList<>();
            for (String employeeIdAsString : employeeIdsAsString) {
                employeeIds.add(Long.parseLong(employeeIdAsString));
            }
               employeeBean.deleteEmployeesById(employeeIds);
    }
        response.sendRedirect(request.getContextPath() + "/Employees");
    }
}