package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import za.ac.cput.domain.User;
import za.ac.cput.repository.IUserRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IUserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IUserRepository userRepository;

    private User createTestUser() {
        return new User.UserBuilder("98567", "Aimee", "Paulus",
                "aimeepaulus@gmail.com", "password675", "0834569876")
                .build();
    }

    @Test
    @Order(1)
    void testSaveUser() {
        User user = createTestUser();
        User savedUser = userRepository.save(user);

        assertNotNull(savedUser);
        assertEquals("98567", savedUser.getUserId());
        assertEquals("Aimee", savedUser.getUserFirstName());
    }

    @Test
    @Order(2)
    void testFindById() {
        User user = createTestUser();
        entityManager.persist(user);

        Optional<User> foundUser = userRepository.findById("98567");
        assertTrue(foundUser.isPresent());
        assertEquals("Paulus", foundUser.get().getUserLastName());
    }

    @Test
    @Order(3)
    void testFindByEmail() {
        User user = createTestUser();
        entityManager.persist(user);

        Optional<User> foundUser = userRepository.findByUserEmail("aimeepaulus@gmail.com");
        assertTrue(foundUser.isPresent());
        assertEquals("0834569876", foundUser.get().getUserPhoneNumber());
    }

    @Test
    @Order(4)
    void testFindByFirstName() {
        User user = createTestUser();
        entityManager.persist(user);

        List<User> users = userRepository.findByUserFirstName("Aimee");
        assertEquals(1, users.size());
        assertEquals("Paulus", users.get(0).getUserLastName());
    }

    @Test
    @Order(5)
    void testDeleteUser() {
        User user = createTestUser();
        entityManager.persist(user);

        userRepository.deleteById("98567");
        Optional<User> deletedUser = userRepository.findById("98567");
        assertFalse(deletedUser.isPresent());
    }
}