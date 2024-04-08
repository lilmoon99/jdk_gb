package org.lilmoon.data;

import java.util.ArrayList;
import java.util.Map;

public interface EmployeeDBRepository {
    ArrayList<Employee> findEmployeeByExp(int experience);
    Map<String,String> findPhoneNumberByName(String name);
    Employee findById(long id);
    void addNewEmployee(Employee employee);

    Employee createNewEmployee(String name,String phoneNumber,int experience);
}
