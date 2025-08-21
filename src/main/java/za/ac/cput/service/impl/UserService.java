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
import za.ac.cput.domain.Supplier;
import za.ac.cput.repository.IEmployeeRepository;
import za.ac.cput.repository.ISupplierRepository;
import za.ac.cput.service.IBookService;
import za.ac.cput.service.IEmployeeService;
import za.ac.cput.service.ISupplierService;

import java.util.List;

@Service
public class UserService implements ISupplierService {


    @Autowired
    private static ISupplierService service;
    @Autowired
    private static ISupplierRepository repository;


    public static ISupplierService getService() {
        if (service == null) {

            return service;
        }

        return service;
    }

    @Override
    public Supplier create (Supplier supplier) {
        return this.repository.save(supplier);
    }

    @Override
    public Supplier read (Long id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Supplier update (Supplier supplier){
        return this.repository.save(supplier);
    }

    @Override
    public boolean delete (Long id){
        if (!this.repository.existsById(id)) {
            return false;}
        else {
            this.repository.deleteById(id);
            return true;
        }
    }
    @Override
    public List<Supplier> findAll () {
        return this.repository.findAll();
    }
}