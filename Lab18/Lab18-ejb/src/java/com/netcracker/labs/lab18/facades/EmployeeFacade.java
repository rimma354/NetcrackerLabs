package com.netcracker.labs.lab18.facades;

import com.netcracker.labs.lab18.entities.Department;
import com.netcracker.labs.lab18.entities.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless (name="EmployeeBean")
public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeLocal {
    @PersistenceContext(unitName = "Lab18-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }

    @Override
    public List<Employee> findByDepartment(Department department) {
        return em.createNamedQuery("findByDepartmentId").setParameter("department", department).getResultList();
    }
    
}
