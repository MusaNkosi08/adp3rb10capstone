package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.IPaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private IPaymentRepository paymentRepository;

    // Create a new payment
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Read a payment by ID
    public Optional<Payment> read(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    // Update a payment
    public Payment update(Payment payment) {
        if (paymentRepository.existsById(payment.getPaymentId())) {
            return paymentRepository.save(payment);
        }
        return null;
    }

    // Delete a payment
    public boolean delete(String paymentId) {
        if (paymentRepository.existsById(paymentId)) {
            paymentRepository.deleteById(paymentId);
            return true;
        }
        return false;
    }

    // Get all payments
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    // Process payment (set status to "Processed")
    public boolean processPayment(String paymentId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            payment.processPayment();
            paymentRepository.save(payment);
            return true;
        }
        return false;
    }

    // Refund payment (set status to "Refunded")
    public boolean refundPayment(String paymentId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            payment.refundPayment();
            paymentRepository.save(payment);
            return true;
        }
        return false;
    }

    // Verify transaction code
    public boolean verifyTransaction(String paymentId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        return optionalPayment.map(Payment::verifyTransaction).orElse(false);
    }
}
