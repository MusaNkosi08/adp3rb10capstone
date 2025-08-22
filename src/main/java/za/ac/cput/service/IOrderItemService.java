package za.ac.cput.service;
import za.ac.cput.domain.OrderItem;

import java.util.List;
import java.util.Optional;

/**
 * Author: TT Ntate (221817816)
 */

public interface IOrderItemService {
    // CREATE
    OrderItem create(OrderItem orderItem);

    // READ (single)
    Optional<OrderItem> read(int itemId);

    // READ ALL
    List<OrderItem> getAll();

    // UPDATE
    OrderItem update(int itemId, OrderItem orderItem);

    // DELETE
    void delete(int itemId);
}


