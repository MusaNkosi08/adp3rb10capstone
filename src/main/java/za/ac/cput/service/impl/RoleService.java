package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Role;
import za.ac.cput.repository.IRoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private IRoleRepository roleRepository;

    // Create or update a role
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    // Read role by ID
    public Optional<Role> read(String roleId) {
        return roleRepository.findById(roleId);
    }

    // Delete role
    public boolean delete(String roleId) {
        if (roleRepository.existsById(roleId)) {
            roleRepository.deleteById(roleId);
            return true;
        }
        return false;
    }

    // Get all roles
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    // Custom queries
    public Role getByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    public List<Role> getRolesWithSalaryGreaterThan(double salary) {
        return roleRepository.findByRoleSalaryGreaterThan(salary);
    }

    public List<Role> getRolesByKeyword(String keyword) {
        return roleRepository.findByRoleNameContaining(keyword);
    }

    public List<Role> getRolesWithinSalaryRange(double min, double max) {
        return roleRepository.findRolesWithinSalaryRange(min, max);
    }

    public long countRolesWithSalaryAbove(double salary) {
        return roleRepository.countRolesWithSalaryAbove(salary);
    }
}
