package common;

import java.time.LocalDateTime;

public class EmployeeDto {

    public EmployeeDto(Long id, String name, String email, String address, Integer salary, String employeeClass, Integer hours, LocalDateTime birthdate, String gender) {
        this.id=id;
        this.name = name;
        this.email=email;
        this.address = address;
        this.salary = salary;
        this.employeeClass = employeeClass;
        this.hours=hours;
        this.birthdate=birthdate;
        this.gender=gender;

    }

    Long id;

    public Long getId() {
        return id;
    }

    private String name;

    public String getName() {
        return name;
    }

    private String email;

    public String getEmail() { return email; }

    private String address;

    public String getAddress() {
        return address;
    }

    private Integer salary;

    public Integer getSalary() {
        return salary;
    }

    private String employeeClass;

    public String getemployeeClass(){
        return employeeClass;
    }

    private Integer hours;

    public Integer getHours() {
        return hours;
    }

    private LocalDateTime birthdate;

    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    private String gender;

    public String getGender() {
        return gender;
    }
}
