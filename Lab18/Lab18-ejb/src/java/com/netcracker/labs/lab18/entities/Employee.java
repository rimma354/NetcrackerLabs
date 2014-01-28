package com.netcracker.labs.lab18.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "EMPLOYEES")
@NamedQuery(name="findByDepartmentId",query="SELECT e FROM Employee e WHERE  e.department = :department")
public class Employee implements Serializable {
    @Id
    @NotNull
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;
    @Size(max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "SALARY")
    private BigDecimal salary;
    @JoinColumn(name = "DEPARTMENT_ID")
    @ManyToOne
    private Department department;

    public Employee() {
    }


    public Employee(Integer employeeId, String lastName) {
        this.employeeId = employeeId;
        this.lastName = lastName;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
 int hash = 0;
        if (employeeId!=null){
            hash +=employeeId.hashCode();
        }
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        return this.employeeId.equals(other.employeeId);
    }

    @Override
    public String toString() {
        return "Employee id=" + employeeId + ", last name=" + lastName + ", first name=" + firstName + ", salary=" + salary + ".";
    }
    
}
