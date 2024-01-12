package com.employee.employeemanagementsystem;

import com.employee.employeemanagementsystem.ejb.EmployeeBean;
import common.EmployeeDto;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Inject
    EmployeeBean employeeBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //   List<EmployeeDto> employees = employeeBean.findAllEmployees();
     //   request.setAttribute("employeeList", employees);

   //     String email = request.getParameter("email");
     //   String password = request.getParameter("password");
   //     boolean isValidLogin = employeeBean.isValidLogin(email, password);

//        if (isValidLogin) {
//
//            response.sendRedirect(request.getContextPath() + "/Employees.jsp");
//        } else {
//            request.setAttribute("message", "Email or password incorrect");
//        }

        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", "Email or password incorrect");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");

        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);


    }

}