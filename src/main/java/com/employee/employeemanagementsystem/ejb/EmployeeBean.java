package com.employee.employeemanagementsystem.ejb;

import com.employee.employeemanagementsystem.entities.*;
import com.employee.employeemanagementsystem.interfaces.CardMethod;
import common.AssociateDto;
import common.EmployeeDto;
import common.ExecutiveDto;
import common.LecturerDto;
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
            if(i instanceof Lecturer)
                list.add(new LecturerDto(i.getId(), i.getName(), i.getGender(), i.getDateOfBirth(), i.getAddress(), i.getSalary(), i.getReligion(), i.getWorkingHours(),  i.getEmail()));
            else if(i instanceof Associate)
            {
                String bonusType = (((Associate) i).getBonus() != null) ? ((Associate) i).getBonus().getBonusType().toString() : "No Bonus";
                list.add(new AssociateDto(i.getId(), i.getName(), i.getGender(), i.getDateOfBirth(), i.getAddress(), i.getSalary(), i.getReligion(), i.getWorkingHours(),  i.getEmail(), bonusType));
            }
            else if(i instanceof Executive) {
                String bonusType = (((Executive) i).getBonus() != null) ? ((Executive) i).getBonus().getBonusType().toString() : "No Bonus";
                list.add(new ExecutiveDto(i.getId(), i.getName(), i.getGender(), i.getDateOfBirth(), i.getAddress(), i.getSalary(), i.getReligion(), i.getWorkingHours(), i.getEmail(), bonusType, ((Executive) i).getNumberOfShares()));
            }
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

    public void createEmployee(String employeeType, String name, String gender, LocalDate dateOfBirth, String address, Integer salary, String religion, String password, String email, Integer workingHours, String bonusString, Integer numberOfShares, String taxClass, String bank, String account) {
        LOG.info("createEmployee");
        Employee employee;
        Bonus bonus = new Bonus();
        switch (employeeType){
            case "Associate":
                employee = new Associate();
                if(!bonusString.equals("NONE")) {
                    bonus.setBonusType(Bonus.BonusType.valueOf(bonusString));
                    bonus.setEmployee(employee);
                    ((Associate) employee).setBonus(bonus);
                }
                break;
            case "Executive":
                employee = new Executive();
                if(!bonusString.equals("NONE")) {
                    bonus.setBonusType(Bonus.BonusType.valueOf(bonusString));
                    bonus.setEmployee(employee);
                    ((Executive) employee).setBonus(bonus);
                }
                ((Executive) employee).setNumberOfShares(numberOfShares);
                break;
            default:
                employee = new Lecturer();
                break;
        }
        employee.setName(name);
        employee.setGender(gender);
        employee.setDateOfBirth(dateOfBirth);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setReligion(religion);
        employee.setPassword(passwordBean.convertToSha256(password));
        employee.setEmail(email);
        employee.setWorkingHours(workingHours);
        employee.setTaxClass(Employee.TaxClass.valueOf(taxClass));
        CardMethod paymentMethod = new CardMethod();
        paymentMethod.setBank(bank);
        paymentMethod.setAccount(account);
        employee.setPaymentMethod(paymentMethod);
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


    public void deleteEmployeesById(Collection<Long> employeeIds) {
        entityManager.createQuery("DELETE FROM Employee e WHERE e.id IN :employeeIds")
                .setParameter("employeeIds", employeeIds)
                .executeUpdate();
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


