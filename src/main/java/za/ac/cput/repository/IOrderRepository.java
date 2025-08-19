package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Order;
import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, String> {

    Order getOrder(int orderId);

    List<Order> getOrdersByCustomerId(int customerId);

    List<Order> findByStatus(String status);

    boolean addOrder(Order order);

    boolean updateOrder(Order order);

    //boolean deleteOrder(int orderId); // Fixed typo: `DeleteOrder` → `deleteOrder`
}
