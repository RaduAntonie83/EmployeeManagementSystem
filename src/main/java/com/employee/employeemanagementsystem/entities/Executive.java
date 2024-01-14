package com.employee.employeemanagementsystem.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Executive extends Employee{
    private int numberOfShares;
    @OneToOne(mappedBy = "employee", cascade = CascadeType.PERSIST)
    private Bonus Bonus;

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public Bonus getBonus() {
        return Bonus;
    }

    public void setBonus(Bonus bonus) {
        Bonus = bonus;
    }
}
