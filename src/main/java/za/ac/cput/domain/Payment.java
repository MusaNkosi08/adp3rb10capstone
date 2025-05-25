package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Payment {

    @Id
    private String paymentID;

    private double amount;
    private String status;
    private String transactionCode;

    protected Payment() {
        // JPA requires a default constructor
    }

    private Payment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.amount = builder.amount;
        this.status = builder.status;
        this.transactionCode = builder.transactionCode;
    }

    // Getters
    public String getPaymentID() {
        return paymentID;
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

    // Builder
    public static class Builder {
        private String paymentID;
        private double amount;
        private String status;
        private String transactionCode;

        public Builder setPaymentID(String paymentID) {
            this.paymentID = paymentID;
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
                "paymentID='" + paymentID + '\'' +
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
        return Objects.equals(paymentID, payment.paymentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentID);
    }
}