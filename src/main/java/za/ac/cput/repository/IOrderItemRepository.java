package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.OrderItem;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Long> {
}
