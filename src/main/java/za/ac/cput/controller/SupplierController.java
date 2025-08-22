package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Supplier;
import za.ac.cput.repository.ISupplierRepository;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
   @Autowired
    private ISupplierRepository repository;

    @PostMapping("/create")
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return this.repository.save(supplier);
    }

    @GetMapping("/{supplierID}")
    public Supplier getSupplier(@PathVariable Long supplierID) {

        return repository.findById(supplierID).orElse(null);
    }

    @PutMapping("/update")
    public Supplier updateSupplier(@RequestBody Supplier supplier) {
        return repository.save(supplier);
    }

    @DeleteMapping("/delete/{supplierID}")
    public void deleteSupplier(@PathVariable Long supplierID) {
        repository.deleteById(supplierID);
    }
}
