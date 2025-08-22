package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.repository.IPaymentRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class PaymentRepositoryTest {

    @Autowired
    private IPaymentRepository repository;
    private Payment payment1, payment2, payment3;

    @BeforeEach
    void setUp() {
        // Clear any existing data
        repository.deleteAll();

        payment1 = PaymentFactory.createPayment("P001", 250.00, "Pending", "TXN1234");
        payment2 = PaymentFactory.createPayment("P002", 500.00, "Completed", "TXN5678");
        payment3 = PaymentFactory.createPayment("P003", 100.00, "Pending", "TXN91011");

        repository.save(payment1);
        repository.save(payment2);
        repository.save(payment3);
    }

    @Test
    void testSave() {
        Payment newPayment = PaymentFactory.createPayment("P004", 300.00, "Pending", "TXN1415");
        Payment savedPayment = repository.save(newPayment);
        assertNotNull(savedPayment);
        assertEquals("P004", savedPayment.getPaymentId());
    }

    @Test
    void testFindById() {
        Optional<Payment> foundPayment = repository.findById("P001");
        assertTrue(foundPayment.isPresent());
        assertEquals("P001", foundPayment.get().getPaymentId());
    }

    @Test
    void testUpdate() {
        // Use the builder pattern to create an updated payment
        Payment updatedPayment = new Payment.Builder()
                .setPaymentId("P001")
                .setAmount(275.00)
                .setStatus("Processed")
                .setTransactionCode("TXN1234")
                .build();

        Payment savedPayment = repository.save(updatedPayment);

        assertNotNull(savedPayment);
        assertEquals("Processed", savedPayment.getStatus());
        assertEquals(275.00, savedPayment.getAmount());
    }

    @Test
    void testDeleteById() {
        assertTrue(repository.existsById("P003"));
        repository.deleteById("P003");
        assertFalse(repository.existsById("P003"));
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
    void testFindByAmountGreaterThan() {
        List<Payment> highValuePayments = repository.findByAmountGreaterThan(200.0);
        assertEquals(2, highValuePayments.size());
    }

    @Test
    void testProcessPayment() {
        assertTrue(repository.processPayment("P001"));

        Optional<Payment> processedPayment = repository.findById("P001");
        assertTrue(processedPayment.isPresent());
        assertEquals("Processed", processedPayment.get().getStatus());
    }

    @Test
    void testRefundPayment() {
        assertTrue(repository.refundPayment("P002"));

        Optional<Payment> refundedPayment = repository.findById("P002");
        assertTrue(refundedPayment.isPresent());
        assertEquals("Refunded", refundedPayment.get().getStatus());
    }

    @Test
    void testVerifyTransaction() {
        assertTrue(repository.verifyTransaction("P001"));
        assertFalse(repository.verifyTransaction("P999")); // Non-existent transaction
    }
}