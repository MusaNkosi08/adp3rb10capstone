/*
IEmployeeRepository.java
Author: Musa Banathi Nkosi (221744517)
*/

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.SupplyOrder;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    // Custom query methods
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);
    List<Employee> findByEmail(String email);
    List<Employee> findByPosition(String position);
    List<Employee> findBySalaryGreaterThan(double salary);
    List<Employee> findBySalaryLessThan(double salary);


    @Repository
    interface SupplyOrderRepository extends JpaRepository<SupplyOrder, String> {
        // Custom queries can go here if needed
    }
}
