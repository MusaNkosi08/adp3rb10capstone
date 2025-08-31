package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.service.impl.OrderItemService;

import java.util.List;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController {

    private OrderItemService service;

    @Autowired
    public OrderItemController(OrderItemService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return service.create(orderItem);
    }

    @GetMapping("/{id}")
    public OrderItem getOrderItem(@PathVariable Long id) {
        return service.read(Math.toIntExact(id));
    }

    @PutMapping("/update")
    public OrderItem updateOrderItem(@RequestBody OrderItem orderItem) {
        return service.update(orderItem);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteOrderItem(@PathVariable Long id) {
        return service.delete(Math.toIntExact(id));
    }

    @GetMapping("/all")
    public List<OrderItem> getAllOrderItems() {
        return service.findAll();
    }
}