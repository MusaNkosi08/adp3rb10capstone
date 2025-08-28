package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.IEmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.read(id);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable Long id) {
        return employeeService.delete(id);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }
/*
    @GetMapping("/firstname/{firstName}")
    public List<Employee> getEmployeesByFirstName(@PathVariable String firstName) {
        return employeeService.findByFirstName(firstName);
    }

    @GetMapping("/lastname/{lastName}")
    public List<Employee> getEmployeesByLastName(@PathVariable String lastName) {
        return employeeService.findByLastName(lastName);
    }

    @GetMapping("/email/{email}")
    public List<Employee> getEmployeesByEmail(@PathVariable String email) {
        return employeeService.findByEmail(email);
    }

    @GetMapping("/position/{position}")
    public List<Employee> getEmployeesByPosition(@PathVariable String position) {
        return employeeService.findByPosition(position);
    }

    @GetMapping("/salary/greater-than/{salary}")
    public List<Employee> getEmployeesBySalaryGreaterThan(@PathVariable double salary) {
        return employeeService.findBySalaryGreaterThan(salary);
    }

    @GetMapping("/salary/less-than/{salary}")
    public List<Employee> getEmployeesBySalaryLessThan(@PathVariable double salary) {
        return employeeService.findBySalaryLessThan(salary);
    }
*/
}