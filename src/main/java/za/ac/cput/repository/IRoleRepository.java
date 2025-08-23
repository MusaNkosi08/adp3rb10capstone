/*
 IRoleRepository.java
 Repository interface for Role
 Author: Aimee Paulus (222814969)
*/

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Role;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<Role, String> {

    // Custom queries
    Role findByRoleName(String roleName);
    List<Role> findByRoleSalaryGreaterThan(double salary);
    List<Role> findByRoleNameContaining(String keyword);
    List<Role> findByRoleSalaryBetween(double min, double max);
    long countByRoleSalaryGreaterThan(double salary);
}
