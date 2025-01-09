package az.company.service;

import az.company.dao.EmployeeDao;
import az.company.exception.EmployeeListIsEmpty;
import az.company.exception.InvalidPhoneNumberLengthException;
import az.company.model.Employee;

import java.util.List;
import java.util.Scanner;

public class EmployeeService {

    Scanner scanner = new Scanner(System.in);
    EmployeeDao employeeDao = new EmployeeDao();
    Employee employee = new Employee();

    public void addEmployee() {
        System.out.println("Enter Employee Name: ");
        employee.setFirstName(scanner.nextLine());
        System.out.println("Enter Employee Surname: ");
        employee.setLastName(scanner.nextLine());
        System.out.println("Enter Employee Email: ");
        employee.setEmail(scanner.nextLine());
        System.out.println("Enter Employee Phone Number: ");
        String number = scanner.nextLine();
        if (number.length() > 10) {
            throw new InvalidPhoneNumberLengthException("The phone number length is incorrect. It should be 10 digits.");
        } else {
            employee.setPhoneNumber(number);
        }
        System.out.println("Enter Employee Salary: ");
        employee.setSalary(scanner.nextDouble());
        System.out.println("Enter Employee Job Title: ");
        scanner.nextLine();
        employee.setJobTitle(scanner.nextLine());
        System.out.println("Enter Employee Department ID: ");
        employee.setDepartmentId(scanner.nextInt());
        employeeDao.save(employee);
    }

    public void getAllEmployees() {
        List<Employee> employees = employeeDao.getAll();
        if (employees.isEmpty()) {
            throw new EmployeeListIsEmpty("Employee Not Found");
        } else {
            for (Employee employee : employees) {
                System.out.println("\n----------------------------");
                System.out.println(employee);
                System.out.println("----------------------------\n");
            }
        }
    }

    public void getEmployeeById() {
        System.out.println("Enter Employee ID: ");
        employeeDao.getId(scanner.nextInt());
    }

    public void updateEmployee() {
        System.out.println("Enter Employee ID to update:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Employee Name: ");
        employee.setFirstName(scanner.nextLine());
        System.out.println("Enter Employee Surname: ");
        employee.setLastName(scanner.nextLine());
        System.out.println("Enter Employee Email: ");
        employee.setEmail(scanner.nextLine());
        System.out.println("Enter Employee Phone Number: ");
        String number = scanner.nextLine();
        if (number.length() > 10) {
            throw new InvalidPhoneNumberLengthException("The phone number length is incorrect. It should be 10 digits.");
        } else {
            employee.setPhoneNumber(number);
        }
        System.out.println("Enter Employee Salary: ");
        employee.setSalary(scanner.nextDouble());
        scanner.nextLine();
        System.out.println("Enter Employee Job Title: ");
        employee.setJobTitle(scanner.nextLine());
        System.out.println("Enter Employee Department ID: ");
        employee.setDepartmentId(scanner.nextInt());

        employeeDao.update(employee, id);
    }

    public void deleteEmployee() {
        System.out.println("Enter the ID:");
        employeeDao.delete(scanner.nextInt());
    }


}
