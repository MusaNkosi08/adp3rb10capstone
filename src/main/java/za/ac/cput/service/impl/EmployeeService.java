/*
 EmployeeService.java
 Service class for Employee
 Author: Musa Banathi Nkosi (221744517)
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.IEmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    // Create
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Read
    public Optional<Employee> read(int employeeID) {
        return employeeRepository.findById(employeeID);
    }

    // Update
    public Employee update(Employee employee) {
        if (employeeRepository.existsById(employee.getEmployeeID())) {
            return employeeRepository.save(employee);
        }
        return null;
    }

    // Delete
    public boolean delete(int employeeID) {
        if (employeeRepository.existsById(employeeID)) {
            employeeRepository.deleteById(employeeID);
            return true;
        }
        return false;
    }

    // Get all
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    // 🔍 Custom query methods
    public List<Employee> getByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    public List<Employee> getByPosition(String position) {
        return employeeRepository.findByPosition(position);
    }

    public List<Employee> getBySalaryRange(double min, double max) {
        return employeeRepository.findBySalaryBetween(min, max);
    }

    // Business logic: Promote employee
    public boolean promoteEmployee(int employeeID, String newPosition, double salaryIncrease) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeID);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.promote(newPosition, salaryIncrease);
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }
}
