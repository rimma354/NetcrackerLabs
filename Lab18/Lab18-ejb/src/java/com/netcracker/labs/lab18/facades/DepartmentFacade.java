package com.netcracker.labs.lab18.facades;

import com.netcracker.labs.lab18.entities.Department;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless (name="DepartmentBean")
public class DepartmentFacade extends AbstractFacade<Department> implements DepartmentFacadeLocal {
    @PersistenceContext(unitName = "Lab18-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartmentFacade() {
        super(Department.class);
    }
    
}
