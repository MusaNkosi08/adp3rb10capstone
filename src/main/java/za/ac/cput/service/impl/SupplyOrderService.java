package za.ac.cput.service.impl;
/*
 SupplyOrderService.java
 Service class for SupplyOrder
 Author: [222791829]
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.SupplyOrder;
import za.ac.cput.repository.ISupplyOrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyOrderService {

    @Autowired
    private ISupplyOrderRepository supplyOrderRepository;

    // Create or update a supply order
    public SupplyOrder save(SupplyOrder order) {
        return supplyOrderRepository.save(order);
    }

    // Read by ID
    public Optional<SupplyOrder> read(String orderID) {
        return supplyOrderRepository.findById(orderID);
    }

    // Delete by ID
    public boolean delete(String orderID) {
        if (supplyOrderRepository.existsById(orderID)) {
            supplyOrderRepository.deleteById(orderID);
            return true;
        }
        return false;
    }

    // Get all supply orders
    public List<SupplyOrder> getAll() {
        return supplyOrderRepository.findAll();
    }

    // Custom queries
    public List<SupplyOrder> getByEmployeeID(String employeeID) {
        return supplyOrderRepository.findByEmployeeID(employeeID);
    }

    public List<SupplyOrder> getBySupplierID(String supplierID) {
        return supplyOrderRepository.findBySupplierID(supplierID);
    }

    public List<SupplyOrder> getByStatus(String status) {
        return supplyOrderRepository.findByOrderStatus(status);
    }

    // Business logic
    public boolean cancelOrder(String orderID) {
        Optional<SupplyOrder> optionalOrder = supplyOrderRepository.findById(orderID);
        if (optionalOrder.isPresent()) {
            SupplyOrder order = optionalOrder.get();
            order.cancelOrder();
            supplyOrderRepository.save(order);
            return true;
        }
        return false;
    }

    public String displayStatus(String orderID) {
        Optional<SupplyOrder> optionalOrder = supplyOrderRepository.findById(orderID);
        return optionalOrder.map(SupplyOrder::displayStatus).orElse("Order not found");
    }
}
