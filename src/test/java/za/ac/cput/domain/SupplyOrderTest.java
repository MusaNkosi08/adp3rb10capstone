//package za.ac.cput.domain;
//
///* SupplyOrderTest.java
//   Test class for SupplyOrder
//   222791829
//*/
//
//import org.junit.jupiter.api.Test;
//
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class SupplyOrderTest {
//
//    @Test
//    void testSupplyOrderCreationWithBuilder() {
//        Date orderDate = new Date();
//
//        SupplyOrder order = new SupplyOrder.Builder()
//                .setOrderID("ORD123")
//                .setEmployeeID("EMP001")
//                .setOrderDetails("10 SQL Books")
//                .setOrderDate(orderDate)
//                .setSupplierID("SUP789")
//                .setOrderPrice(1500.50)
//                .setOrderStatus("Pending")
//                .build();
//
//        assertNotNull(order);
//        assertEquals("ORD123", order.getOrderID());
//        assertEquals("EMP001", order.getEmployeeID());
//        assertEquals("10 SQL Books", order.getOrderDetails());
//        assertEquals(orderDate, order.getOrderDate());
//        assertEquals("SUP789", order.getSupplierID());
//        assertEquals(1500.50, order.getOrderPrice());
//        assertEquals("Pending", order.getOrderStatus());
//    }
//
//    @Test
//    void testDisplayStatus() {
//        SupplyOrder order = new SupplyOrder.Builder()
//                .setOrderID("ORD456")
//                .setOrderStatus("Shipped")
//                .build();
//
//        String statusMessage = order.displayStatus();
//        assertEquals("Order Status: Shipped", statusMessage);
//    }
//
//    @Test
//    void testCancelOrder() {
//        SupplyOrder order = new SupplyOrder.Builder()
//                .setOrderID("ORD789")
//                .setOrderStatus("Processing")
//                .build();
//
//        order.cancelOrder();
//
//        assertEquals("Cancelled", order.getOrderStatus());
//    }
//
//    @Test
//    void testToStringContainsValues() {
//        SupplyOrder order = new SupplyOrder.Builder()
//                .setOrderID("ORD999")
//                .setEmployeeID("EMP999")
//                .setOrderDetails("Laptop and Charger")
//                .setSupplierID("SUP999")
//                .setOrderPrice(2500.00)
//                .setOrderStatus("Approved")
//                .build();
//
//        String result = order.toString();
//
//        assertTrue(result.contains("ORD999"));
//        assertTrue(result.contains("Laptop and Charger"));
//        assertTrue(result.contains("SUP999"));
//        assertTrue(result.contains("2500.0"));
//        assertTrue(result.contains("Approved"));
//    }
//}
