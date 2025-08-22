/*
 UserService.java
 Service class for User
 Author: Musa Banathi Nkosi (221744517)
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.IUserRepository;
import za.ac.cput.service.IUserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository; // Changed to userRepository to match PaymentService pattern

    // Create a new user
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User read(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    // Update a user
    @Override
    public User update(User user) {
        if (userRepository.existsById(user.getUserId())) { // Assuming getUserID() method exists
            return userRepository.save(user);
        }
        return null;
    }

    // Delete a user
    @Override
    public boolean delete(String userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    // Get all users
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Additional methods that match your repository capabilities
    public Optional<User> findByUserEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    public List<User> findByUserFirstName(String firstName) {
        return userRepository.findByUserFirstName(firstName);
    }

    public List<User> findByUserLastName(String lastName) {
        return userRepository.findByUserLastName(lastName);
    }

    public List<User> findByUserPhoneNumber(String phoneNumber) {
        return userRepository.findByUserPhoneNumber(phoneNumber);
    }
}