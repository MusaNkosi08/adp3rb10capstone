package za.ac.cput.service;

import za.ac.cput.domain.Payment;
import java.util.List;
import java.util.Optional;

public interface IPaymentService  {

    Payment create(Payment payment);

    Optional<Payment> read(String paymentId);

    Payment update(Payment payment);

    boolean delete(String paymentId);
    List<Payment> findByStatus(String status);

    List<Payment> findByAmountGreaterThan(double amount);
    List<Payment> getAll();

    boolean processPayment(String paymentId);

    boolean refundPayment(String paymentId);

    boolean verifyTransaction(String paymentId);
}
