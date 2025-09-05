package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.domain.Contact;
import za.ac.cput.service.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserContactDTO dto) {
        Contact contact = dto.toContact();
        String role = (dto.role == null || dto.role.trim().isEmpty()) ? "CUSTOMER" : dto.role;

        User user = new User.UserBuilder()
                .setUserId(dto.userId)
                .setUserFirstName(dto.userFirstName)
                .setUserLastName(dto.userLastName)
                .setRole(role)
                .setContact(contact)
                .build();

        return ResponseEntity.ok(userService.create(user));
    }

   
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        User user = userService.read(userId);
        return (user != null) ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

   
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

   
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody UserContactDTO dto) {
        Contact contact = dto.toContact();
        User user = new User.UserBuilder()
                .setUserId(dto.userId)
                .setUserFirstName(dto.userFirstName)
                .setUserLastName(dto.userLastName)
                .setRole(dto.role)
                .setContact(contact)
                .build();

        return ResponseEntity.ok(userService.update(user));
    }

    
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO) {
        User user = userService.login(loginDTO.email, loginDTO.password);
        return (user != null) ? ResponseEntity.ok(user) : ResponseEntity.status(401).build();
    }

    
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        boolean deleted = userService.delete(userId);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
