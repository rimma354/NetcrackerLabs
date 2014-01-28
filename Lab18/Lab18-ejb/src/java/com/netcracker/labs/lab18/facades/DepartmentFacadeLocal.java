package com.netcracker.labs.lab18.facades;

import com.netcracker.labs.lab18.entities.Department;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DepartmentFacadeLocal {

    void create(Department department);

    void edit(Department department);

    void delete(Department department);

    Department findById(Object id);

    List<Department> findAll();
    
}
