package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.SupplyOrder;

import java.util.List;

@Repository
public interface ISupplyOrderRepository extends JpaRepository<SupplyOrder, Long> {

    // Custom queries
    List<SupplyOrder> findByEmployeeID(Long employeeID);
    List<SupplyOrder> findBySupplierSupplierID(Long supplierID);
    List<SupplyOrder> findByOrderStatus(String status);
}
