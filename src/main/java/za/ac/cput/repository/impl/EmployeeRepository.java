package za.ac.cput.repository.impl;

import za.ac.cput.domain.Employee;
import za.ac.cput.repository.IEmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final List<Employee> employeeList;

    // Constructor to initialize the list
    public EmployeeRepository() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee save(Employee employee) {
        if (employee == null) return null;
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee create(Employee employee) {
        return null;
    }

    @Override
    public Employee read(Integer employeeID) {
        for (Employee emp : employeeList) {
            if (emp.getEmployeeID() == employeeID) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    @Override
    public boolean delete(Integer employeeID) {
        Employee employee = read(employeeID);
        if (employee != null) {
            employeeList.remove(employee);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getLastName().equalsIgnoreCase(lastName)) {
                result.add(emp);
            }
        }
        return result;
    }

    @Override
    public List<Employee> findByPosition(String position) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getPosition().equalsIgnoreCase(position)) {
                result.add(emp);
            }
        }
        return result;
    }

    @Override
    public List<Employee> findBySalaryRange(double minSalary, double maxSalary) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getSalary() >= minSalary && emp.getSalary() <= maxSalary) {
                result.add(emp);
            }
        }
        return result;
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employeeList);
    }
}