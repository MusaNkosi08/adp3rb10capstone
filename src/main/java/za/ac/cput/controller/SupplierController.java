package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Supplier;
import za.ac.cput.service.impl.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    private SupplierService service;
@Autowired
    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return this.service.create(supplier);
    }

    @GetMapping("/{supplierID}")
    public Supplier getSupplier(@PathVariable Long supplierID) {

        return service.read(supplierID);
    }

    @PutMapping("/update")
    public Supplier updateSupplier(@RequestBody Supplier supplier) {
        return service.create(supplier);
    }

    @DeleteMapping("/delete/{supplierID}")
    public void deleteSupplier(@PathVariable Long supplierID) {
        service.delete(supplierID);
    }
}