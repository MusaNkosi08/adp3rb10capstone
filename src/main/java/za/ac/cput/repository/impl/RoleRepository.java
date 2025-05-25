package za.ac.cput.repository.impl;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;
import za.ac.cput.repository.IRoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoleRepository implements IRoleRepository {

    private static RoleRepository repository = null;
    private final List<Role> roles;

    private RoleRepository() { roles = new ArrayList<Role>();
    }

    public static RoleRepository getInstance() {
        if (repository == null) {
            repository = new RoleRepository();
        }
        return repository;
    }


    @Override
    public Role save(Role role) {
        roles.removeIf(r -> r.getRoleId().equals(role.getRoleId()));
        roles.add(role);
        return role;
    }

    @Override
    public Role findById(String id) {
        return roles.stream()
                .filter(role -> role.getRoleId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Role> findAll() {
        return new ArrayList<>(roles);
    }

    @Override
    public void delete(String id) {
        roles.removeIf(role -> role.getRoleId().equals(id));
    }

    @Override
    public Role findByRoleName(String roleName) {
        return roles.stream()
                .filter(role -> role.getRoleName().equalsIgnoreCase(roleName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Role> findByRoleSalaryGreaterThan(double salary) {
        return roles.stream()
                .filter(role -> role.getRoleSalary() > salary)
                .collect(Collectors.toList());
    }

    @Override
    public List<Role> findByRoleNameContaining(String keyword) {
        return roles.stream()
                .filter(role -> role.getRoleName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Role> findRolesWithinSalaryRange(double min, double max) {
        return roles.stream()
                .filter(role -> role.getRoleSalary() >= min && role.getRoleSalary() <= max)
                .collect(Collectors.toList());
    }

    @Override
    public long countRolesWithSalaryAbove(double salary) {
        return roles.stream()
                .filter(role -> role.getRoleSalary() > salary)
                .count();
    }
}
