package com.employee.employeemanagementsystem.interfaces;

import com.employee.employeemanagementsystem.entities.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
public class HoldMethod implements PaymentMethod{
    @Id
    @GeneratedValue
    private Long id;

    @Override
    public void payEmployee(int amount) {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
