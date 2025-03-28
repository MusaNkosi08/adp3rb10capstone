package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class PaymentRepositoryTest {

    private PaymentRepository repository;
    private Payment payment1, payment2, payment3;

    @BeforeEach
    void setUp() {
        repository = new PaymentRepository();

        payment1 = PaymentFactory.createPayment("P001", 250.00, "Pending", "TXN1234");
        payment2 = PaymentFactory.createPayment("P002", 500.00, "Completed", "TXN5678");
        payment3 = PaymentFactory.createPayment("P003", 100.00, "Pending", "TXN91011");

        repository.create(payment1);
        repository.create(payment2);
        repository.create(payment3);
    }

    @Test
    void testCreate() {
        Payment newPayment = PaymentFactory.createPayment("P004", 300.00, "Pending", "TXN1415");
        assertNotNull(repository.create(newPayment));
    }

    @Test
    void testRead() {
        assertEquals(payment1, repository.read("P001"));
    }

    @Test
    void testUpdate() {
        Payment updatedPayment = new Payment.Builder()
                .setPaymentID("P001")
                .setAmount(275.00)
                .setStatus("Processed")
                .setTransactionCode("TXN1234")
                .build();

        assertNotNull(repository.update(updatedPayment));
        assertEquals("Processed", repository.read("P001").getStatus());
    }

    @Test
    void testDelete() {
        assertTrue(repository.delete("P003"));
        assertNull(repository.read("P003"));
    }

    @Test
    void testFindAll() {
        List<Payment> payments = repository.findAll();
        assertEquals(3, payments.size());
    }

    @Test
    void testFindByStatus() {
        List<Payment> pendingPayments = repository.findByStatus("Pending");
        assertEquals(2, pendingPayments.size());
    }

    @Test
    void testFindPaymentsAboveAmount() {
        List<Payment> highValuePayments = repository.findPaymentsAboveAmount(200);
        assertEquals(2, highValuePayments.size());
    }

    @Test
    void testProcessPayment() {
        assertTrue(repository.processPayment("P001"));
        assertEquals("Processed", repository.read("P001").getStatus());
    }

    @Test
    void testRefundPayment() {
        assertTrue(repository.refundPayment("P002"));
        assertEquals("Refunded", repository.read("P002").getStatus());
    }

    @Test
    void testVerifyTransaction() {
        assertTrue(repository.verifyTransaction("P001"));
        assertFalse(repository.verifyTransaction("P999")); // Non-existent transaction
    }
}
