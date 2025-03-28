package za.ac.cput.repository.impl;

/* User.java
``Author: Aimee Paulus (222814969)
  Date: 23 March 2025
 */

import za.ac.cput.domain.User;
import za.ac.cput.repository.IUserRepository;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    private static UserRepository repository = null;
    private final List<User> userList;

    private UserRepository() {
        userList = new ArrayList<User>();
    }

    public static UserRepository getInstance() {
        if (repository == null) {
            repository = new UserRepository();
        }
        return repository;
    }

    @Override
    public User create(User user) {
        boolean success = userList.add(user);
        if (success) {
            return user;
        }
        return null;
    }


    @Override
    public User read(String id) {
        for (User user : userList) {
            if (user.getUserId().equals(id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User update(User user) {
        String userId = user.getUserId(); // Get the user's ID
        User existingUser = read(userId); // Find the existing employee

        if (existingUser != null) {

            // Create a new User with updated values using the Builder pattern
            User updatedUser= new User.UserBuilder(user.getUserId(),
                    user.getUserFirstName(),
                    user.getUserLastName(),
                    user.getUserEmail(),
                    user.getUserPassword(),
                    user.getUserPhoneNumber())
                    .build();

            // Remove the old user and add the updated one
            userList.remove(existingUser);
            userList.add(updatedUser);
            return updatedUser; // Return the updated user
        }
        return null; // Return null if the user to update is not found
    }


    @Override
    public boolean delete(String id) {
        User userToDelete = read(id); // find the user to delete

        if(userToDelete != null){
            userList.remove(userToDelete); // remove the user
            return true; //return true if deletion is sucessful
        }
        return false; // return false if user isn't found
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

}
