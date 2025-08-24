package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;



import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {

   @Autowired
    private UserService userService;



    private static User user1;
    private static User user2;
    private static final String testEmail = "aimeepaulus@gmail.com";
    private static final String testFirstName = "Aimee";
    private static final String testLastName = "Paulus";
    private static final String testPhoneNumber = "087456978";
    private static final String testPassword = "aim123";

    @BeforeAll
    static void setUp() {
        user1 = UserFactory.createUser(
                "USR001",
                testFirstName,
                "Paulus",
                testEmail,
                testPassword,
                testPhoneNumber
        );

        user2 = UserFactory.createUser(
                "USR002",
                "Ameena",
                "Peterson",
                "ameenapeterson.com",
                "amee987",
                "0987654321"
        );
    }

    @Test
    @Order(1)
    void testCreate() {
        User createdUser1 = userService.create(user1);
        assertNotNull(createdUser1);
        assertEquals(user1.getUserId(), createdUser1.getUserId());

        User createdUser2 = userService.create(user2);
        assertNotNull(createdUser2);
        assertEquals(user2.getUserId(), createdUser2.getUserId());
    }

    @Test
    @Order(2)
    void testRead() {
        User foundUser = userService.read(user1.getUserId());
        assertNotNull(foundUser);
        assertEquals(user1.getUserId(), foundUser.getUserId());
        assertEquals(testEmail, foundUser.getUserEmail());
    }

    @Test
    @Order(3)
    void testUpdate() {
        User userToUpdate = userService.read(user1.getUserId());
        assertNotNull(userToUpdate);

        // Create new user with updated data
        User updatedUserData = UserFactory.createUser(
                user1.getUserId(),
                "Sam", // Updated first name
                userToUpdate.getUserLastName(),
                userToUpdate.getUserEmail(),
                userToUpdate.getUserPassword(),
                userToUpdate.getUserPhoneNumber()
        );

        User updatedUser = userService.update(updatedUserData);
        assertNotNull(updatedUser);
        assertEquals("Sam", updatedUser.getUserFirstName());
        assertEquals(user1.getUserId(), updatedUser.getUserId());
    }

    @Test
    @Order(4)
    void testFindAll() {
        List<User> users = userService.findAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    @Order(5)
    void testFindByUserEmail() {
        Optional<User> foundUser = userService.findByUserEmail(testEmail);
        assertTrue(foundUser.isPresent());
        assertEquals(testEmail, foundUser.get().getUserEmail());
    }

    @Test
    @Order(6)
    void testFindByUserFirstName() {
        List<User> users = userService.findByUserFirstName(testFirstName);
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    @Order(7)
    void testFindByUserLastName() {
        List<User> users = userService.findByUserLastName(testLastName);
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    @Order(8)
    void testFindByUserPhoneNumber() {
        List<User> users = userService.findByUserPhoneNumber(testPhoneNumber);
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    @Order(9)
    void testDelete() {
        boolean deleteResult = userService.delete(user1.getUserId());
        assertTrue(deleteResult);

        User deletedUser = userService.read(user1.getUserId());
        assertNull(deletedUser);
    }

}