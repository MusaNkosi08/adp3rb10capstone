package za.ac.cput.service;

import za.ac.cput.domain.Employee;
import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Employee create(Employee employee);
    Optional<Employee> read(Long id);
    Employee update(Employee employee);
    boolean delete(Long id);
    List<Employee> getAll();
}
