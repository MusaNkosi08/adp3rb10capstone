//package za.ac.cput.domain;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class RoleTest {
//
//    @Test
//    void testRoleBuilderAndGetters() {
//        Role role = new Role.RoleBuilder("R1", "Software Engineer", 55000.00).build();
//
//        assertNotNull(role);
//        assertEquals("R1", role.getRoleId());
//        assertEquals("Software Engineer", role.getRoleName());
//        assertEquals(55000.00, role.getRoleSalary());
//    }
//
//    @Test
//    void testRoleToString() {
//        Role role = new Role.RoleBuilder("R2", "Manager", 75000.00).build();
//
//        String roleString = role.toString();
//
//        assertTrue(roleString.contains("R2"));
//        assertTrue(roleString.contains("Manager"));
//        assertTrue(roleString.contains("75000.0"));
//    }
//
//    @Test
//    void testRoleEquality() {
//        Role role1 = new Role.RoleBuilder("R3", "Tester", 40000.00).build();
//        Role role2 = new Role.RoleBuilder("R3", "Tester", 40000.00).build();
//
//        // Not the same object, but field values are equal
//        assertEquals(role1.getRoleId(), role2.getRoleId());
//        assertEquals(role1.getRoleName(), role2.getRoleName());
//        assertEquals(role1.getRoleSalary(), role2.getRoleSalary());
//    }
//}
