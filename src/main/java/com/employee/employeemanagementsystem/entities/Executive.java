package com.employee.employeemanagementsystem.entities;

import jakarta.persistence.Entity;

@Entity
public class Executive extends Employee{
    private int numberOfShares;
}
