package za.ac.cput.repository;

import za.ac.cput.domain.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentRepository {
    // In-memory database simulation using a map (PaymentID -> Payment)
    private Map<String, Payment> paymentDatabase = new HashMap<>();


    public void addPayment(Payment payment) {
        paymentDatabase.put(payment.getPaymentID(), payment);
        System.out.println("Payment with ID " + payment.getPaymentID() + " has been added.");
    }


    public Payment getPayment(String paymentID) {
        Payment payment = paymentDatabase.get(paymentID);
        if (payment != null) {
            System.out.println("Retrieved Payment: " + payment.toString());
        } else {
            System.out.println("Payment with ID " + paymentID + " not found.");
        }
        return payment;
    }


    public void updatePayment(Payment payment) {
        if (paymentDatabase.containsKey(payment.getPaymentID())) {
            paymentDatabase.put(payment.getPaymentID(), payment);
            System.out.println("Payment with ID " + payment.getPaymentID() + " has been updated.");
        } else {
            System.out.println("Payment with ID " + payment.getPaymentID() + " not found for update.");
        }
    }


    public void deletePayment(String paymentID) {
        if (paymentDatabase.remove(paymentID) != null) {
            System.out.println("Payment with ID " + paymentID + " has been deleted.");
        } else {
            System.out.println("Payment with ID " + paymentID + " not found for deletion.");
        }
    }


    public void listPayments() {
        if (paymentDatabase.isEmpty()) {
            System.out.println("No payments available.");
        } else {
            System.out.println("Listing all payments:");
            paymentDatabase.values().forEach(payment -> System.out.println(payment.toString()));
        }
    }
}