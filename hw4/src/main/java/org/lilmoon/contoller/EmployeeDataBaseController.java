package org.lilmoon.contoller;

import org.lilmoon.data.Employee;
import org.lilmoon.service.EmployeeDataBaseService;
import org.lilmoon.view.EmployeeDataBaseView;

public class EmployeeDataBaseController {

   private final EmployeeDataBaseService service = new EmployeeDataBaseService();
    private final EmployeeDataBaseView view = new EmployeeDataBaseView();



    public void findEmployeeByExperience(int experience){
        try {
            view.printEmployeeList(service.findEmployeeByExp(experience));

        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void findPhoneNumberByName(String name){
        try {
            view.printMap(service.findPhoneNumberByName(name));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void findById(long id){
        try {
            view.printEmployee(service.findById(id));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void createEmployee(String name,String phoneNumber,int experience){
        Employee employee = new Employee(name,phoneNumber,experience);
        service.addNewEmployee(employee);
        view.printMessage("Employee added successfully.");
    }

    public void printEmployeesList(){
        view.printEmployeeList(service.getEmployees());
    }
}
