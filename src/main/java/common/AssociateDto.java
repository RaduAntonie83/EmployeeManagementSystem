package common;

import java.time.LocalDate;

public class AssociateDto extends EmployeeDto{
    private String bonus;

    public String getBonus() {
        return bonus;
    }

    public AssociateDto(Long id, String name, String gender, LocalDate dateOfBirth, String address, Integer salary, String religion, int workingHours, String email, String taxClass, String bonus) {
        super(id, name, gender, dateOfBirth, address, salary, religion, workingHours, email, taxClass);
        this.bonus = bonus;
    }
}
