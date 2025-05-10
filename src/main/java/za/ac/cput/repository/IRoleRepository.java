package za.ac.cput.repository;

import za.ac.cput.domain.Role;
import java.util.List;

public interface IRoleRepository {
    Role save(Role role);
    Role findById(String id);
    List<Role> findAll();
    void delete(String id);

    // Custom queries
    Role findByRoleName(String roleName);
    List<Role> findByRoleSalaryGreaterThan(double salary);
    List<Role> findByRoleNameContaining(String keyword);
    List<Role> findRolesWithinSalaryRange(double min, double max);
    long countRolesWithSalaryAbove(double salary);
}
