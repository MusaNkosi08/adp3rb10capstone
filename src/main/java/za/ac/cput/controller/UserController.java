/* UserController.java
``Author: Aimee Paulus (222814969)
  Date: 25 May 2025
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.repository.IUserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/create")
    public boolean createUser(@RequestBody User user) {
        return userRepository.create(user) != null;
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
    public boolean updateUser(@RequestBody User user) {
        return userRepository.update(user) != null;
    }

    @DeleteMapping("/delete/{userId}")
    public boolean deleteUser(@PathVariable String userId) {
        userRepository.delete(userId);
        return true;
    }
}
