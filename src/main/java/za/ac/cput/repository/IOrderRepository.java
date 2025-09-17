package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Order;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(Long customerId);

    @Query(value = "SELECT * FROM Orders o WHERE o.customer_ID = :customerID ORDER BY o.order_ID DESC LIMIT 1", nativeQuery = true)
    Order findLatestUserOrder(@Param("customerID") Long customerId);

    @Query(value = "SELECT * FROM Orders o ORDER BY o.order_ID DESC LIMIT 5", nativeQuery = true)
    List<Order> findRecentOrders();

    List<Order> findByStatus(String status);
}
