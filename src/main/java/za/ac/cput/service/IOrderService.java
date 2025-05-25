/*
IOrderService.java
Order Service Interface
Author: Siphosethu Msengeni
*/

package za.ac.cput.service;

import za.ac.cput.domain.Order;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface IOrderService extends IRepository<Order, Integer> {
    List<Order> getOrdersByCustomerId(int customerId);
    List<Order> findByStatus(String status);
    boolean updateOrderStatus(int orderId, String status);
}
