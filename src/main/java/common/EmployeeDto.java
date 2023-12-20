package common;

import jakarta.persistence.Basic;

import java.util.Date;

public class EmployeeDto {

    public EmployeeDto(Long id, String name, String gender, Date dateOfBirth, String address, Integer salary, String religion, String password, int workingHours) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.salary = salary;
        this.religion = religion;
        this.password = password;
        this.workingHours=workingHours;
    }

    private Long id;

    public Long Getid() {
        return id;
    }

    private String name;

    public String getName() {
        return name;
    }

    private String gender;

    public String getGender() {
        return gender;
    }

    private Date dateOfBirth;

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    private String address;

    public String getAddress() {
        return address;
    }

    private Integer salary;

    public Integer getSalary() {
        return salary;
    }

    private String religion;

    public String getReligion() {
        return religion;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    private  int workingHours;
    public  int getWorkingHours(){return workingHours;}
}
