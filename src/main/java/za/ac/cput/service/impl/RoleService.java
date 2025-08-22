package za.ac.cput.service.impl;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Role;
import  za.ac.cput.domain.User;
import za.ac.cput.repository.IRoleRepository;
import za.ac.cput.service.IRoleService;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    private final IRoleRepository repository;

    public RoleService(IRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role create(Role role) {
        return repository.save(role);
    }

    @Override
    public Role read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public Role update(Role role) {
        return repository.save(role);
    }

    @Override
    public boolean delete(String s) {
        if (repository.existsById(s)) {
            repository.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findByFirstName(String userFirstname) {
        // Not implemented, as IRoleRepository does not have this method
        return List.of();
    }

    @Override
    public List<Role> findByRoleId(String roleID) {
        Role role = repository.findById(roleID).orElse(null);
        return role != null ? List.of(role) : List.of();
    }

    @Override
    public List<Role> findByRoleName(String roleName) {
        Role role = repository.findByRoleName(roleName);
        return role != null ? List.of(role) : List.of();
    }

    @Override
    public List<Role> findByRoleSalary(double roleSalary) {
        return repository.findByRoleSalaryGreaterThan(roleSalary);
    }
}// end of file