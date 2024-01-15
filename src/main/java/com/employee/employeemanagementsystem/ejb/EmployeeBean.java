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
import jakarta.transaction.Transactional;

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
                list.add(new LecturerDto(i.getId(), i.getName(), i.getGender(), i.getDateOfBirth(), i.getAddress(), i.getSalary(), i.getReligion(), i.getWorkingHours(), i.getEmail(), i.getTaxClass().toString()));
            else if(i instanceof Associate)
            {
                String bonusType = (((Associate) i).getBonus() != null) ? ((Associate) i).getBonus().getBonusType().toString() : "No Bonus";
                list.add(new AssociateDto(i.getId(), i.getName(), i.getGender(), i.getDateOfBirth(), i.getAddress(), i.getSalary(), i.getReligion(), i.getWorkingHours(), i.getEmail(), i.getTaxClass().toString(), bonusType));
            }
            else if(i instanceof Executive) {
                String bonusType = (((Executive) i).getBonus() != null) ? ((Executive) i).getBonus().getBonusType().toString() : "No Bonus";
                list.add(new ExecutiveDto(i.getId(), i.getName(), i.getGender(), i.getDateOfBirth(), i.getAddress(), i.getSalary(), i.getReligion(), i.getWorkingHours(), i.getEmail(), i.getTaxClass().toString(), bonusType, ((Executive) i).getNumberOfShares()));
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

    public void createEmployee(String employeeType, String name, String gender, LocalDate dateOfBirth, String address, Integer salary, String religion, String password, String email, Integer workingHours, String bonusString, Integer numberOfShares, String taxClass, String bank, String account, Collection<String> groups) {
        LOG.info("createEmployee");
        Employee employee = setBonusAndNumberOfShares(employeeType, bonusString, numberOfShares);
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
        assignGroupsToEmployee(name, email, groups);
    }

    public void updateEmployee(Long id, String name, String gender, LocalDate dateOfBirth, String address, Integer salary, String religion, String password, String email, Integer workingHours, Integer numberOfShares, String taxClass) {
        LOG.info("updateEmployee");
        Employee employee = entityManager.find(Employee.class, id);
        employee.setName(name);
        employee.setGender(gender);
        employee.setDateOfBirth(dateOfBirth);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setReligion(religion);
        employee.setWorkingHours(workingHours);
        employee.setTaxClass(Employee.TaxClass.valueOf(taxClass));
        if(!password.isEmpty())
            employee.setPassword(passwordBean.convertToSha256(password));
        employee.setEmail(email);
    }

    private Employee setBonusAndNumberOfShares(String employeeType, String bonusString, Integer numberOfShares){
        Employee employee;
        switch (employeeType){
            case "Associate":
                employee = new Associate();
                assignBonus(employee, bonusString);
            case "Executive":
                employee = new Executive();
                assignBonus(employee, bonusString);
                ((Executive) employee).setNumberOfShares(numberOfShares);
                break;
            default:
                employee = new Lecturer();
                break;
        }
        return employee;
    }

    private void assignBonus(Employee employee, String bonusString){
        if(!bonusString.equals("NONE")) {
            Bonus bonus = new Bonus();
            bonus.setBonusType(Bonus.BonusType.valueOf(bonusString));
            bonus.setEmployee(employee);
            ((Associate) employee).setBonus(bonus);
        }
    }


    public void deleteEmployeesById(Collection<Long> employeeIds) {
        entityManager.createNativeQuery("SET foreign_key_checks = 0").executeUpdate();
        entityManager.createQuery("DELETE FROM CardMethod c WHERE c.employee.id IN :employeeIds")
                .setParameter("employeeIds", employeeIds)
                .executeUpdate();
        entityManager.createQuery("DELETE FROM CardMethod c WHERE c.employee.id IN :employeeIds")
                .setParameter("employeeIds", employeeIds)
                .executeUpdate();
        entityManager.createQuery("DELETE FROM Employee e WHERE e.id IN :employeeIds")
                .setParameter("employeeIds", employeeIds)
                .executeUpdate();
        entityManager.createNativeQuery("SET foreign_key_checks = 1").executeUpdate();
    }
    private void assignGroupsToEmployee(String name, String email, Collection<String> groups) {
        LOG.info("assignGroupsToEmployee");
        for (String group : groups) {
            EmployeeGroup employeeGroup = new EmployeeGroup();
            employeeGroup.setName(name);
            employeeGroup.setEmail(email);
            employeeGroup.setEmployeeGroup(group);
            entityManager.persist(employeeGroup);
        }
    }

    public EmployeeDto findById(Long id) {
        try {
            LOG.info("findEmployeeById");
            Employee employee = entityManager.find(Employee.class, id);
            EmployeeDto employeeDto;
            if(employee instanceof Associate) {
                String bonus = "";
                if (((Associate) employee).getBonus() != null) {
                    bonus = ((Associate) employee).getBonus().getBonusType().toString();
                }
                employeeDto = new AssociateDto(employee.getId(), employee.getName(), employee.getGender(), employee.getDateOfBirth(), employee.getAddress(), employee.getSalary(), employee.getReligion(), employee.getWorkingHours(), employee.getEmail(), employee.getTaxClass().toString(), bonus);
            }
            else if(employee instanceof Executive) {
                String bonus = "";
                if (((Executive) employee).getBonus() != null) {
                    bonus = ((Executive) employee).getBonus().getBonusType().toString();
                }
                employeeDto = new ExecutiveDto(employee.getId(), employee.getName(), employee.getGender(), employee.getDateOfBirth(), employee.getAddress(), employee.getSalary(), employee.getReligion(), employee.getWorkingHours(), employee.getEmail(), employee.getTaxClass().toString(), bonus, ((Executive) employee).getNumberOfShares());
            }
            else
                employeeDto = new LecturerDto(employee.getId(), employee.getName(), employee.getGender(), employee.getDateOfBirth(), employee.getAddress(), employee.getSalary(), employee.getReligion(), employee.getWorkingHours(), employee.getEmail(), employee.getTaxClass().toString());
            return employeeDto;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
}


