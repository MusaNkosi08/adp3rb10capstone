package za.ac.cput.service;

import za.ac.cput.domain.Employee;
import java.util.List;
import java.util.Optional;

public interface IEmployeeService extends IService<Employee, Long> {

    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);
    List<Employee> findByEmail(String email);
    List<Employee> findByPosition(String position);
    List<Employee> findBySalaryGreaterThan(double salary);
    List<Employee> findBySalaryLessThan(double salary);

}
