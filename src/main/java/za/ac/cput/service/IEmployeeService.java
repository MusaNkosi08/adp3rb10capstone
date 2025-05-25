package za.ac.cput.service;

import za.ac.cput.domain.Employee;
import java.util.List;

public interface IEmployeeService {
    Employee create(Employee employee);
    Employee read(int id);
    List<Employee> readAll();
    Employee update(Employee employee);
    void delete(int id);
}
