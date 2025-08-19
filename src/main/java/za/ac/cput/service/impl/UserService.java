package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.IUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    // Create or update a user
    public User save(User user) {
        return userRepository.save(user);
    }

    // Read by ID
    public Optional<User> read(String userId) {
        return userRepository.findById(userId);
    }

    // Delete by ID
    public boolean delete(String userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    // Get all users
    public List<User> getAll() {
        return userRepository.findAll();
    }

    // Custom queries
    public Optional<User> getByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    public List<User> getByFirstName(String firstName) {
        return userRepository.findByUserFirstName(firstName);
    }

    public List<User> getByLastName(String lastName) {
        return userRepository.findByUserLastName(lastName);
    }

    public List<User> getByPhoneNumber(String phoneNumber) {
        return userRepository.findByUserPhoneNumber(phoneNumber);
    }
}
