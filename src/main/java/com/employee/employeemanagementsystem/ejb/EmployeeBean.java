package com.employee.employeemanagementsystem.ejb;

import com.employee.employeemanagementsystem.entities.Employee;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class EmployeeBean {
    private static final Logger LOG = Logger.getLogger(EmployeeBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;
    public void findAllEmployees(){
        LOG.info("findAllEmployees");
        try{
            TypedQuery<Employee> typedQuery = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
            List<Employee> employees = typedQuery.getResultList();
        }
        catch (Exception e) {
            throw new EJBException(e);
        }
    }
}
