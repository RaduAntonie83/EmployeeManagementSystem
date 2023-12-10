package com.employee.employeemanagementsystem;

import com.employee.employeemanagementsystem.entities.Employee;

public class DirectMethod implements PaymentMethod{
    public void pay(Employee Mihai){
        System.out.println("Am platit angajatul "+ Mihai+ Mihai.getName()+" I-am trimis banii in plic la adresa "+Mihai.getAddress());
    }
}
