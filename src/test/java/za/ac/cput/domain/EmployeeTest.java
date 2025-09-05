///*
//EmployeeTest.java
//Author: 222791829
//*/
//
//package za.ac.cput.domain;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class EmployeeTest {
//
//    @Test
//    void testEmployeeCreation() {
//        Employee emp = new Employee("John", "Doe", "john.doe@example.com", "Developer", 50000);
//
//        assertNotNull(emp);
//        assertEquals("John", emp.getFirstName());
//        assertEquals("Doe", emp.getLastName());
//        assertEquals("john.doe@example.com", emp.getEmail());
//        assertEquals("Developer", emp.getPosition());
//        assertEquals(50000, emp.getSalary());
//    }
//
//    @Test
//    void testPromoteEmployee() {
//        Employee emp = new Employee("Jane", "Smith", "jane.smith@example.com", "Intern", 20000);
//
//        emp.promote("Junior Developer", 5000);
//
//        assertEquals("Junior Developer", emp.getPosition());
//        assertEquals(25000, emp.getSalary());
//    }
//
//    @Test
//    void testToStringContainsFields() {
//        Employee emp = new Employee("Alice", "Brown", "alice.brown@example.com", "Manager", 75000);
//
//        String result = emp.toString();
//
//        assertTrue(result.contains("Alice"));
//        assertTrue(result.contains("Brown"));
//        assertTrue(result.contains("Manager"));
//        assertTrue(result.contains("75000"));
//    }
//}
