package za.ac.cput.factory;

/* User.java
``Author: Aimee Paulus (222814969)
  Date: 21 March 2025
 */

import za.ac.cput.domain.User;

public class UserFactory {
    public static User createUser(int userId, String userFirstName, String userLastName, String userEmail,
                                  String userPassword, String userPhoneNumber){
        return new User.UserBuilder(userId,userFirstName,userLastName,userEmail,userPassword,userPhoneNumber).build();
    }
}
