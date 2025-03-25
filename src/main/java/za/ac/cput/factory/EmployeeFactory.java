package za.ac.cput.factory;

import za.ac.cput.domain.Employee;

public class EmployeeFactory {
    public static Employee createEmployee(int employeeID, String firstName, String lastName, String email, String position, double salary) {
        return new Employee.Builder()
                .setEmployeeID(employeeID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPosition(position)
                .setSalary(salary)
                .build();
    }
}
