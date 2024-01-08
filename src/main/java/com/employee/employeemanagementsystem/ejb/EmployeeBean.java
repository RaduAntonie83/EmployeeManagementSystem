package com.employee.employeemanagementsystem.ejb;

import com.employee.employeemanagementsystem.entities.Employee;
import com.employee.employeemanagementsystem.entities.Lecturer;
import common.EmployeeDto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.xml.bind.SchemaOutputResolver;

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
            list.add(new EmployeeDto(i.getId(), i.getName(), i.getGender(), i.getDateOfBirth(), i.getAddress(), i.getSalary(), i.getReligion(), i.getPassword(), i.getWorkingHours(),  i.getEmail()));
        }
        return list;
    }

    public List<EmployeeDto> findAllEmployees() {
        LOG.info("findAllEmployees");
        try {
            Query query = entityManager.createNativeQuery("SELECT id, name, gender, dateOfBirth, address, salary, religion, password, workingHours, email FROM Employee");
            List<Object[]> results = query.getResultList();

            List<Lecturer> employees = new ArrayList<>();
            for (Object[] result : results) {
                Lecturer lecturer = new Lecturer();
                lecturer.setId((Long) result[0]);
                lecturer.setName((String) result[1]);
                lecturer.setGender((String) result[2]);
                lecturer.setDateOfBirth((LocalDateTime) result[3]);
                lecturer.setAddress((String) result[4]);
                lecturer.setSalary((Integer) result[5]);
                lecturer.setReligion((String) result[6]);
                lecturer.setPassword((String) result[7]);
                lecturer.setWorkingHours((Integer) result[8]);
                lecturer.setEmail((String) result[9]);



                employees.add(lecturer);
            }
            System.out.println(employees);
            return copyEmployeesToDto(employees);
        } catch (Exception e) {
            throw new EJBException("cevaaaaa");
        }
    }

    public void createEmployee(Long id, String name, String gender, LocalDateTime dateOfBirth, String address, Integer salary, String religion, String password,String email) {
        LOG.info("create Employee");

        Employee employee = new Lecturer();
        employee.setId(id);
        employee.setName(name);
        employee.setGender(gender);
        employee.setDateOfBirth(dateOfBirth);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setReligion(religion);
        employee.setPassword(password);
        employee.setEmail(email);
        entityManager.persist(employee);
    }

    public void updateEmployee(Long id, String name, String gender, LocalDateTime dateOfBirth, String address, Integer salary, String religion, String password, String email) {
        LOG.info("update Employee");
        Lecturer employee = entityManager.find(Lecturer.class, id);
        employee.setId(id);
        employee.setName(name);
        employee.setGender(gender);
        employee.setDateOfBirth(dateOfBirth);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setReligion(religion);
        employee.setPassword(password);
        employee.setEmail(email);
    }

    public void deleteEmployee(Collection<Long> ids) {
        LOG.info("Deleting Employee");
        for (Long id : ids) {
            Lecturer employee = entityManager.find(Lecturer.class, id);
            entityManager.remove(employee);
        }


    }


    public boolean isValidLogin(String email, String password) {
        try {
            Query query = entityManager.createNativeQuery("SELECT COUNT(*) FROM employee WHERE email = ? AND password = ?");
            query.setParameter(1, email);
            query.setParameter(2, password);

            Long count = (Long) query.getSingleResult();

            return count > 0;
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }


    }


