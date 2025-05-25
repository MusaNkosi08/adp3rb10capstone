package za.ac.cput.service;
/* UserService.java
``Author: Aimee Paulus (222814969)
  Date: 25 May 2025
 */

import za.ac.cput.domain.User;
import za.ac.cput.repository.IUserRepository;
import za.ac.cput.repository.impl.UserRepository;
import za.ac.cput.service.IUserService;

import java.util.List;

public class UserService implements IUserService{

    private static IUserService service;
    private static IUserRepository repository;

    private UserService(){
        repository = UserRepository.getInstance();// might need to change it to getRepository()
    }

    public static IUserService getService(){
        if(service == null){
            service = new UserService();
        }
        return service;
    }

    @Override
    public User create(User user) {
        return this.repository.create(user);
    }

    @Override
    public User read(String s) {
        return this.repository.read(s);
    }

    @Override
    public User update(User user) {
        return this.repository.update(user);
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<User> findById(String userId) {
        return List.of();
    }

    @Override
    public List<User> findByFirstName(String userFirstname) {
        return List.of();
    }

    @Override
    public List<User> findByLastName(String userLastname) {
        return List.of();
    }

    @Override
    public List<User> findByEmail(String userEmail) {
        return List.of();
    }

    @Override
    public List<User> findByPhoneNumber(String userPhoneNumber) {
        return List.of();
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }
}
