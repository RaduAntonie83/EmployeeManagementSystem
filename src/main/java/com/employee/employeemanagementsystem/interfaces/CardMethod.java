package com.employee.employeemanagementsystem.interfaces;
import com.employee.employeemanagementsystem.entities.Employee;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class CardMethod implements PaymentMethod{
    @Id
    @GeneratedValue
    private Long id;

    private String bank;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private String account;

    @Override
    public void payEmployee(int amount) {
        // actual logic to pay an employee tbd
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @OneToOne
    @JoinColumn(name = "employee_id")  // Assuming your foreign key column is named "employee_id"
    private Employee employee;

    // Getters and setters...

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
