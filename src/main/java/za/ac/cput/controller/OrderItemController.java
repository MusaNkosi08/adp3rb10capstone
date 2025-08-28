package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.service.IEmployeeService;
import za.ac.cput.service.IOrderItemService;

import java.util.List;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController {

    @Autowired
    private IOrderItemService orderItemService;

    @PostMapping("/create")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.create(orderItem);
    }

    @GetMapping("/{id}")
    public OrderItem getOrderItem(@PathVariable Long id) {
        return orderItemService.read(Math.toIntExact(id));
    }

    @PutMapping("/update")
    public OrderItem updateOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.update(orderItem);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteOrderItem(@PathVariable Long id) {
        return orderItemService.delete(Math.toIntExact(id));
    }

    @GetMapping("/all")
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.findAll();
    }
}