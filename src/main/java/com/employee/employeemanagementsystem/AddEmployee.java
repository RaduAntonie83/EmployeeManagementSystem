package com.employee.employeemanagementsystem;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddEmployee", value = "/AddEmployee")
public class AddEmployee extends HttpServlet {
    //sal
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String employeeClass = request.getParameter("employeeClass");
        int hours = Integer.parseInt(request.getParameter("hours"));
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");
    }

}