/*
Employee.java
Author: Musa Banathi Nkosi (221744517)
*/

package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long employeeID;
    private Long employeeID;

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

    public Long getEmployeeID() { return employeeID; }
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
    public static class Builder{

        private Long employeeID;
        private String firstName;
        private String lastName;
        private String email;
        private String position;
        private double salary;

        public Builder setEmployeeID(Long employeeID) {
            this.employeeID = employeeID;
            return this;
        }
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
    }
        public Builder setLastName(String lastName) {
        this.lastName = lastName;
            return this;
    }

    public  Builder setEmail(String email) {
            this.email = email;
            return this;
        }
    public Builder setPosition(String position) {
            this.position = position;
            return this;
        }
    public Builder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public Employee build() {
            return new Employee(firstName, lastName, email, position, salary);
    }
    }

}


