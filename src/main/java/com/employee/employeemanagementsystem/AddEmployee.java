package com.employee.employeemanagementsystem;

import com.employee.employeemanagementsystem.ejb.EmployeeBean;
import common.EmployeeDto;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        List<EmployeeDto> employees=employeeBean.findAllEmployees();
        Long id=(long)employees.size();
        String name = request.getParameter("name");
        String email=request.getParameter("email");
        String address = request.getParameter("address");
        Integer salary = Integer.parseInt(request.getParameter("salary"));
        //String employeeClass = request.getParameter("employeeClass");
        Integer hours = Integer.parseInt(request.getParameter("hours"));
        LocalDateTime birthdate = LocalDateTime.parse(request.getParameter("birthdate") + "T00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        String gender = request.getParameter("gender");

        employeeBean.createEmployee(id, name, email, address, salary, hours, birthdate, gender);
        response.sendRedirect(request.getContextPath()+ "/Employees");
    }

}