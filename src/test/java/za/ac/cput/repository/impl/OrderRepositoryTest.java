//package za.ac.cput.repository.impl;
//
////Tyrese Ntate 221817816
//
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
//
import java.util.List;
//
import static org.junit.jupiter.api.Assertions.*;
//
class OrderRepositoryTest {
   private OrderRepository orderRepository;
//
   @BeforeEach
    public void setUp() {
      orderRepository = new OrderRepository();
    }
//
   @Test
    public void testGetOrder() {
       int orderId = 1;
       Order result = orderRepository.getOrder(orderId);
       assertNull(result, "Expected null for getOrder with unimplemented method");
    }
//
  @Test
    public void testGetOrdersByCustomerId() {
       int customerId = 123;
       List<Order> result = orderRepository.getOrdersByCustomerId(customerId);
        assertNotNull(result, "Expected non-null list for getOrdersByCustomerId");
       assertTrue(result.isEmpty(), "Expected empty list for getOrdersByCustomerId with unimplemented method");
    }
//
   @Test
   public void testFindByStatus() {
       String status = "Pending";
        List<Order> result = orderRepository.findByStatus(status);
       assertNotNull(result, "Expected non-null list for findByStatus");
        assertTrue(result.isEmpty(), "Expected empty list for findByStatus with unimplemented method");
    }
//
    @Test
   public void testAddOrder() {
       Order order = new Order.Builder().orderId(1).customerId(123).build();
       boolean result = orderRepository.addOrder(order);
        assertFalse(result, "Expected false for addOrder with unimplemented method");
    }
//
   @Test
   public void testUpdateOrder() {
        Order order = new Order.Builder().orderId(1).customerId(123).build();
       boolean result = orderRepository.updateOrder(order);
       assertFalse(result, "Expected false for updateOrder with unimplemented method");
    }
//
   @Test
   public void testDeleteOrder() {
       int orderId = 1;
       boolean result = orderRepository.DeleteOrder(orderId);
       assertFalse(result, "Expected false for DeleteOrder with unimplemented method");
    }
//
   @Test
    public void testCreate() {
       Order order = new Order.Builder().orderId(1).customerId(123).build();
       Order result = orderRepository.create(order);
       assertNull(result, "Expected null for create with unimplemented method");
   }
//
   @Test
    public void testRead() {
      String orderId = "1";
       Order result = orderRepository.read(orderId);
       assertNull(result, "Expected null for read with unimplemented method");
   }
//
   @Test
   public void testUpdate() {
      Order order = new Order.Builder().orderId(1).customerId(123).build();
       Order result = orderRepository.update(order);
        assertNull(result, "Expected null for update with unimplemented method");
   }
//
  @Test
   public void testDelete() {
       String orderId = "1";
        boolean result = orderRepository.delete(orderId);
       assertFalse(result, "Expected false for delete with unimplemented method");
   }
//
   @Test
    public void testFindAll() {
        List<Order> result = orderRepository.findAll();
        assertNotNull(result, "Expected non-null list for findAll");
       assertTrue(result.isEmpty(), "Expected empty list for findAll with unimplemented method");
    }
//
}
