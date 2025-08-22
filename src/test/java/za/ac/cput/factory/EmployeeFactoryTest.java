
/*
EmployeeFactoryTest.java
Author: Musa Banathi Nkosi (221744517)
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    void testCreateEmployeeSuccess() {
        Employee employee = EmployeeFactory.createEmployee(
                1L, "Musa", "Nkosi", "musa@example.com", "Developer", 25000.00);

        assertNotNull(employee);
        assertEquals(1L, employee.getEmployeeID());
        assertEquals("Musa", employee.getFirstName());
        assertEquals("Nkosi", employee.getLastName());
        assertEquals("musa@example.com", employee.getEmail());
        assertEquals("Developer", employee.getPosition());
        assertEquals(25000.00, employee.getSalary());
    }

    @Test
    void testCreateEmployeeWithEmptyFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.createEmployee(1L, "", "Nkosi", "musa@example.com", "Developer", 25000.00));

        assertEquals("Error: First name, Last name, Email, or Position cannot be empty.", exception.getMessage());
    }

    @Test
    void testCreateEmployeeWithInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.createEmployee(1L, "Musa", "Nkosi", "invalidemail.com", "Developer", 25000.00));

        assertEquals("Error: Invalid email format.", exception.getMessage());
    }

    @Test
    void testCreateEmployeeWithNegativeID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.createEmployee(-5L, "Musa", "Nkosi", "musa@example.com", "Developer", 25000.00));

        assertEquals("Error: Employee ID must be greater than 0.", exception.getMessage());
    }

    @Test
    void testCreateEmployeeWithZeroSalary() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.createEmployee(1L, "Musa", "Nkosi", "musa@example.com", "Developer", 0));

        assertEquals("Error: Salary must be greater than 0.", exception.getMessage());
    }

    @Test
    void testCreateEmployeeWithNullFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.createEmployee(1L, null, "Nkosi", "musa@example.com", "Developer", 25000.00));

        assertEquals("Error: First name, Last name, Email, or Position cannot be empty.", exception.getMessage());
    }

    @Test
    void testCreateEmployeeWithEmptyPosition() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.createEmployee(1L, "Musa", "Nkosi", "musa@example.com", "", 25000.00));

        assertEquals("Error: First name, Last name, Email, or Position cannot be empty.", exception.getMessage());
    }

    @Test
    void testCreateEmployeeWithWhitespaceOnlyFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.createEmployee(1L, "   ", "Nkosi", "musa@example.com", "Developer", 25000.00));

        assertEquals("Error: First name, Last name, Email, or Position cannot be empty.", exception.getMessage());
    }

    @Test
    void testCreateEmployeeWithEmailMissingAtSymbol() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.createEmployee(1L, "Musa", "Nkosi", "musaexample.com", "Developer", 25000.00));

        assertEquals("Error: Invalid email format.", exception.getMessage());
    }

    @Test
    void testCreateEmployeeWithNegativeSalary() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.createEmployee(1L, "Musa", "Nkosi", "musa@example.com", "Developer", -1000.00));

        assertEquals("Error: Salary must be greater than 0.", exception.getMessage());
    }

    @Test
    void testCreateEmployeeWithValidDataAndTrimming() {
        Employee employee = EmployeeFactory.createEmployee(
                2L, "  John  ", "  Doe  ", "  john.doe@example.com  ", "  Manager  ", 30000.00);

        assertNotNull(employee);
        assertEquals(2L, employee.getEmployeeID());
        assertEquals("John", employee.getFirstName()); // Should be trimmed
        assertEquals("Doe", employee.getLastName()); // Should be trimmed
        assertEquals("john.doe@example.com", employee.getEmail()); // Should be trimmed
        assertEquals("Manager", employee.getPosition()); // Should be trimmed
        assertEquals(30000.00, employee.getSalary());
    }
}