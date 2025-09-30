package za.ac.cput.factory;

/* User.java
``Author: Aimee Paulus (222814969)
  Date: 21 March 2025
 */

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.User;

public class UserFactory {
    public static User createUser(Long userId, String userFirstName, String userLastName, String role, Contact contact) {
        if (userId == null) throw new IllegalArgumentException("User ID required");
        if (userFirstName == null || userFirstName.isEmpty()) throw new IllegalArgumentException("First name required");
        if (userLastName == null || userLastName.isEmpty()) throw new IllegalArgumentException("Last name required");
        if (role == null || role.isEmpty()) throw new IllegalArgumentException("Role required");
        if (contact == null) throw new IllegalArgumentException("Contact required");
        return new User.UserBuilder()
                .setUserId(userId)
                .setUserFirstName(userFirstName)
                .setUserLastName(userLastName)
                .setRole(role)
                .setContact(contact)
                .build();
    }
}
