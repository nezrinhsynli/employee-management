package az.company.model;

public class Employee {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Double salary;
    private String jobTitle;
    private Integer departmentId;

    public Employee() {

    }

    public Employee(String jobTitle, String firstName, String lastName,
                    String email, String phoneNumber, Double salary, Integer departmentId) {
        this.jobTitle = jobTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Name: " + firstName + "\n" +
                "Surname: " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Salary: " + salary + "\n" +
                "Job Title: " + jobTitle + "\n" +
                "Department ID: " + departmentId;
    }

}
