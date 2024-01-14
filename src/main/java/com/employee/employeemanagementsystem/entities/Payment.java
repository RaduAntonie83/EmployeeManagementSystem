package com.employee.employeemanagementsystem.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Payment {
    private LocalDate paymentDate;
    private Long id;
    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private Integer paidAmount;

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Long getId() {
        return id;
    }

    @ManyToOne
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
