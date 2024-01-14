package common;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class EmployeeDto {

    public EmployeeDto(Long id, String name, String gender, LocalDate dateOfBirth, String address, Integer salary, String religion, int workingHours, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.salary = salary;
        this.religion = religion;
        this.workingHours=workingHours;
        this.email=email;
    }

    protected Long id;

    public Long getId() {
        return id;
    }

    protected String name;

    public String getName() {
        return name;
    }

    protected String gender;

    public String getGender() {
        return gender;
    }

    protected LocalDate dateOfBirth;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    protected String address;

    public String getAddress() {
        return address;
    }

    protected Integer salary;

    public Integer getSalary() {
        return salary;
    }

    protected String religion;

    public String getReligion() {
        return religion;
    }

    protected int workingHours;
    public  int getWorkingHours(){return workingHours;}

    protected String email;
    public String getEmail(){return email;}
}
