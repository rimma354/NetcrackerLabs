/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.netcracker.labs.lab18.facades;

import com.netcracker.labs.lab18.entities.Department;
import com.netcracker.labs.lab18.entities.Employee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Rimma
 */
@Local
public interface EmployeeFacadeLocal {

    void create(Employee employee);

    void edit(Employee employee);

    void delete(Employee employee);

    Employee findById(Object id);

    List<Employee> findAll();
    
    List <Employee> findByDepartment(Department department);
    
}
