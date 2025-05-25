/*
IEmployeeRepository.java
Author: Musa Banathi Nkosi (221744517)
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    // Saves an Employee entity to the repository
    Employee save(Employee employee);

    // Creates an Employee (not yet implemented)
    Employee create(Employee employee);

    // Reads an Employee by ID
    Employee read(Integer employeeID);

    // Updates an Employee (not yet implemented)
    Employee update(Employee employee);

    // Deletes an Employee by ID
    boolean delete(Integer employeeID);

    // Finds employees by their last name
    List<Employee> findByLastName(String lastName);

    // Finds employees by their job position
    List<Employee> findByPosition(String position);

    // Finds employees within a specified salary range
    List<Employee> findBySalaryRange(double minSalary, double maxSalary);
}
