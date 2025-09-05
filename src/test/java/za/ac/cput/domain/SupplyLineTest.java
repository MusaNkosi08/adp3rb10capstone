//package za.ac.cput.domain;
//
///* SupplyLineTest.java
//   Test class for SupplyLine
//   Author: 222791829
//*/
//
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//class SupplyLineTest {
//
//    @Test
//    void testSupplyLineCreationUsingBuilder() {
//        SupplyLine supplyLine = new SupplyLine.Builder(1, 100, "9781234567890", 5)
//                .build();
//
//        assertNotNull(supplyLine);
//        assertEquals(1, supplyLine.getLineID());
//        assertEquals(100, supplyLine.getOrderId());
//        assertEquals("9781234567890", supplyLine.getBookIsbn());
//        assertEquals(5, supplyLine.getQuantity());
//    }
//
//    @Test
//    void testSupplyLineDefaultConstructor() {
//        SupplyLine supplyLine = new SupplyLine();
//
//        assertNotNull(supplyLine);
//        assertEquals(0, supplyLine.getLineID());  // default int = 0
//        assertEquals(0, supplyLine.getOrderId());
//        assertNull(supplyLine.getBookIsbn());    // default reference = null
//        assertEquals(0, supplyLine.getQuantity());
//    }
//
//    @Test
//    void testBuilderWithSetters() {
//        SupplyLine.Builder builder = new SupplyLine.Builder(1, 200, "9781111111111", 3);
//        builder.setLineOrder(2);
//        builder.setOrderId(201);
//        builder.setBookId("9782222222222");
//        builder.setQuantity(10);
//
//        SupplyLine supplyLine = builder.build();
//
//        assertEquals(2, supplyLine.getLineID());
//        assertEquals(201, supplyLine.getOrderId());
//        assertEquals("9782222222222", supplyLine.getBookIsbn());
//        assertEquals(10, supplyLine.getQuantity());
//    }
//}
