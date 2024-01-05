package com.employee.employeemanagementsystem.entities;

import com.employee.employeemanagementsystem.Bonus;
import jakarta.persistence.Basic;

public class Executive extends Employee{
    private int numberOfShares;
    private Bonus bonus;
}
