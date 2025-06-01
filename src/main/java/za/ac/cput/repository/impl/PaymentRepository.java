package za.ac.cput.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.IPaymentRepository;

import java.util.List;

@Repository
@Transactional
public class PaymentRepository implements IPaymentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Payment create(Payment payment) {
        entityManager.persist(payment);
        return payment;
    }

    @Override
    public Payment read(String id) {
        return entityManager.find(Payment.class, id);
    }

    @Override
    public Payment update(Payment payment) {
        return entityManager.merge(payment);
    }

    @Override
    public void delete(String id) {
        Payment payment = read(id);
        if (payment != null) {
            entityManager.remove(payment);
        }
    }

    @Override
    public List<Payment> findAll() {
        return entityManager.createQuery("SELECT p FROM Payment p", Payment.class).getResultList();
    }

    @Override
    public List<Payment> findByStatus(String status) {
        return entityManager.createQuery("SELECT p FROM Payment p WHERE p.status = :status", Payment.class)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public List<Payment> findPaymentsAboveAmount(double amount) {
        return entityManager.createQuery("SELECT p FROM Payment p WHERE p.amount > :amount", Payment.class)
                .setParameter("amount", amount)
                .getResultList();
    }

    @Override
    public boolean processPayment(String paymentID) {
        Payment payment = read(paymentID);
        if (payment != null) {
            payment.setStatus("Processed");
            update(payment);
            return true;
        }
        return false;
    }

    @Override
    public boolean refundPayment(String paymentID) {
        Payment payment = read(paymentID);
        if (payment != null) {
            payment.setStatus("Refunded");
            update(payment);
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyTransaction(String paymentID) {
        Payment payment = read(paymentID);
        return payment != null && payment.getTransactionCode() != null && !payment.getTransactionCode().isEmpty();
    }
}
