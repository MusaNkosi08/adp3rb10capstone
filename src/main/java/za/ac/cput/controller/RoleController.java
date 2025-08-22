/* RoleController.java
  Author: Aimee Paulus (222814969)
  Date: 25 May 2025
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Role;
import za.ac.cput.service.IRoleService;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @PostMapping("/create")
    public Role createRole(@RequestBody Role role) {
        return roleService.create(role);
    }

    @GetMapping("/{roleId}")
    public Role getRole(@PathVariable String roleId) {
        return roleService.read(roleId);
    }

    @GetMapping("/all")
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @PutMapping("/update")
    public Role updateRole(@RequestBody Role role) {
        return roleService.update(role);
    }


}