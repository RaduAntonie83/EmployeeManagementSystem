package com.employee.employeemanagementsystem.ejb;

import com.employee.employeemanagementsystem.entities.Employee;
import com.employee.employeemanagementsystem.entities.Lecturer;
import common.EmployeeDto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;

@Stateless
public class EmployeeBean {
    private static final Logger LOG = Logger.getLogger(EmployeeBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;

    public List<EmployeeDto> copyEmployeesToDto(List<Lecturer> employees) {
        List<EmployeeDto> list = new ArrayList<>();
        for (Employee i : employees) {
            list.add(new EmployeeDto(i.getId(),i.getName(),i.getEmail(), i.getAddress(), i.getSalary(), i.getEmployeeClass(), i.getHours(), i.getDateOfBirth(), i.getGender()));
        }
        return list;
    }

    public List<EmployeeDto> findAllEmployees() {
        LOG.info("findAllEmployees");
        try {
            Query query = entityManager.createNativeQuery("SELECT id, name, address, salary, workinghours, dateOfBirth, gender FROM Employee");
            List<Object[]> results = query.getResultList();

            List<Lecturer> employees = new ArrayList<>();
            for (Object[] result : results) {
                Lecturer lecturer = new Lecturer();
                lecturer.setId((Long) result[0]);
                lecturer.setName((String) result[1]);
                lecturer.setAddress((String) result[2]);
                lecturer.setSalary((Integer) result[3]);
                lecturer.setHours((Integer) result[4]);
                lecturer.setDateOfBirth((LocalDateTime) result[5]);
                lecturer.setGender((String) result[6]);

                employees.add(lecturer);
            }
            return copyEmployeesToDto(employees);
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }

    public void createEmployee(Long id, String name, String email, String address, int salary, int hours, LocalDateTime birthdate, String gender) {
        LOG.info("create Employee");

        Lecturer employee = new Lecturer();
        employee.setId(id);
        employee.setName(name);
        employee.setGender(email);
        employee.setDateOfBirth(birthdate);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setHours(hours);
        employee.setGender(gender);
        String sqlString = "INSERT INTO employee (ID, ADDRESS, GENDER, NAME, SALARY, WORKINGHOURS) VALUES (";
        sqlString += String.valueOf(id);
        sqlString += ",";
        sqlString = sqlString + "'" + address + "',";
       // sqlString = sqlString + "'" + java.sql.Timestamp.valueOf(birthdate) + "',";
        sqlString = sqlString + "'" + gender + "',";
        sqlString = sqlString + "'" + name + "',";
        sqlString = sqlString + salary + ",";
        sqlString = sqlString + hours + ");";
        entityManager.createNativeQuery(sqlString);
    }

    public void updateEmployee(Long id,String name, String email, String address, Integer salary, String employeeClass, Integer hours,LocalDateTime birthdate, String gender) {
        LOG.info("update Employee");
        Lecturer employee = entityManager.find(Lecturer.class, email);
        employee.setId(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setEmployeeClass(employeeClass);
        employee.setHours(hours);
        employee.setDateOfBirth(birthdate);
        employee.setGender(gender);
    }

    public void deleteEmployee(Collection<Long> ids) {
        LOG.info("Deleting Employee");
        for (Long id : ids) {
            Lecturer employee = entityManager.find(Lecturer.class, id);
            entityManager.remove(employee);
        }
    }
}
