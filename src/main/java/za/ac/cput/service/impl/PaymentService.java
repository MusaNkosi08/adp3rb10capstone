package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.PaymentRepository;
import za.ac.cput.service.IPaymentService;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    private final PaymentRepository repository;

    @Autowired
    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment create(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public sboolean delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Payment> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Payment> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<Payment> findPaymentsAboveAmount(double amount) {
        return repository.findByAmountGreaterThan(amount);
    }

    @Override
    public Payment findByPaymentId(String paymentId) {
        return null;
    }

    @Override
    public boolean processPayment(String paymentId) {
        Payment payment = read(paymentId);
        if (payment != null) {
            payment.setStatus("Processed");
            update(payment);
            return true;
        }
        return false;
    }

    @Override
    public boolean refundPayment(String paymentId) {
        Payment payment = read(paymentId);
        if (payment != null) {
            payment.setStatus("Refunded");
            update(payment);
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyTransaction(String paymentId) {
        Payment payment = read(paymentId);
        return payment != null && payment.getTransactionCode() != null && !payment.getTransactionCode().isEmpty();
    }
}
