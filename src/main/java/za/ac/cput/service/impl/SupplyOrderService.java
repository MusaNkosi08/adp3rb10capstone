/*
 EmployeeService.java
 Service class for Employee
 Author: Musa Banathi Nkosi (221744517)
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.SupplyOrder;
import za.ac.cput.repository.ISupplyOrderRepository;
import za.ac.cput.service.ISupplyOrderService;

import java.util.List;

@Service
public class SupplyOrderService implements ISupplyOrderService {

    private final ISupplyOrderRepository repository;

    public SupplyOrderService(ISupplyOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupplyOrder create(SupplyOrder order) {
        return repository.save(order);
    }

    @Override
    public SupplyOrder read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public SupplyOrder update(SupplyOrder order) {
        return repository.save(order);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<SupplyOrder> readAll() {
        return repository.findAll();
    }

    @Override
    public List<SupplyOrder> getAll() {
        return repository.findAll();
    }

    @Override
    public List<SupplyOrder> findByOrderStatus(String status) {
        return repository.findByOrderStatus(status);
    }

    @Override
    public List<SupplyOrder> findByEmployeeID(String employeeID) {
        return repository.findByEmployeeID(employeeID);
    }

    @Override
    public List<SupplyOrder> findBySupplierID(String supplierID) {
        return repository.findBySupplierID(supplierID);
    }

    @Override
    public List<SupplyOrder> findByOrderPriceBetween(double minPrice, double maxPrice) {
        // TODO: Implement this method when the repository supports it
        throw new UnsupportedOperationException("findByOrderPriceBetween not implemented yet");
    }
}