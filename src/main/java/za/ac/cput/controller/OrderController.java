package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.User;
import za.ac.cput.repository.IOrderRepository;
import za.ac.cput.repository.IPaymentRepository;
import za.ac.cput.repository.IUserRepository;
import za.ac.cput.service.impl.OrderService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IPaymentRepository paymentRepository;

    @Autowired
    private IUserRepository userRepository;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order, @RequestParam Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found for id: " + userId);
        }

        Payment payment = paymentRepository.findTopByOrderByPaymentId();
        if (payment == null) {
            throw new IllegalArgumentException("No payments found");
        }
        order.setID(null);
        order.setUser(user);

        order.setPayment(payment);
        order.setTotalAmount(payment.getAmount());
        order.setTimestamp(LocalDateTime.now());
        order.setStatus("pending");

        return orderRepository.save(order);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable Long customerId) {
        return orderRepository.findByUser_UserId(customerId);
    }

    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable String status) {
        return orderRepository.findByStatus(status);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @DeleteMapping("/delete/{orderId}")
    public boolean deleteOrder(@PathVariable Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }

    @PostMapping("/{orderId}/items")
    public Order addItem(@PathVariable Long orderId, @RequestBody OrderItem item) {
        return orderService.addItemToOrder(orderId, item);
    }

    @DeleteMapping("/{orderId}/items")
    public Order removeItem(@PathVariable Long orderId, @RequestBody OrderItem item) {
        return orderService.removeItemFromOrder(orderId, item);
    }

    @PutMapping("/{orderId}/items")
    public Order updateItems(@PathVariable Long orderId, @RequestBody List<OrderItem> items) {
        return orderService.updateOrderItems(orderId, items);
    }
}
