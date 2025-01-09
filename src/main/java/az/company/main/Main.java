package az.company.main;

import az.company.service.EmployeeService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();

        System.out.println("\nWelcome to Employee Management System !");
        System.out.println("""
                Choose option:
                1. Add Employee
                2. Get All Employee
                3. Get Employee by ID
                4. Update Employee by ID
                5. Delete Employee by ID""");

        switch (scanner.nextInt()) {
            case 1:
                employeeService.addEmployee();
                break;
            case 2:
                employeeService.getAllEmployees();
                break;
            case 3:
                employeeService.getEmployeeById();
                break;
            case 4:
                employeeService.updateEmployee();
                break;
            case 5:
                employeeService.deleteEmployee();
                break;
            default:
                System.err.println("Invalid option !");
        }
        main(args);
    }
}