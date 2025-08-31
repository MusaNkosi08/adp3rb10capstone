package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.IPaymentRepository;
import za.ac.cput.service.IPaymentService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private IPaymentRepository paymentRepository;

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> read(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public Payment update(Payment payment) {
        if (paymentRepository.existsById(payment.getPaymentId())) {
            return paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public boolean delete(String paymentId) {
        if (paymentRepository.existsById(paymentId)) {
            paymentRepository.deleteById(paymentId);
            return true;
        }
        return false;
    }

    @Override
    public List<Payment> findByStatus(String status) {
        return paymentRepository.findByStatus(status);
    }

    @Override
    public List<Payment> findByAmountGreaterThan(double amount) {
        return paymentRepository.findByAmountGreaterThan(amount);
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public boolean processPayment(String paymentId) {
        return paymentRepository.processPayment(paymentId);
    }

    @Override
    public boolean refundPayment(String paymentId) {
        return paymentRepository.refundPayment(paymentId);
    }

    @Override
    public boolean verifyTransaction(String paymentId) {
        return paymentRepository.verifyTransaction(paymentId);
    }
}
