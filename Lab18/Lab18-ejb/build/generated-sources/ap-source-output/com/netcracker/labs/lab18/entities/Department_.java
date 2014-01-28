package com.netcracker.labs.lab18.entities;

import com.netcracker.labs.lab18.entities.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2013-12-26T15:27:51")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile SingularAttribute<Department, Integer> departmentId;
    public static volatile SingularAttribute<Department, String> departmentName;
    public static volatile CollectionAttribute<Department, Employee> employees;

}