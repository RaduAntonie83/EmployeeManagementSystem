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
    @OneToMany
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
