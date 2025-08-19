package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Supplier;
import za.ac.cput.repository.ISupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private ISupplierRepository supplierRepository;

    // Create or update
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    // Read by ID
    public Optional<Supplier> read(String supplierId) {
        return supplierRepository.findById(supplierId);
    }

    // Delete by ID
    public boolean delete(String supplierId) {
        if (supplierRepository.existsById(supplierId)) {
            supplierRepository.deleteById(supplierId);
            return true;
        }
        return false;
    }

    // Get all suppliers
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    // Custom queries
    public Supplier getByName(String name) {
        return supplierRepository.findByName(name);
    }

    public List<Supplier> getByAddressKeyword(String keyword) {
        return supplierRepository.findByAddressContaining(keyword);
    }

    public List<Supplier> getByEmail(String email) {
        return supplierRepository.findByEmailContaining(email);
    }
}
