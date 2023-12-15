package com.employee.employeemanagementsystem.ejb;

import com.employee.employeemanagementsystem.entities.Employee;
import common.EmployeeDto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.*;
import java.util.logging.Logger;

@Stateless
public class EmployeeBean {
    private static final Logger LOG = Logger.getLogger(EmployeeBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;

    public List<EmployeeDto> copyEmployeesToDto(List<Employee> employees) {
        List<EmployeeDto> list = new ArrayList<>();
        for (Employee i : employees) {
            list.add(new EmployeeDto(i.getId(), i.getName(), i.getGender(), i.getDateOfBirth(), i.getAddress(), i.getSalary(), i.getReligion(), i.getPassword(), i.getWorkingHours()));
        }
        return list;
    }

    public List<EmployeeDto> findAllEmployees() {
        LOG.info("findAllEmployees");
        try {
            TypedQuery<Employee> typedQuery = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
            List<Employee> employees = typedQuery.getResultList();
            return copyEmployeesToDto(employees);
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }

    public void createEmployee(Long id, String name, String gender, Date dateOfBirth, String address, Integer salary, String religion, String password) {
        LOG.info("create Employee");

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setGender(gender);
        employee.setDateOfBirth(dateOfBirth);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setReligion(religion);
        employee.setPassword(password);
        entityManager.persist(employee);
    }

    public void updateEmployee(Long id, String name, String gender, Date dateOfBirth, String address, Integer salary, String religion, String password) {
        LOG.info("update Employee");
        Employee employee = entityManager.find(Employee.class, id);
        employee.setId(id);
        employee.setName(name);
        employee.setGender(gender);
        employee.setDateOfBirth(dateOfBirth);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setReligion(religion);
        employee.setPassword(password);
    }

    public void deleteEmployee(Collection<Long> ids) {
        LOG.info("Deleting Employee");
        for (Long id : ids) {
            Employee employee = entityManager.find(Employee.class, id);
            entityManager.remove(employee);
        }
    }
}
