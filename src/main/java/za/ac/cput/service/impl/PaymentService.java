package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.IPaymentRepository;
import za.ac.cput.service.IPaymentService;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private IPaymentRepository paymentRepository;

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment read(Long paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        if (paymentRepository.existsById(payment.getPaymentId())) {
            return paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public boolean delete(Long paymentId) {
        if (paymentRepository.existsById(paymentId)) {
            paymentRepository.deleteById(paymentId);
            return true;
        }
        return false;
    }

    @Override
    public List<Payment> findAll() {
        return List.of();
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public boolean processPayment(Long paymentId) {
        return paymentRepository.processPayment(paymentId);
    }

    @Override
    public boolean refundPayment(Long paymentId) {
        return paymentRepository.refundPayment(paymentId);
    }

    @Override
    public boolean verifyTransaction(Long paymentId) {
        return paymentRepository.verifyTransaction(paymentId);
    }
}
