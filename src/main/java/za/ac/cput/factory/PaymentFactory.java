package za.ac.cput.factory;

import za.ac.cput.domain.Payment;

public class PaymentFactory {
    public static Payment createPayment(String paymentID, double amount, String status, String transactionCode) {
        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setAmount(amount)
                .setStatus(status)
                .setTransactionCode(transactionCode)
                .build();
    }
}
