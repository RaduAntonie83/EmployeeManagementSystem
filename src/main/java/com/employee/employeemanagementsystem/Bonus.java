package com.employee.employeemanagementsystem;

public class Bonus {


    public enum BonusType {
        PERFORMANCE,
        CHRISTMAS,

        NUMBER_OF_SHARES,
        VACATION,
        EXTRA;

    }
    private BonusType bonusType;
    private int amount;

    public Bonus(BonusType bonusType, int amount) {
        this.bonusType = bonusType;
        this.amount = amount;
    }

    public BonusType getBonusType() {
        return bonusType;
    }

    public int getAmount() {
        return amount;
    }

    public void setBonusType(BonusType bonusType) {
        this.bonusType = bonusType;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void calculateBonus(){
        switch (bonusType){
            case PERFORMANCE:
                amount = 1000;
                break;
            case CHRISTMAS:
                amount = 500;
                break;
            case NUMBER_OF_SHARES:
                amount = 1000;
                break;
            case VACATION:
                amount = 1000;
                break;
            case EXTRA:
                amount = 1000;
                break;
        }
    }

    public void printBonus(){
        System.out.println("Bonus type: " + bonusType + " amount: " + amount);
    }


}
