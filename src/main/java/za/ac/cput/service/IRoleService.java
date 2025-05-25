package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;

import java.util.List;


public interface IRoleService extends IService<Role,String>{
    List<User> findByFirstName(String userFirstname);
    List<Role> findByRoleId(String roleID);
    List<Role> findByRoleName(String roleName);
    List<Role> findByRoleSalary(double roleSalary);

}// end of file

