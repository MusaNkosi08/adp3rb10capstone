package za.ac.cput.factory;

import za.ac.cput.domain.User;

public class UserFactory {
    public static User createUser(String userId, String userFirstName, String userLastName, String userEmail,
                                  String userPassword, String userPhoneNumber){
        return new User.UserBuilder(userId,userFirstName,userLastName,userEmail,userPassword,userPhoneNumber).build();
    }
}
