package za.ac.cput.domain;

public class Payment {
    private String paymentID;
    private double amount;
    private String status;
    private String transactionCode;

    // Private constructor
    private Payment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.amount = builder.amount;
        this.status = builder.status;
        this.transactionCode = builder.transactionCode;
    }

    // Getter methods
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

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", transactionCode='" + transactionCode + '\'' +
                '}';
    }

    // Methods
    public void processPayment() {
        System.out.println("Processing payment of " + amount + " with ID " + paymentID);
        this.status = "Processed";
    }

    public void refundPayment() {
        System.out.println("Refunding payment of " + amount + " with ID " + paymentID);
        this.status = "Refunded";
    }

    public boolean verifyTransaction() {
        return transactionCode != null && !transactionCode.isEmpty();
    }

    // Builder Class
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
}
