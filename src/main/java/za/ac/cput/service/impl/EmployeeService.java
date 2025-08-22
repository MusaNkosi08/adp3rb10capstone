/*
 EmployeeService.java
 Service class for Employee
 Author: Musa Banathi Nkosi (221744517)
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.IEmployeeRepository;
import za.ac.cput.service.IBookService;
import za.ac.cput.service.IEmployeeService;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {


    @Autowired
    private static IEmployeeService service;
    @Autowired
    private static IEmployeeRepository repository;


    public static IEmployeeService getService() {
        if (service == null) {

            return service;
        }

        return service;
    }

    @Override
    public Employee create (Employee book){
        return this.repository.save(book);
    }

    @Override
    public Employee read (Long id){
        return this.repository.findById(Math.toIntExact(id)).orElse(null);
    }

    @Override
    public Employee update (Employee employee){
        return this.repository.save(employee);
    }

    @Override
    public boolean delete (Long id){
        if (!this.repository.existsById(Math.toIntExact(id))) {
            return false;}
        else {
            this.repository.deleteById(Math.toIntExact(id));
            return true;
        }
    }
    @Override
    public List<Employee> findAll () {
        return this.repository.findAll();
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        return this.repository.findByFirstName(firstName);
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return this.repository.findByLastName(lastName);
    }

    @Override
    public List<Employee> findByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    @Override
    public List<Employee> findByPosition(String position) {
        return this.repository.findByPosition(position);
    }

    @Override
    public List<Employee> findBySalaryGreaterThan(double salary) {
        return this.repository.findBySalaryGreaterThan(salary);
    }

    @Override
    public List<Employee> findBySalaryLessThan(double salary) {
        return this.repository.findBySalaryLessThan(salary);
    }

}