package za.ac.cput.service;

import za.ac.cput.domain.Order;
import java.util.List;

public interface IOrderService extends IService<Order, Long> {
    List<Order> findByStatus(String status);
    List<Order> findByUserId(Long userId);
}
