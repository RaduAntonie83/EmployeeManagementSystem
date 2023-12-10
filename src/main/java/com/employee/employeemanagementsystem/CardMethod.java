package com.employee.employeemanagementsystem;

import com.employee.employeemanagementsystem.entities.Employee;

public class CardMethod implements PaymentMethod{
    public void pay(Employee Mihai){
        System.out.println("Am platit angajatul "+ Mihai+ Mihai.getName()+" I-am trimis banii pe cardu");
    }
}
