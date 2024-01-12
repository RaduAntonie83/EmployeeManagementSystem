package common;

import java.time.LocalDateTime;

public class EmployeeDto {

    public EmployeeDto(Long id, String name, String gender, LocalDateTime dateOfBirth, String address, Integer salary, String religion, String password, int workingHours,String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.salary = salary;
        this.religion = religion;
        this.password = password;
        this.workingHours=workingHours;
        this.email=email;
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

    private LocalDateTime dateOfBirth;

    public LocalDateTime getDateOfBirth() {
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

    private String email;
    public String getEmail(){return email;}
}
