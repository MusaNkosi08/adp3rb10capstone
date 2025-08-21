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


    @Autowired
    private static ISupplyOrderService service;
    @Autowired
    private static ISupplyOrderRepository repository;


    public static ISupplyOrderService getService() {
        if (service == null) {

            return service;
        }

        return service;
    }

    @Override
    public SupplyOrder create (SupplyOrder order) {
        return this.repository.save(order);
    }

    @Override
    public SupplyOrder read (String id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public SupplyOrder update (SupplyOrder order){
        return this.repository.save(order);
    }

    @Override
    public boolean delete (String id){
        if (!this.repository.existsById(id)) {
            return false;}
        else {
            this.repository.deleteById(id);
            return true;
        }
    }
    @Override
    public List<SupplyOrder> findAll () {
        return this.repository.findAll();
    }
}