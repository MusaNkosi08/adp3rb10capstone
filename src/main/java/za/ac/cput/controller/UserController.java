/* UserController.java
``Author: Aimee Paulus (222814969)
  Date: 25 May 2025
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.service.impl.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return service.create(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        return service.read(userId);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return service.create(user);
    }

    @GetMapping("/login/{email}/{password}")
    public User loginUser(@PathVariable String email, @PathVariable String password) {
        System.out.println("email: " + email);
        System.out.println("email: " + password);
        return service.findByEmailAndPassword(email, password);
    }
    @DeleteMapping("/delete/{userId}")
    public boolean deleteUser(@PathVariable String userId) {
       return service.delete(userId);
    }
}
