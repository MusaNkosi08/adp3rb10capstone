package za.ac.cput.repository;

import za.ac.cput.domain.Supplier;
import java.util.List;
import java.util.Optional;

public interface ISupplierRepository {
    Supplier save(Supplier supplier);
    Optional<Supplier> findById(Long id);
    List<Supplier> findAll();
    void deleteById(Long id);
    void delete(Supplier supplier);
    boolean existsById(Long id);
}
