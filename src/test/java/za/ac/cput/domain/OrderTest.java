//package za.ac.cput.domain;
//
////Tyrese Ntate 221817816
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import za.ac.cput.domain.Order;
//import za.ac.cput.domain.OrderItem;
//
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//class OrderTest {
//
//    private Order order;
//    private OrderItem item1;
//    private OrderItem item2;
//
//    @BeforeEach
//    public void setUp() {
//        item1 = new OrderItem.Builder()
//                .itemId(1)
//                .quantity(2)
//                .price(10.0)
//                .build();
//
//        item2 = new OrderItem.Builder()
//                .itemId(2)
//                .quantity(1)
//                .price(15.0)
//                .build();
//
//        List<OrderItem> items = Arrays.asList(item1, item2);
//
//        order = new Order.Builder()
//                .orderId(1001)
//                .customerId(5001)
//                .shippingAddress("123 Main St, Anytown")
//                .paymentMethod("Credit Card")
//                .items(items)
//                .build();
//    }
//
//    @Test
//    public void testCalculateTotal() {
//        double expectedTotal = (item1.getQuantity() * item1.getPrice()) + (item2.getQuantity() * item2.getPrice());
//        assertEquals(expectedTotal, order.calculateTotal(), 0.01, "Total amount should be correctly calculated.");
//    }
//
//    @Test
//    public void testUpdateStatus() {
//        order.updateStatus("Shipped");
//        assertEquals("Shipped", order.getStatus());
//    }
//
//    @Test
//    public void testAddItem() {
//        OrderItem newItem = new OrderItem.Builder()
//                .itemId(3)
//                .quantity(3)
//                .price(5.0)
//                .build();
//        order.addItem(newItem);
//        assertTrue(order.getItems().contains(newItem));
//        assertEquals(3, order.getItems().size());
//    }
//
//    @Test
//    public void testRemoveItem() {
//        order.removeItem(item1);
//        assertFalse(order.getItems().contains(item1));
//        assertEquals(1, order.getItems().size());
//    }
//
//    @Test
//    public void testGetOrderDetails() {
//        String details = order.getOrderDetails();
//        assertTrue(details.contains("Order ID: 1001"));
//        assertTrue(details.contains("Customer ID: 5001"));
//        assertTrue(details.contains("Shipping Address: 123 Main St, Anytown"));
//        assertTrue(details.contains("Payment Method: Credit Card"));
//    }
//
//
//}
