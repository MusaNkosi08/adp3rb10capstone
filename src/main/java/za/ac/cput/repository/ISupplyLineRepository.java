

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.SupplyLine;

import java.util.List;

@Repository
public interface ISupplyLineRepository extends JpaRepository<SupplyLine, Integer> {

    // Custom queries
    List<SupplyLine> findByOrderId(int orderId);
    List<SupplyLine> findByBookIsbn(String bookIsbn);
}
