package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Payment;

import java.util.List;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, String> {

    List<Payment> findByStatus(String status);

    List<Payment> findByAmountGreaterThan(double amount);

    default boolean processPayment(String paymentID) {
        return findById(paymentID).map(payment -> {
            payment.processPayment();
            save(payment);
            return true;
        }).orElse(false);
    }

    default boolean refundPayment(String paymentID) {
        return findById(paymentID).map(payment -> {
            payment.refundPayment();
            save(payment);
            return true;
        }).orElse(false);
    }

    default boolean verifyTransaction(String paymentID) {
        return findById(paymentID).map(Payment::verifyTransaction).orElse(false);
    }
}
