package za.ac.cput.repository;

import za.ac.cput.domain.Employee;

import java.util.List;

public interface IEmployeeRepository extends IRepository<Employee, Integer> {
    Employee save(Employee employee);

    List<Employee> findByLastName(String lastName);
    List<Employee> findByPosition(String position);
    List<Employee> findBySalaryRange(double minSalary, double maxSalary);
}