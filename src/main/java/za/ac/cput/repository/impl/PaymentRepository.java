package za.ac.cput.repository.impl;

import za.ac.cput.domain.Payment;
import za.ac.cput.repository.IPaymentRepository;

import java.util.List;

public class PaymentRepository implements IPaymentRepository {

    @Override
    public List<Payment> findByStatus(String status) {
        return List.of();
    }

    @Override
    public List<Payment> findPaymentsAboveAmount(double amount) {
        return List.of();
    }

    @Override
    public boolean processPayment(String paymentID) {
        return false;
    }

    @Override
    public boolean refundPayment(String paymentID) {
        return false;
    }

    @Override
    public boolean verifyTransaction(String paymentID) {
        return false;
    }

    @Override
    public Payment create(Payment payment) {
        return null;
    }

    @Override
    public Payment read(String s) {
        return null;
    }

    @Override
    public Payment update(Payment payment) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Payment> findAll() {
        return List.of();
    }
}
