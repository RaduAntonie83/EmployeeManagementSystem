package com.employee.employeemanagementsystem;

import com.employee.employeemanagementsystem.entities.Employee;
import com.employee.employeemanagementsystem.entities.Lecturer;

public interface PaymentMethod {
    void Payment(Employee employee);
}
