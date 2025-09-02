/* UserController.java
``Author: Aimee Paulus (222814969)
  Date: 25 May 2025
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.repository.IUserRepository;
import za.ac.cput.service.impl.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userRepository;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userRepository.create(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        return userRepository.read(userId);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userRepository.create(user);
    }

    @GetMapping("/login/{email}/{password}")
    public User loginUser(@PathVariable String email, @PathVariable String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
    @DeleteMapping("/delete/{userId}")
    public boolean deleteUser(@PathVariable String userId) {
       return userRepository.delete(userId);
    }
}
