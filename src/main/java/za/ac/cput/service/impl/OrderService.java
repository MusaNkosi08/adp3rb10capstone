package za.ac.cput.service.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.IOrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private IOrderRepository orderRepository;

    // Create a new order
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    // Read an order by ID
    public Optional<Order> read(String orderId) {
        return orderRepository.findById(orderId);
    }


    //public Order update(Order order) {
        //if (orderRepository.existsById(order.getOrderId())) {
       //     return orderRepository.save(order);
     //   }
      //  return null;
  //  }


    public boolean delete(String orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getOrder(int orderId) {
        return orderRepository.getOrder(orderId);
    }


    public List<Order> getOrdersByCustomerId(int customerId) {
        return orderRepository.getOrdersByCustomerId(customerId);
    }
    public List<Order> getByStatus(String status) {
        return orderRepository.findByStatus(status);
    }
}
