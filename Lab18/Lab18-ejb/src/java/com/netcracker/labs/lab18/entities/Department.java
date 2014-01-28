package com.netcracker.labs.lab18.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DEPARTMENTS")
public class Department implements Serializable {

    @Id
    @NotNull
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @OneToMany(mappedBy = "department")
    private Collection<Employee> employees;

    public Department() {
    }

    public Department(Integer departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public int hashCode() {
         int hash = 0;
        if (departmentId!=null){
            hash +=departmentId.hashCode();
        }
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        return this.departmentId.equals(other.departmentId);
    }

    @Override
    public String toString() {
        return "Department id=" + departmentId +", department name=" + departmentName + ".";
    }

}
