package com.employee.employeemanagementsystem.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Bonus{
    @Id
    @GeneratedValue
    private Long id;
    public Bonus() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public enum BonusType {
        PERFORMANCE,
        COOPERATION,
        EXTRA,
        NONE;
    }

    private BonusType bonusType;

    public BonusType getBonusType() {
        return bonusType;
    }

    public void setBonusType(BonusType bonusType) {
        this.bonusType = bonusType;
    }

    public int calculateBonus(){
        switch (bonusType){
            case PERFORMANCE:
                return 1500;
            case COOPERATION:
                return 1000;
            case EXTRA:
                return 500;
            default:
                return 0;
        }
    }
}
