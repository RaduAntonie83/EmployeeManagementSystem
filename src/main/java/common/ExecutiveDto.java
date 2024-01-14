package common;

import java.time.LocalDate;

public class ExecutiveDto extends EmployeeDto{
    private String bonus;

    public String getBonus() {
        return bonus;
    }

    public Integer getNumberOfShares() {
        return numberOfShares;
    }

    private Integer numberOfShares;
    public ExecutiveDto(Long id, String name, String gender, LocalDate dateOfBirth, String address, Integer salary, String religion, int workingHours, String email, String bonus, Integer numberOfShares) {
        super(id, name, gender, dateOfBirth, address, salary, religion, workingHours, email);
        this.bonus = bonus;
        this.numberOfShares = numberOfShares;
    }
}
