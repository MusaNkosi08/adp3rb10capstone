//package za.ac.cput.domain;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PaymentTest {
//    private Payment payment1;
//    private Payment payment2;
//    private Payment payment3;
//
//    @BeforeEach
//    void setUp() {
//        payment1 = new Payment.Builder()
//                .setPaymentID("P001")
//                .setAmount(250.00)
//                .setStatus("Pending")
//                .setTransactionCode("TXN12345")
//                .build();
//
//        payment2 = new Payment.Builder()
//                .setPaymentID("P002")
//                .setAmount(500.00)
//                .setStatus("Completed")
//                .setTransactionCode("TXN67890")
//                .build();
//
//        payment3 = new Payment.Builder()
//                .setPaymentID("P003")
//                .setAmount(100.00)
//                .setStatus("Pending")
//                .setTransactionCode("")
//                .build();
//    }
//
//    @Test
//    void testPaymentCreation() {
//        assertNotNull(payment1);
//        assertEquals("P001", payment1.getPaymentID());
//        assertEquals(250.00, payment1.getAmount());
//        assertEquals("Pending", payment1.getStatus());
//        assertEquals("TXN12345", payment1.getTransactionCode());
//    }
//
//    @Test
//    void testProcessPayment() {
//        payment1.processPayment();
//        assertEquals("Processed", payment1.getStatus());
//    }
//
//    @Test
//    void testRefundPayment() {
//        payment2.refundPayment();
//        assertEquals("Refunded", payment2.getStatus());
//    }
//
//    @Test
//    void testVerifyTransaction() {
//        assertTrue(payment1.verifyTransaction());
//        assertFalse(payment3.verifyTransaction());
//    }
//}
