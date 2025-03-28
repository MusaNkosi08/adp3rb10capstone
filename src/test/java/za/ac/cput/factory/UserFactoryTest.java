package za.ac.cput.factory;


/* User.java
``Author: Aimee Paulus (222814969)
  Date: 28 March 2025
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserFactoryTest {

    @Test
    void createUserSuccess() {
        User user = UserFactory.createUser(
                "12345",
                "John",
                "Doe",
                "john.doe@example.com",
                "SecurePass123!",
                "0831234567");

        assertNotNull(user);
        assertEquals("12345", user.getUserId());
        assertEquals("John", user.getUserFirstName());
        assertEquals("Doe", user.getUserLastName());
        assertEquals("john.doe@example.com", user.getUserEmail());
        assertEquals("SecurePass123!", user.getUserPassword());
        assertEquals("0831234567", user.getUserPhoneNumber());
    }


}
