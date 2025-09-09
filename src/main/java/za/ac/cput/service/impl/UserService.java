/*
 UserService.java
 Service class for User
 Author: Musa Banathi Nkosi (221744517)
*/

package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.User;
import za.ac.cput.repository.IUserRepository;
import za.ac.cput.service.IContactService;
import za.ac.cput.service.IUserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final IUserRepository repository;
    private final IContactService contactService;

    public UserService(IUserRepository repository, IContactService contactService) {
        this.repository = repository;
        this.contactService = contactService;
    }

    @Override
    public User create(User user) {
        Contact contact = user.getContact();
        if (contact != null) {
            contact = contactService.create(contact);
            user = new User.UserBuilder()
                    .setUserId(user.getUserId())
                    .setUserFirstName(user.getUserFirstName())
                    .setUserLastName(user.getUserLastName())
                    .setRole(user.getRole())
                    .setContact(contact)
                    .build();
        }
        return repository.save(user);
    }

    @Override
    public User read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        Contact contact = user.getContact();
        if (contact != null) {
            if (contact.getContactId() != null) {
                contact = contactService.update(contact);
            } else {
                contact = contactService.create(contact);
            }
            user = new User.UserBuilder()
                    .setUserId(user.getUserId())
                    .setUserFirstName(user.getUserFirstName())
                    .setUserLastName(user.getUserLastName())
                    .setRole(user.getRole())
                    .setContact(contact)
                    .build();
        }
        return repository.save(user);
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    /**
     * Login by checking Contact details
     */
    @Override
    public User login(String email, String password) {
        Optional<User> optionalUser = repository.findByContactEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Contact contact = user.getContact();
            if (contact != null && password.equals(contact.getPassword())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Login using repository native query
     */

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password).orElse(null);
    }

    @Override
    public List<User> findByPhoneNumber(String userPhoneNumber) {
        return repository.findByContactPhoneNumber(userPhoneNumber);
    }

    @Override
    public User findById(Long userId) {
        return (User) repository.findAll().stream()
                .filter(u -> u.getUserId().equals(userId))
                .toList();
    }

    @Override
    public List<User> findByFirstName(String userFirstname) {
        return repository.findByUserFirstName(userFirstname);
    }

    @Override
    public List<User> findByLastName(String userLastname) {
        return repository.findByUserLastName(userLastname);
    }

    @Override
    public List<User> findByEmail(String userEmail) {
        Optional<User> user = repository.findByContactEmail(userEmail);
        return user.map(List::of).orElse(List.of());
    }
}
