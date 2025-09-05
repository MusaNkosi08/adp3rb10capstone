//package za.ac.cput.factory;
//
////Tyrese Ntate 221817816
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.domain.Order;
//import za.ac.cput.domain.OrderItem;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//class OrderFactoryTest {
//    @Test
//    public void testCreateOrder() {
//        int orderId = 1;
//        int customerId = 123;
//        String shippingAddress = "123 Main St, Anytown";
//        String paymentMethod = "Credit Card";
//
//        Order order = OrderFactory.createOrder(orderId, customerId, shippingAddress, paymentMethod);
//
//        assertNotNull(order, "Order should not be null");
//        assertEquals(orderId, order.getOrderId(), "Order ID should match");
//        assertEquals(customerId, order.getCustomerId(), "Customer ID should match");
//        assertEquals(shippingAddress, order.getShippingAddress(), "Shipping address should match");
//        assertEquals(paymentMethod, order.getPaymentMethod(), "Payment method should match");
//        assertTrue(order.getItems().isEmpty(), "Order items list should be empty");
//    }
//
//    @Test
//    public void testCreateOrderWithItems() {
//        int orderId = 2;
//        int customerId = 456;
//        String shippingAddress = "456 Elm St, Othertown";
//        String paymentMethod = "PayPal";
//
//        OrderItem item1 = new OrderItem.Builder()
//                .itemId(1)
//                .quantity(2)
//                .price(10.0)
//                .build();
//
//        OrderItem item2 = new OrderItem.Builder()
//                .itemId(2)
//                .quantity(1)
//                .price(15.0)
//                .build();
//
//        List<OrderItem> items = Arrays.asList(item1, item2);
//
//        Order order = OrderFactory.createOrderWithItems(orderId, customerId, shippingAddress, paymentMethod, items);
//
//        assertNotNull(order, "Order should not be null");
//        assertEquals(orderId, order.getOrderId(), "Order ID should match");
//        assertEquals(customerId, order.getCustomerId(), "Customer ID should match");
//        assertEquals(shippingAddress, order.getShippingAddress(), "Shipping address should match");
//        assertEquals(paymentMethod, order.getPaymentMethod(), "Payment method should match");
//        assertEquals(2, order.getItems().size(), "Order should contain two items");
//        assertTrue(order.getItems().containsAll(items), "Order items should match the provided items");
//    }
//
//
//}
