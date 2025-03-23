package za.ac.cput.factory;

import za.ac.cput.domain.Payment;

public  class PaymentFactory {
    public Payment createPayment(String paymentID, double amount, String status, String transactionCode) {
        return new Payment(paymentID, amount, status, transactionCode);
    }
}
