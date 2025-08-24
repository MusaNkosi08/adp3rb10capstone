package za.ac.cput.factory;

import za.ac.cput.domain.User;

/* UserFactory.java
 Author: Aimee Paulus (222814969)
 Date: 21 March 2025
*/
/*
 UserFactory.java
 Test class for UserService
 Author: Aimee Paulus (222814969
*/

public class UserFactory {

    public static User createUser(String userId, String userFirstName, String userLastName, String userEmail,
                                  String userPassword, String userPhoneNumber) {

        // Basic validation like PaymentFactory
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        if (userFirstName == null || userFirstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (userLastName == null || userLastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        if (userEmail == null || userEmail.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (userPassword == null || userPassword.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (userPhoneNumber == null || userPhoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }

        return new User.UserBuilder(userId, userFirstName, userLastName, userEmail, userPassword, userPhoneNumber)
                .build();
    }
}