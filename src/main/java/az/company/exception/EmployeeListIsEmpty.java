package az.company.exception;

public class EmployeeListIsEmpty extends RuntimeException {

    public EmployeeListIsEmpty(String message) {
        super(message);
    }
}
