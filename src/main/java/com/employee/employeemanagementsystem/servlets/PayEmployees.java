package com.employee.employeemanagementsystem.servlets;

import com.employee.employeemanagementsystem.ejb.EmployeeBean;
import com.employee.employeemanagementsystem.ejb.PaymentBean;
import com.employee.employeemanagementsystem.entities.*;
import com.employee.employeemanagementsystem.interfaces.CardMethod;
import common.EmployeeDto;
import jakarta.ejb.EJBException;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PayEmployees", value = "/PayEmployees")
public class PayEmployees extends HttpServlet {
    @PersistenceContext
    EntityManager entityManager;
    @Inject
    PaymentBean paymentBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        TypedQuery<Employee> typedQuery =
                entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> employees = typedQuery.getResultList();
        List<Payment> payments = paymentBean.generatePaymentList(employees);
        paymentBean.payAllEmployees(payments);
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"exported_data.csv\"");
        List<String> dataList = paymentBean.createPaymentTable(payments);
        try (PrintWriter writer = response.getWriter()) {
            for (String data : dataList) {
                writer.println(data);
            }
        }
        response.sendRedirect(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }
}