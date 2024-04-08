package org.lilmoon.service;

import org.lilmoon.data.Employee;
import org.lilmoon.data.EmployeeDBRepository;
import org.lilmoon.data.EmployeeDataBase;
import org.lilmoon.view.EmployeeDataBaseView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EmployeeDataBaseService implements EmployeeDBRepository {
    EmployeeDataBase employees = new EmployeeDataBase();

    @Override
    public ArrayList<Employee> findEmployeeByExp(int experience) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees.getEmployees()) {
            if (employee.getExperience() == experience) result.add(employee);
        }

        if (result.isEmpty()) {
            throw new RuntimeException(String.format("Employee with experience %d not found", experience));
        }
        return result;
    }

    @Override
    public Map<String, String> findPhoneNumberByName(String name) {
        Map<String, String> numberNameMap = new HashMap<>();
        for (Employee employee : employees.getEmployees()) {
            if (employee.getName().equals(name)) {
                numberNameMap.put(employee.getPhoneNumber(), employee.getName());
            }
        }

        if (numberNameMap.isEmpty()) throw new RuntimeException(String.format("Name %s not found", name));
        return numberNameMap;
    }

    @Override
    public Employee findById(long id) {
        for (Employee employee : employees.getEmployees()) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new RuntimeException("Invalid id");
    }

    @Override
    public void addNewEmployee(Employee employee) {
        if (employee == null) throw new NullPointerException("You can't add null!");
        employees.addNewEmployee(employee);
    }

    @Override
    public Employee createNewEmployee(String name, String phoneNumber, int experience) {
        return new Employee(name, phoneNumber, experience);
    }

    public Set<Employee> getEmployees(){
        return employees.getEmployees();
    }
}
