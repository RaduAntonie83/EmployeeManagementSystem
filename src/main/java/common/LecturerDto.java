package common;

import java.time.LocalDate;

public class LecturerDto extends EmployeeDto{
    public LecturerDto(Long id, String name, String gender, LocalDate dateOfBirth, String address, Integer salary, String religion, int workingHours, String email, String taxClass) {
        super(id, name, gender, dateOfBirth, address, salary, religion, workingHours, email, taxClass);
    }
}
