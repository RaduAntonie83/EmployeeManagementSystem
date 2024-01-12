package com.employee.employeemanagementsystem.entities;

import jakarta.persistence.Entity;

@Entity
public class Associate extends Employee{
    Bonus bonus;
}
