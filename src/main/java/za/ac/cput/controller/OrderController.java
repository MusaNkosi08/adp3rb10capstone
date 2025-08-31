package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.IOrderRepository;
import za.ac.cput.service.impl.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {


    private OrderService service;
@Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return service.create(order);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        return service.read(orderId);
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable int customerId) {
        return service.findByCustomerId(customerId);
    }

    public Order getLatestOrder (@PathVariable Long customerId) {
        return service.findLatestOrder( customerId );
    }
    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable String status) {
        return service.findByStatus(status);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order) {
        return service.create(order);
    }

    @DeleteMapping("/delete/{orderId}")
    public boolean deleteOrder(@PathVariable int orderId) {
        return service.delete(orderId);
    }
}
