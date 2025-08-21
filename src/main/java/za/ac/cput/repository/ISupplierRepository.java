
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Supplier;

import java.util.List;

@Repository
public interface ISupplierRepository extends JpaRepository<Supplier, Long> {

    // Custom queries
    Supplier findByName(String name);
    List<Supplier> findByAddressContaining(String keyword);
    List<Supplier> findByEmailContaining(String email);
}
