package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Order;
import org.springframework.data.repository.query.Param;
import za.ac.cput.domain.User;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByCustomerId(int customerId);

    @Query(value= "SELECT * FROM Order o WHERE o.customerID = :customerID ORDER BY orderID DESC LIMIT 1", nativeQuery = true)
    Order findLatestUserOrder ( @Param("customerID") Long customerId);

    List<Order> findByStatus(String status);
}
