package com.employee.employeemanagementsystem.ejb;

import com.employee.employeemanagementsystem.entities.*;
import com.employee.employeemanagementsystem.interfaces.CardMethod;
import jakarta.ejb.EJBException;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class PaymentBean {
    private static final Logger LOG = Logger.getLogger(PaymentBean.class.getName());
    public List<String> createPaymentTable(List<Payment> payments){
        List<String> table = new ArrayList<>();
        table.add("Payment Date," +
                "Employee Name," +
                "Date Of Birth," +
                "Salary Class," +
                "Salary," +
                "Bonus," +
                "Number of Shares," +
                "Tax Class," +
                "Working Time," +
                "Taxed Salary");
        for(Payment payment: payments){
            String column = payment.getPaymentDate().toString()
                    + "," + payment.getEmployee().getName()
                    + "," + payment.getEmployee().getDateOfBirth()
                    + "," + payment.getEmployee().getClass().getSimpleName()
                    + "," + payment.getPaidAmount();
                    if(payment.getEmployee() instanceof Associate) {
                        int bonusType = (((Associate) payment.getEmployee()).getBonus() != null) ? ((Associate) payment.getEmployee()).getBonus().calculateBonus() : 0;
                        column = column + "," + bonusType
                                + ",N/A";
                    }
                    else if(payment.getEmployee() instanceof Executive){
                        int bonusType = (((Executive) payment.getEmployee()).getBonus() != null) ? ((Executive) payment.getEmployee()).getBonus().calculateBonus() : 0;
                        column = column + ", " + bonusType
                                + "," + ((Executive) payment.getEmployee()).getNumberOfShares();
                    }
                    else
                        column = column + ",N/A,N/A";
                    column = column + "," + payment.getEmployee().getTaxClass()
                            + "," + payment.getEmployee().getWorkingHours()
                            + "," + calculateTaxedPayment(payment);
            table.add(column);
        }
        return table;
    }
    public int calculateTaxedPayment(Payment payment){
        int paidAmountTaxed = payment.getPaidAmount();
        if(payment.getEmployee() instanceof Lecturer)
            paidAmountTaxed = (int) (paidAmountTaxed * (1 - 0.2 - 0.1));
        else if(payment.getEmployee() instanceof Associate)
            paidAmountTaxed = (int) (paidAmountTaxed * (1 - 0.25 - 0.1));
        else if(payment.getEmployee() instanceof Executive)
            paidAmountTaxed = (int) (paidAmountTaxed * (1 - 0.3 - 0.1));
        return paidAmountTaxed;
    }
    public int calculateSalaryBonuses(Employee employee){
        int paidAmount = employee.getSalary();
        if(employee.getWorkingHours() < 40){
            paidAmount *= 0.5;
        }
        switch (LocalDate.now().getMonth().toString()){
            case "NOVEMBER":
                paidAmount+=250;
                break;
            case "JUNE":
                paidAmount+=500;
                break;
            case "AUGUST":
                if(employee instanceof Executive) {
                    Executive executive = (Executive) employee;
                    if(executive.getBonus() != null)
                        paidAmount += executive.getBonus().calculateBonus();
                    paidAmount += executive.getNumberOfShares() * 10;
                }
                else if(employee instanceof Associate){
                    Associate associate = (Associate) employee;
                    if(associate.getBonus() != null)
                        paidAmount += associate.getBonus().calculateBonus();
                }
                break;
            default:
                break;
        }
        return paidAmount;
    }
    public List<Payment> generatePaymentList(List<Employee> employees){
        List<Payment> payments = new ArrayList<>();
        for(Employee e: employees){
            int paidAmount = calculateSalaryBonuses(e);
            Payment payment = new Payment();
            payment.setPaymentDate(LocalDate.now());
            payment.setEmployee(e);
            payment.setPaidAmount(paidAmount);
            payments.add(payment);
        }
        return payments;
    }

    public void payAllEmployees(List<Payment> payments){
        for (Payment payment : payments) {
            if(payment.getEmployee().getPaymentMethod() != null)
                payment.getEmployee().getPaymentMethod().payEmployee(calculateTaxedPayment(payment));
        }
    }
}
