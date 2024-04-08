package org.lilmoon.view;

import org.lilmoon.data.Employee;
import org.lilmoon.data.EmployeeComparator;

import java.util.*;

public class EmployeeDataBaseView {
    public EmployeeDataBaseView() {
    }

    public void printEmployee(Employee employee) {
        System.out.println(employee);
    }

    public void printEmployeeList(Collection<Employee> employees) {
        SortedSet<Employee> sortedSet = new TreeSet<>(new EmployeeComparator());
        sortedSet.addAll(employees);
        sortedSet.forEach(System.out::println);
    }

    public void printMap(Map<String,String> map){
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println(stringStringEntry);
        }
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
