package za.ac.cput.factory;

import za.ac.cput.domain.Employee;

public class EmployeeFactory {

    public static Employee createEmployee(int employeeID, String firstName, String lastName, String email, String position, double salary) {
        if ((firstName == null || firstName.isEmpty()) ||
                (lastName == null || lastName.isEmpty()) ||
                (email == null || email.isEmpty()) ||
                (position == null || position.isEmpty())) {
            System.out.println("Error: First name, Last name, Email, or Position is empty or null.");
            return null;
        }

        if (employeeID <= 0 || salary <= 0) {
            System.out.println("Error: Employee ID or Salary is invalid.");
            return null;
        }

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
