package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.SupplyOrder;
import za.ac.cput.repository.ISupplyOrderRepository;
import za.ac.cput.service.impl.SupplyOrderService;

import java.util.List;


@RestController
@RequestMapping("/api/supplyorder")
public class SupplyOrderController {


    private SupplyOrderService repository;
@Autowired
    public SupplyOrderController(SupplyOrderService repository) {
        this.repository = repository;
    }


    @PostMapping("/create")
    public SupplyOrder createSupplyOrder(@RequestBody SupplyOrder supplyOrder) {
        return this.repository.create(supplyOrder);
    }

    @GetMapping("/{orderId}")
    public SupplyOrder getSupplyOrder(@PathVariable String orderId) {
        return repository.read(orderId);
    }

    @PutMapping("/update")
    public SupplyOrder updateSupplyOrder(@RequestBody SupplyOrder supplyOrder) {
        return repository.create(supplyOrder);
    }

    @DeleteMapping("/delete/{orderId}")
    public void deleteSupplyOrder(@PathVariable String orderId) {
        repository.delete(orderId);
    }

    @GetMapping("/all")
    public List<SupplyOrder> getAllSupplyOrders() {
        return repository.readAll();
    }
}
