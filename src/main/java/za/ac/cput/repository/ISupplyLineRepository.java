package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.SupplyLine;

import java.util.List;

@Repository
public interface ISupplyLineRepository extends JpaRepository<SupplyLine, Long> {

    // Custom queries
    List<SupplyLine> findByOrderOrderId(Long orderId);
    List<SupplyLine> findByBookIsbn(String bookIsbn);
}
