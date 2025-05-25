package za.ac.cput.service;

import za.ac.cput.domain.Supplier;

import java.util.List;
import java.util.Optional;

public interface ISupplierService {

    Supplier save(Supplier supplier);

    Optional<Supplier> findById(Long id);

    List<Supplier> findAll();

    void deleteById(Long id);

    List<Supplier> findByName(String name);

    boolean existsByEmail(String email);
}
