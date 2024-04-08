package org.lilmoon.data;

import java.util.*;

public class EmployeeDataBase {

    Set<Employee> employees;

    public EmployeeDataBase() {
        this.employees = new HashSet<>();
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDataBase that = (EmployeeDataBase) o;
        return Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees);
    }

    @Override
    public String toString() {
        return "EmployeeDataBase{" +
                "employees=" + employees +
                '}';
    }

    public void addNewEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
