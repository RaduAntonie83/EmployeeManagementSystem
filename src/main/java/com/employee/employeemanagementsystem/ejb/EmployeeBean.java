package com.employee.employeemanagementsystem.ejb;

import com.employee.employeemanagementsystem.entities.Employee;
import com.employee.employeemanagementsystem.entities.Lecturer;
import common.EmployeeDto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

@Stateless
public class EmployeeBean {
    private static final Logger LOG = Logger.getLogger(EmployeeBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;
    @Inject
    PasswordBean passwordBean;

    public List<EmployeeDto> copyEmployeesToDto(List<Employee> employees) {
        List<EmployeeDto> list = new ArrayList<>();
        for (Employee i : employees) {
            list.add(new EmployeeDto(i.getId(), i.getName(), i.getGender(), i.getDateOfBirth(), i.getAddress(), i.getSalary(), i.getReligion(), i.getPassword(), i.getWorkingHours(),  i.getEmail()));
        }
        return list;
    }

    public List<EmployeeDto> findAllEmployees() {
        try {
            LOG.info("findAllEmployees");
            TypedQuery<Employee> typedQuery =
                    entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
            List<Employee> employees = typedQuery.getResultList();
            return copyEmployeesToDto(employees);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void createEmployee(String name, String gender, LocalDate dateOfBirth, String address, Integer salary, String religion, String password, String email, Integer workingHours) {
        LOG.info("createEmployee");

        Employee employee = new Lecturer();
        employee.setName(name);
        employee.setGender(gender);
        employee.setDateOfBirth(dateOfBirth);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setReligion(religion);
        employee.setPassword(passwordBean.convertToSha256(password));
        employee.setEmail(email);
        employee.setWorkingHours(workingHours);
        entityManager.persist(employee);
    }

    public void updateEmployee(Long id, String name, String gender, LocalDate dateOfBirth, String address, Integer salary, String religion, String password, String email, Integer workingHours) {
        LOG.info("update Employee");
        Lecturer employee = entityManager.find(Lecturer.class, id);
        employee.setName(name);
        employee.setGender(gender);
        employee.setDateOfBirth(dateOfBirth);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setReligion(religion);
        if(!password.equals(""))
            employee.setPassword(passwordBean.convertToSha256(password));
        employee.setEmail(email);
    }

    public void deleteEmployee(Collection<Long> ids) {
        LOG.info("Deleting Employee");
        for (Long id : ids) {
            Lecturer employee = entityManager.find(Lecturer.class, id);
            entityManager.remove(employee);
        }
    }

    public EmployeeDto findById(Long id) {
        try {
            LOG.info("findEmployeeById");
            Lecturer employee = entityManager.find(Lecturer.class, id);
            return new EmployeeDto(employee.getId(), employee.getName(), employee.getGender(), employee.getDateOfBirth(), employee.getAddress(), employee.getSalary(), employee.getReligion(), employee.getPassword(), employee.getWorkingHours(),  employee.getEmail());
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
}


