package az.company.dao;

import az.company.exception.InvalidEmployeeIdException;
import az.company.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

     final String url = "jdbc:postgresql://localhost:5454/postgres";
     final String user = "postgres";
     final String password = "4560";

    private Connection connection = null;

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection to database has been closed !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Employee employee) {
        String sql = "INSERT INTO employees (first_name, last_name, email, " +
                "phone_number, salary, job_title, department_id) VALUES(?,?,?,?,?,?,?)";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setString(4, employee.getPhoneNumber());
            statement.setDouble(5, employee.getSalary());
            statement.setString(6, employee.getJobTitle());
            statement.setInt(7, employee.getDepartmentId());
            statement.execute();
            System.out.println("Employee added successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> getAll() {
        String sql = "SELECT * FROM employees";
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setJobTitle(resultSet.getString("job_title"));
                employee.setDepartmentId(resultSet.getInt("department_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

    public void getId(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Employee employee = new Employee();

                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setJobTitle(resultSet.getString("job_title"));
                employee.setDepartmentId(resultSet.getInt("department_id"));
                System.out.println(employee);
            } else {
                throw new InvalidEmployeeIdException("The entered ID is invalid !");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Employee employee, int id) {
        String sql = "UPDATE employees set first_name = ?, last_name = ?, " +
                "email = ?, phone_number = ?, salary = ?, job_title = ?, department_id = ? WHERE id = ?";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setString(4, employee.getPhoneNumber());
            statement.setDouble(5, employee.getSalary());
            statement.setString(6, employee.getJobTitle());
            statement.setInt(7, employee.getDepartmentId());
            statement.setInt(8, id);
            statement.executeUpdate();
            System.out.println("Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            System.out.println("Successfully Deleted !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
