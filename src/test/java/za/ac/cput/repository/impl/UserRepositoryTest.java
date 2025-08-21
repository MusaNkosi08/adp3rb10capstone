//package za.ac.cput.repository.impl;
//
//
///* User.java
//``Author: Aimee Paulus (222814969)
//  Date: 28 March 2025
// */
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import za.ac.cput.domain.User;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//class UserRepositoryTest {
//    UserRepository repo1;
//
//    @BeforeEach
//    void setUp() {
//        repo1 = UserRepository.getInstance();
//    }
//
//    @Test
//    void u_Create() {
//        repo1.create(new User.UserBuilder("98567", "Aimee", "Paulus", "aimeepaulus@gmail.com", "password675", "0834569876").build());
//        assertNotNull(repo1.create(new User.UserBuilder("98567", "Aimee", "Paulus", "aimeepaulus@gmail.com", "password675", "0834569876").build()));
//    }
//
//    @Test
//    void updateExistingUser() {
//        User existingUser = new User.UserBuilder("98567", "Aimee", "Paulus", "aimeepaulus@gmail.com", "password675", "0834569876").build();
//        repo1.create(existingUser);
//
//        User updatedUser = new User.UserBuilder("98567", "Aimee", "Paulus", "aimeepaulus@gmail.com", "password675", "0834569876").build();
//
//        User result = repo1.update(updatedUser);
//        assertNotNull(result);
//        assertEquals("Aimee", result.getUserFirstName());
//        assertEquals("aimeepaulus@gmail.com", result.getUserEmail());
//    }
//
//
//    @Test
//    void updateOnNonExistingUser() {
//        repo1.create(new User.UserBuilder("98567", "Aimee", "Paulus", "aimeepaulus@gmail.com", "password675", "0834569876").build());
//        assertNotNull(repo1.update(new User.UserBuilder("98567", "Aimee", "Paulus", "aimeepaulus@gmail.com", "password675", "0834569876").build()));
//    }
//
//    @Test
//    void deleteExistingUser() {
//        User user = new User.UserBuilder("98567", "Aimee", "Paulus", "aimeepaulus@gmail.com", "password675", "0834569876").build();
//        repo1.create(user);
//
//        assertTrue(repo1.delete("98567"));
//        assertNull(repo1.read("98567"));
//    }
//
//    @Test
//    void deleteNonExistingUser() {
//        repo1.create(new User.UserBuilder("98567", "Aimee", "Paulus", "aimeepaulus@gmail.com", "password675", "0834569876").build());
//        assertTrue(repo1.delete("98567"));
//    }
//
//    @Test
//    void getNoUsers() {
//        assertTrue(repo1.findAll().isEmpty());
//    }
//
//
//
//
//}
