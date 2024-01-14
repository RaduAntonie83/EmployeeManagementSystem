package com.employee.employeemanagementsystem.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Associate extends Employee{

    @OneToOne(mappedBy = "employee", cascade = CascadeType.PERSIST)
    private Bonus bonus;

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }
}
