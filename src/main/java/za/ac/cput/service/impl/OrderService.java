package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.repository.IOrderRepository;
import za.ac.cput.service.IOrderService;

import java.util.List;

@Service("orderServiceImpl")
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public List<Order> findByUserId(Long userId) {
        return orderRepository.findByUser_UserId(userId);
    }

    @Override
    public List<Order> findByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public Order read(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }

    public Order addItemToOrder(Long orderId, OrderItem item) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.addItem(item); // calculateTotal() is called inside
        return orderRepository.save(order);
    }

    public Order removeItemFromOrder(Long orderId, OrderItem item) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.removeItem(item); // calculateTotal() is called inside
        return orderRepository.save(order);
    }

    public Order updateOrderItems(Long orderId, List<OrderItem> items) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.getItems().clear();
        order.getItems().addAll(items);
        order.calculateTotal(); // Call after updating items
        return orderRepository.save(order);
    }
}
