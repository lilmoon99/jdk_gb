package org.lilmoon;

import org.lilmoon.contoller.EmployeeDataBaseController;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        EmployeeDataBaseController controller = new EmployeeDataBaseController();
        controller.createEmployee("Aynur", "89911944602", 1);
        controller.createEmployee("Ivan", "89911235602", 4);
        controller.createEmployee("Pavel", "89012854602", 6);
        controller.createEmployee("Elisa", "899985123905", 0);
        controller.printEmployeesList();
        boolean isExit = false;
        while (!isExit) {
            System.out.println("""
                    ================================
                    1 - create employee
                    2 - print all employees
                    3 - find by ID
                    4 - find phone number by name
                    5 - find employee by experience
                    6 - exit
                    ================================
                    """);

            Scanner scanner = new Scanner(System.in);
            int command = 0;
            try {

                command = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You entered not a number!");
            }
            switch (command) {
                case 1:
                    try {
                        System.out.print("Enter name:");
                        String name = new Scanner(System.in).nextLine();
                        System.out.print("Enter phone number: ");
                        String phone = new Scanner(System.in).next();
                        System.out.print("Enter experience: ");
                        int experience = new Scanner(System.in).nextInt();
                        controller.createEmployee(name, phone, experience);
                    } catch (RuntimeException e) {
                        System.out.println("Wrong arguments!");
                    }
                    break;
                case 2:
                    controller.printEmployeesList();
                    break;
                case 3:
                    try {
                        System.out.print("Enter ID to find: ");
                        controller.findById((new Scanner(System.in).nextInt()));
                    } catch (IllegalArgumentException e) {
                        System.out.println("You entered not a number!");
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Enter name: ");
                        controller.findPhoneNumberByName(new Scanner(System.in).nextLine());
                    } catch (NoSuchElementException e) {
                        System.out.println("You entered nothing!");
                    }
                    break;
                case 5:
                    try {
                        System.out.print("Enter employee's experience:");
                        controller.findEmployeeByExperience(new Scanner(System.in).nextInt());
                    }catch (RuntimeException e){
                        System.out.println("You entered not a number!");
                    }
                    break;
                case 6:
                    isExit = true;
                    break;
                default:
                    System.out.println("You entered wrong command");

            }
        }

    }
}