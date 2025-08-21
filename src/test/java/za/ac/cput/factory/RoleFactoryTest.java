//package za.ac.cput.factory;
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.domain.Role;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class RoleFactoryTest {
//
//    @Test
//    void testCreateValidRole() {
//        Role role = RoleFactory.createRole("R1", "Software Engineer", 55000.00);
//
//        assertNotNull(role);
//        assertEquals("R1", role.getRoleId());
//        assertEquals("Software Engineer", role.getRoleName());
//        assertEquals(55000.00, role.getRoleSalary());
//    }
//
//    @Test
//    void testCreateRoleWithInvalidId() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->
//                RoleFactory.createRole("", "Developer", 45000.00));
//        assertEquals("Role ID is required", exception.getMessage());
//    }
//
//    @Test
//    void testCreateRoleWithInvalidName() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->
//                RoleFactory.createRole("R2", "", 45000.00));
//        assertEquals("Role name is required", exception.getMessage());
//    }
//
//    @Test
//    void testCreateRoleWithInvalidSalary() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->
//                RoleFactory.createRole("R3", "Tester", -1000.00));
//        assertEquals("Role salary must be greater than zero", exception.getMessage());
//    }
//}
