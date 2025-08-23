package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.service.impl.OrderItemService;

import java.util.List;
import java.util.Optional;

/**
 * Author: TT Ntate (221817816)
 */
@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping
    public ResponseEntity<OrderItem> create(@RequestBody OrderItem orderItem) {
        OrderItem savedItem = orderItemService.create(orderItem);
        return ResponseEntity.ok(savedItem);
    }

    // READ (single)
    @GetMapping("/{itemId}")
    public ResponseEntity<OrderItem> read(@PathVariable int itemId) {
        Optional<OrderItem> item = orderItemService.read(itemId);
        return item.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<OrderItem>> getAll() {
        List<OrderItem> items = orderItemService.getAll();
        return ResponseEntity.ok(items);
    }


    @PutMapping("/{itemId}")
    public ResponseEntity<OrderItem> update(@PathVariable int itemId, @RequestBody OrderItem orderItem) {
        OrderItem updated = orderItemService.update(itemId, orderItem);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> delete(@PathVariable int itemId) {
        orderItemService.delete(itemId);
        return ResponseEntity.noContent().build();
    }
}
