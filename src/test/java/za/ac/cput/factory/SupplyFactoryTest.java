///*
//SupplyFactoryTest.java
//Author: Musa Banathi Nkosi
//        221744517
// */
//
//package za.ac.cput.factory;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class SupplyFactoryTest {
//
//    @Test
//    void testCreateSupplySuccess() {
//        // Test creating a supply with valid inputs from supplier "ABC Supplies"
//        Supply supply = SupplyOrderFactory.createSupplyOrder("SUP001", 100.50, 10, "ABC Supplies");
//
//        assertNotNull(supply); // Verify the supply object is not null
//        assertEquals("SUP001", supply.getOrderID()); // Verify order ID
//        assertEquals(100.50, supply.getOrderPrice(), 0.01); // Verify order price
//        assertEquals(10, supply.getQuantity()); // Verify quantity
//        assertEquals("ABC Supplies", supply.getSupplierName()); // Verify supplier name
//    }
//
//    @Test
//    void testCreateSupplyWithEmptyOrderID() {
//        // Test creating a supply with an empty order ID
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->
//                SupplyOrderFactory.createSupplyOrder("", 100.50, 10, "ABC Supplies"));
//
//        assertEquals("Error: Order ID cannot be empty.", exception.getMessage()); // Verify error message
//    }
//
//    @Test
//    void testCreateSupplyWithEmptySupplierName() {
//        // Test creating a supply with an empty supplier name
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->
//                SupplyOrderFactory.createSupplyOrder("SUP002", 100.50, 10, ""));
//
//        assertEquals("Error: Supplier name cannot be empty.", exception.getMessage()); // Verify error message
//    }
//
//    @Test
//    void testCreateSupplyWithNegativeOrderPrice() {
//        // Test creating a supply with a negative order price
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->
//                SupplyOrderFactory.createSupplyOrder("SUP003", -50.00, 10, "XYZ Distributors"));
//
//        assertEquals("Error: Order price must be greater than 0.", exception.getMessage()); // Verify error message
//    }
//
//    @Test
//    void testCreateSupplyWithNegativeQuantity() {
//        // Test creating a supply with a negative quantity
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->
//                SupplyOrderFactory.createSupplyOrder("SUP004", 100.00, -5, "LMN Traders"));
//
//        assertEquals("Error: Quantity cannot be negative.", exception.getMessage()); // Verify error message
//    }
//}