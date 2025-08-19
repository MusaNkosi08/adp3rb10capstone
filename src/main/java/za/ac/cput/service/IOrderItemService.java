package za.ac.cput.service;

import za.ac.cput.domain.OrderItem;
import java.util.List;
import java.util.Optional;

public interface IOrderItemService {
    OrderItem create(OrderItem orderItem);
    Optional<OrderItem> read(int itemId);
    OrderItem update(OrderItem orderItem);
    boolean delete(int itemId);
    List<OrderItem> getAll();
}
