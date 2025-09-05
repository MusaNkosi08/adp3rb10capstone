package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.User;

public class UserFactory {

    public static User createUser(Long userId,
                                  String userFirstName,
                                  String userLastName,
                                  String role,
                                  String userEmail,
                                  String userPassword,
                                  String userPhoneNumber,
                                  Contact contact) {

        // Basic validation
        if (userId == null) throw new IllegalArgumentException("User ID is required");
        if (userFirstName == null || userFirstName.isEmpty()) throw new IllegalArgumentException("First name is required");
        if (userLastName == null || userLastName.isEmpty()) throw new IllegalArgumentException("Last name is required");
        if (role == null || role.isEmpty()) throw new IllegalArgumentException("Role is required");
        if (userEmail == null || userEmail.isEmpty()) throw new IllegalArgumentException("Email is required");
        if (userPassword == null || userPassword.isEmpty()) throw new IllegalArgumentException("Password is required");
        if (userPhoneNumber == null || userPhoneNumber.isEmpty()) throw new IllegalArgumentException("Phone number is required");
        if (contact == null) throw new IllegalArgumentException("Contact is required");

        return new User.UserBuilder()
                .setUserId(userId)
                .setUserFirstName(userFirstName)
                .setUserLastName(userLastName)
                .setRole(role)
                .setUserEmail(userEmail)
                .setUserPassword(userPassword)
                .setUserPhoneNumber(userPhoneNumber)
                .setContact(contact)
                .build();
    }
}
