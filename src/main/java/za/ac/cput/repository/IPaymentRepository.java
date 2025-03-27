package za.ac.cput.repository;

import za.ac.cput.domain.Payment;

import java.util.List;

public interface IPaymentRepository extends IRepository<Payment, String> {
    List<Payment> findByStatus(String status);
    List<Payment> findPaymentsAboveAmount(double amount);
    boolean processPayment(String paymentID);
    boolean refundPayment(String paymentID);
    boolean verifyTransaction(String paymentID);
}
