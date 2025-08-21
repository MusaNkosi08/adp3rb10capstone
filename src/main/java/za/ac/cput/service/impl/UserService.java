/*
 EmployeeService.java
 Service class for Employee
 Author: Musa Banathi Nkosi (221744517)
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.IUserRepository;
import za.ac.cput.service.ISupplierService;
import za.ac.cput.service.IUserService;

import java.util.List;

@Service
public class UserService implements IUserService {


    @Autowired
    private static IUserService service;
    @Autowired
    private static IUserRepository repository;


    public static IUserService getService() {
        if (service == null) {

            return service;
        }

        return service;
    }

    @Override
    public User create (User user) {
        return this.repository.save(user);
    }

    @Override
    public User read (String id){
        return this.repository.findById(String.valueOf(id)).orElse(null);
    }

    @Override
    public User update (User user){
        return this.repository.save(user);
    }

    @Override
    public boolean delete (String id){
        if (!this.repository.existsById(String.valueOf(id))) {
            return false;}
        else {
            this.repository.deleteById(String.valueOf(id));
            return true;
        }
    }
    @Override
    public List<User> findAll () {
        return this.repository.findAll();
    }
}