package za.ac.cput.repository.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.ac.cput.domain.Role;
import za.ac.cput.repository.impl.RoleRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RoleRepositoryTest {

    @Autowired
    private RoleRepository repository;

    @Test
    void testSaveAndFindRole() {
        Role role = new Role.RoleBuilder("R1", "Software Engineer", 55000.00).build();
        repository.save(role);

        Optional<Role> savedRole = repository.findById("R1");

        assertTrue(savedRole.isPresent());
        assertEquals("Software Engineer", savedRole.get().getRoleName());
        assertEquals(55000.00, savedRole.get().getRoleSalary());
    }

    @Test
    void testDeleteRole() {
        Role role = new Role.RoleBuilder("R2", "Manager", 75000.00).build();
        repository.save(role);

        repository.deleteById("R2");
        Optional<Role> deletedRole = repository.findById("R2");

        assertFalse(deletedRole.isPresent());
    }

    @Test
    void testUpdateRole() {
        Role role = new Role.RoleBuilder("R3", "Tester", 40000.00).build();
        repository.save(role);

        Role updatedRole = new Role.RoleBuilder("R3", "QA Tester", 42000.00).build();
        repository.save(updatedRole);

        Optional<Role> result = repository.findById("R3");

        assertTrue(result.isPresent());
        assertEquals("QA Tester", result.get().getRoleName());
        assertEquals(42000.00, result.get().getRoleSalary());
    }
}