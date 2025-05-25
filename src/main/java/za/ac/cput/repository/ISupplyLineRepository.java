package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.SupplyLine;

@Repository
public interface ISupplyLineRepository extends JpaRepository<SupplyLine,Integer> {
}
