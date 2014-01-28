package com.netcracker.labs.lab18.entities;

import com.netcracker.labs.lab18.entities.Department;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2013-12-26T15:27:51")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, Integer> employeeId;
    public static volatile SingularAttribute<Employee, String> lastName;
    public static volatile SingularAttribute<Employee, Department> department;
    public static volatile SingularAttribute<Employee, BigDecimal> salary;
    public static volatile SingularAttribute<Employee, String> firstName;

}