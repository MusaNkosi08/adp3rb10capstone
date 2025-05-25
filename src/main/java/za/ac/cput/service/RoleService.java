package za.ac.cput.service;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Role;
import  za.ac.cput.domain.User;
import za.ac.cput.repository.IRoleRepository;
import za.ac.cput.repository.impl.RoleRepository;
import java.util.List;

@Service
public class RoleService implements IRoleService{

    private static IRoleService service;
    private static IRoleRepository repository;

    private RoleService(){
        repository = RoleRepository.getInstance();// might need to change it to getRepository()
    }

    public static IRoleService getService(){
        if(service == null){
            service = new RoleService();
        }
        return service;
    }

    @Override
    public Role create(Role role) {
        return this.repository.save(role); // Correct method call
    }

    @Override
    public Role read(String s) {
        return this.repository.findById(s); // Correct method call
    }

    @Override
    public Role update(Role role) {
        return this.repository.save(role); // Use save for update
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<Role> findAll() {
        return List.of();
    }

    @Override
    public List<User> findByFirstName(String userFirstname) {
        return List.of();
    }

    @Override
    public List<Role> findByRoleId(String roleID) {
        return List.of(this.repository.findById(roleID));
    }

    @Override
    public List<Role> findByRoleName(String roleName) {
        return List.of(this.repository.findByRoleName(roleName));
    }

    @Override
    public List<Role> findByRoleSalary(double roleSalary) {
        return this.repository.findByRoleSalaryGreaterThan(roleSalary);
    }
}// end of file
