package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.SupplyOrder;
import za.ac.cput.repository.ISupplyOrderRepository;

import java.util.List;

@RestController
@RequestMapping("/api/supplyorder")
public class SupplyOrderController {

    @Autowired
    private ISupplyOrderRepository repository;

    @PostMapping("/create")
    public SupplyOrder createSupplyOrder(@RequestBody SupplyOrder supplyOrder) {
        return this.repository.save(supplyOrder);
    }

    @GetMapping("/{orderId}")
    public SupplyOrder getSupplyOrder(@PathVariable String orderId) {
        return repository.findById(orderId).orElse(null);
    }

    @PutMapping("/update")
    public SupplyOrder updateSupplyOrder(@RequestBody SupplyOrder supplyOrder) {
        return repository.save(supplyOrder);
    }

    @DeleteMapping("/delete/{orderId}")
    public void deleteSupplyOrder(@PathVariable String orderId) {
        repository.deleteById(orderId);
    }

    @GetMapping("/all")
    public List<SupplyOrder> getAllSupplyOrders() {
        return repository.findAll();
    }
}
