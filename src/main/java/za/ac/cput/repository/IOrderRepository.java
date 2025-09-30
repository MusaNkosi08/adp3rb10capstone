package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Order;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser_UserId(Long userId);

    List<Order> findByStatus(String status);

    // Get total sales (sum of totalAmount for all orders)
    @Query("SELECT SUM(o.totalAmount) FROM Order o")
    Double getTotalSales();
}
