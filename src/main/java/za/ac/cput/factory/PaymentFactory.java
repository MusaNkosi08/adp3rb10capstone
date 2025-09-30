package za.ac.cput.factory;

import za.ac.cput.domain.Payment;

public class PaymentFactory {

    public static Payment createPayment(Long paymentID, double amount, String status, String transactionCode) {
        // Basic validation
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
        // transactionCode can be null or empty, but you may add validation if needed

        return new Payment.Builder()
                .setPaymentId(paymentID)
                .setAmount(amount)
                .setStatus(status)
                .setTransactionCode(transactionCode)
                .build();
    }
}
