package za.ac.cput.service;

import za.ac.cput.domain.Payment;
import java.util.List;

public interface IPaymentService extends IService<Payment, String> {
    List<Payment> findByStatus(String status);
    List<Payment> findPaymentsAboveAmount(double amount);
    boolean processPayment(String paymentId);
    boolean refundPayment(String paymentId);
    boolean verifyTransaction(String paymentId);
}
