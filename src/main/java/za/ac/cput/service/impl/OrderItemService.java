package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.repository.IOrderItemRepository;
import za.ac.cput.service.IOrderItemService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService implements IOrderItemService {

    @Autowired
    private IOrderItemRepository orderItemRepository;

    @Override
    public double calculateTotalPrice(int itemId) {
        return 0;
    }

    @Override
    public OrderItem create(OrderItem orderItem) {
        return null;
    }

    @Override
    public OrderItem read(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (orderItemRepository.existsById(id)) {
            orderItemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<OrderItem> findAll() {
        return List.of();
    }
}