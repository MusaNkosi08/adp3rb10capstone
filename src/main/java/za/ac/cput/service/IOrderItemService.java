package za.ac.cput.service;

import za.ac.cput.domain.OrderItem;

// Import List and Optional if needed for custom methods
import java.util.List;
import java.util.Optional;

public interface IOrderItemService extends IService<OrderItem, Long> {

    // Business logic specific to OrderItem
    double calculateTotalPrice(int itemId);
}
