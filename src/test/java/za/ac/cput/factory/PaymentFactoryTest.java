//package za.ac.cput.factory;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import za.ac.cput.domain.Payment;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PaymentFactoryTest {
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @Test
//    void blankStringCreation() {
//        assertNotNull(PaymentFactory.createPayment("", 0.00, "", ""));
//    }
//
//    @Test
//    void negativeAmountCreation() {
//        assertNotNull(PaymentFactory.createPayment("P002", -100.00, "Pending", "TXN5678"));
//    }
//}
