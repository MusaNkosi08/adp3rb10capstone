package za.ac.cput.service.impl;/*
 OrderItemService.java
 Service class for OrderItem
 Author: [Your Name] ([Your Student Number])
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.repository.IOrderItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private IOrderItemRepository orderItemRepository;

    // Create
    public OrderItem create(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    // Read
    public Optional<OrderItem> read(int itemId) {
        return orderItemRepository.findById(itemId);
    }

    // Update
    public OrderItem update(OrderItem orderItem) {
        if (orderItemRepository.existsById(orderItem.getItemId())) {
            return orderItemRepository.save(orderItem);
        }
        return null;
    }

    // Delete
    public boolean delete(int itemId) {
        if (orderItemRepository.existsById(itemId)) {
            orderItemRepository.deleteById(itemId);
            return true;
        }
        return false;
    }

    // Get all
    public List<OrderItem> getAll() {
        return orderItemRepository.findAll();
    }

    // Business logic: calculate total cost of an order item
    public double calculateTotalPrice(int itemId) {
        Optional<OrderItem> orderItemOpt = orderItemRepository.findById(itemId);
        if (orderItemOpt.isPresent()) {
            OrderItem item = orderItemOpt.get();
            return item.getQuantity() * item.getPrice();
        }
        return 0.0;
    }
}
