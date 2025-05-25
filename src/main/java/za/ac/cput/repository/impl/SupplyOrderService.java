/*
SupplyOrderService.java
Author: Musa Banathi Nkosi (221744517)
*/

package za.ac.cput.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.SupplyOrder;
import za.ac.cput.repository.ISupplyOrderRepository;

import java.util.List;

@Service
public abstract class SupplyOrderService implements ISupplyOrderRepository {

    private final SupplyOrderRepository repository;

    @Autowired
    public SupplyOrderService(SupplyOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupplyOrder create(SupplyOrder order) {
        return repository.save(order);
    }

    @Override
    public SupplyOrder read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<SupplyOrder> readAll() {
        return repository.findAll();
    }

    @Override
    public SupplyOrder update(SupplyOrder order) {
        return repository.save(order);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
