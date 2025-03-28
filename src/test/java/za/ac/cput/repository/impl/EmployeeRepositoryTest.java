package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    private EmployeeRepository repository;
    private Employee employee1, employee2, employee3;

    @BeforeEach
    void setUp() {
        repository = new EmployeeRepository();

        employee1 = EmployeeFactory.createEmployee(1, "Musa", "Nkosi", "m.n@cput.ac.za", "Cashier", 35000);
        employee2 = EmployeeFactory.createEmployee(2, "Siphosethu", "Msengeni", "s.m@cput.ac.za", "Manager", 50000);
        employee3 = EmployeeFactory.createEmployee(3, "Ashton", "Petersen", "a.p@cput.ac.za", "Sales Assistant", 28000);

        repository.create(employee1);
        repository.create(employee2);
        repository.create(employee3);
    }

    @Test
    void testCreate() {
        Employee newEmployee = EmployeeFactory.createEmployee(4, "Thabo", "Molefe", "t.molefe@cput.ac.za", "Supervisor", 40000);
        assertNotNull(repository.create(newEmployee));
    }

    @Test
    void testRead() {
        assertEquals(employee1, repository.read(1));
    }

    @Test
    void testUpdate() {
        Employee updatedEmployee = new Employee.Builder()
                .setEmployeeID(1)
                .setFirstName("Musa")
                .setLastName("Nkosi")
                .setEmail("m.n@cput.ac.za")
                .setPosition("Senior Cashier")
                .setSalary(37000)
                .build();

        assertNotNull(repository.update(updatedEmployee));
        assertEquals("Senior Cashier", repository.read(1).getPosition());
    }

    @Test
    void testDelete() {
        assertTrue(repository.delete(3));
        assertNull(repository.read(3));
    }

    @Test
    void testFindAll() {
        List<Employee> employees = repository.findAll();
        assertEquals(3, employees.size());
    }

    @Test
    void testFindByLastName() {
        List<Employee> result = repository.findByLastName("Msengeni");
        assertEquals(1, result.size());
    }

    @Test
    void testFindByPosition() {
        List<Employee> result = repository.findByPosition("Manager");
        assertEquals(1, result.size());
    }

    @Test
    void testFindBySalaryRange() {
        List<Employee> result = repository.findBySalaryRange(30000, 50000);
        assertEquals(2, result.size());
    }
}
