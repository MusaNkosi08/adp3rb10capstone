package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.IOrderRepository;
import za.ac.cput.service.IOrderService;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public List<Order> findByCustomerId(int customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Order> findByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public Order getOrder(int orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order read(Integer integer) {
        return orderRepository.findById(integer).orElse(null);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);

    }

    @Override
    public boolean delete(Integer id) {
        if (!this.orderRepository.existsById(id)) {
            return false;}
        else {
            this.orderRepository.deleteById(id);
            return true;
    }
    }

    public Order findLatestOrder(Long customerId) {
        return orderRepository.findLatestUserOrder(customerId);
    }


    @Override
    public List<Order> findAll() {
        return List.of();
    }
}
