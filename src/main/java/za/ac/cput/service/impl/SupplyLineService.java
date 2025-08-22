package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.SupplyLine;
import za.ac.cput.repository.ISupplyLineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyLineService {

    @Autowired
    private ISupplyLineRepository supplyLineRepository;

    // Create or update a supply line
    public SupplyLine save(SupplyLine supplyLine) {
        return supplyLineRepository.save(supplyLine);
    }

    // Read by ID
    public Optional<SupplyLine> read(int lineID) {
        return supplyLineRepository.findById(lineID);
    }

    // Delete by ID
    public boolean delete(int lineID) {
        if (supplyLineRepository.existsById(lineID)) {
            supplyLineRepository.deleteById(lineID);
            return true;
        }
        return false;
    }

    // Get all supply lines
    public List<SupplyLine> getAll() {
        return supplyLineRepository.findAll();
    }

    // Custom queries
    public List<SupplyLine> getByOrderId(int orderId) {
        return supplyLineRepository.findByOrderId(orderId);
    }

    public List<SupplyLine> getByBookIsbn(String bookIsbn) {
        return supplyLineRepository.findByBookIsbn(bookIsbn);
    }
}
