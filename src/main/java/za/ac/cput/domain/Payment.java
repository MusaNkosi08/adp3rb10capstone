package za.ac.cput.domain;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Objects;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId; // Changed from paymentID to paymentId

    private double amount;
    private String status;
    private String transactionCode;

    protected Payment() {
        // JPA requires a default constructor
    }

    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.amount = builder.amount;
        this.status = builder.status;
        this.transactionCode = builder.transactionCode;
    }

    // Getters
    public Long getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    // Business methods
    public void processPayment() {
        this.status = "Processed";
    }

    public void refundPayment() {
        this.status = "Refunded";
    }

    public boolean verifyTransaction() {
        return transactionCode != null && !transactionCode.trim().isEmpty();
    }

    // Builder - FIXED METHOD NAMES
    public static class Builder {
        private Long paymentId; // Changed from paymentID to paymentId
        private double amount;
        private String status;
        private String transactionCode;

        public Builder setPaymentId(Long paymentId) { // Changed from setPaymentID to setPaymentId
            this.paymentId = paymentId;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setTransactionCode(String transactionCode) {
            this.transactionCode = transactionCode;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' + // Changed from paymentID to paymentId
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", transactionCode='" + transactionCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paymentId, payment.paymentId); // Changed from paymentID to paymentId
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId); // Changed from paymentID to paymentId
    }
}