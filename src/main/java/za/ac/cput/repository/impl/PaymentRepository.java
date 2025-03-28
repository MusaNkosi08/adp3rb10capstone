package za.ac.cput.repository.impl;

import za.ac.cput.domain.Payment;
import za.ac.cput.repository.IPaymentRepository;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository implements IPaymentRepository {

    private static PaymentRepository repository = null;
    private final List<Payment> paymentList;

    public PaymentRepository() {
        this.paymentList = new ArrayList<>();
    }

    public static PaymentRepository getInstance() {
        if (repository == null) {
            repository = new PaymentRepository();
        }
        return repository;
    }

    @Override
    public Payment create(Payment payment) {
        if (paymentList.stream().anyMatch(p -> p.getPaymentID().equals(payment.getPaymentID()))) {
            System.out.println("A payment already exists with this ID: " + payment.getPaymentID());
            return null;
        }
        paymentList.add(payment);
        return payment;
    }

    @Override
    public Payment read(String paymentID) {
        return paymentList.stream().filter(p -> p.getPaymentID().equals(paymentID)).findFirst().orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        for (int i = 0; i < paymentList.size(); i++) {
            if (paymentList.get(i).getPaymentID().equals(payment.getPaymentID())) {
                paymentList.set(i, payment);
                return payment;
            }
        }
        System.out.println("No payment exists with this ID: " + payment.getPaymentID());
        return null;
    }

    @Override
    public boolean delete(String paymentID) {
        return paymentList.removeIf(p -> p.getPaymentID().equals(paymentID));
    }

    @Override
    public List<Payment> findAll() {
        return new ArrayList<>(paymentList);
    }

    @Override
    public List<Payment> findByStatus(String status) {
        List<Payment> filteredPayments = new ArrayList<>();
        for (Payment payment : paymentList) {
            if (payment.getStatus().equalsIgnoreCase(status)) {
                filteredPayments.add(payment);
            }
        }
        return filteredPayments;
    }

    @Override
    public List<Payment> findPaymentsAboveAmount(double amount) {
        List<Payment> filteredPayments = new ArrayList<>();
        for (Payment payment : paymentList) {
            if (payment.getAmount() > amount) {
                filteredPayments.add(payment);
            }
        }
        return filteredPayments;
    }

    @Override
    public boolean processPayment(String paymentID) {
        for (Payment p : paymentList) {
            if (p.getPaymentID().equals(paymentID)) {
                p.processPayment();
                return true;
            }
        }
        System.out.println("Payment not found for processing: " + paymentID);
        return false;
    }

    @Override
    public boolean refundPayment(String paymentID) {
        for (Payment p : paymentList) {
            if (p.getPaymentID().equals(paymentID)) {
                p.refundPayment();
                return true;
            }
        }
        System.out.println("Payment not found for refund: " + paymentID);
        return false;
    }

    @Override
    public boolean verifyTransaction(String paymentID) {
        return paymentList.stream().anyMatch(p -> p.getPaymentID().equals(paymentID));
    }
}



