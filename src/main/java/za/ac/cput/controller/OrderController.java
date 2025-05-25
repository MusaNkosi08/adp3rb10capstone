package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.IOrderRepository;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private IOrderRepository orderRepository;

    @PostMapping("/create")
    public boolean createOrder(@RequestBody Order order) {
        return orderRepository.addOrder(order);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        return orderRepository.getOrder(orderId);
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable int customerId) {
        return orderRepository.getOrdersByCustomerId(customerId);
    }

    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable String status) {
        return orderRepository.findByStatus(status);
    }

    @PutMapping("/update")
    public boolean updateOrder(@RequestBody Order order) {
        return orderRepository.updateOrder(order);
    }

    @DeleteMapping("/delete/{orderId}")
    public boolean deleteOrder(@PathVariable int orderId) {
        return orderRepository.DeleteOrder(orderId);
    }
}
