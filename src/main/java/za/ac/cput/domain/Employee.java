/*
Employee.java
Author: Musa Banathi Nkosi (221744517)
*/

package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeID;

    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private double salary;

    protected Employee() {} // Required by JPA

    public Employee(String firstName, String lastName, String email, String position, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeID() { return employeeID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    public void promote(String newPosition, double salaryIncrease) {
        this.position = newPosition;
        this.salary += salaryIncrease;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
