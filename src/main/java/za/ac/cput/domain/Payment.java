package za.ac.cput.domain;

public class Payment {
    private String paymentID;
    private double amount;
    private String status;
    private String transactionCode;

    // Private constructor to enforce the use of the Builder pattern
    private Payment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.amount = builder.amount;
        this.status = builder.status;
        this.transactionCode = builder.transactionCode;
    }

    // Getter methods to access private attributes
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

    // Overriding toString() to provide a string representation of the Payment object
    @Override
    public String toString() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", transactionCode='" + transactionCode + '\'' +
                '}';
    }

    // Method to process the payment and update its status
    public void processPayment() {
        System.out.println("Processing payment of " + amount + " with ID " + paymentID);
        this.status = "Processed"; // Update status to "Processed"
    }

    // Method to refund the payment and update its status
    public void refundPayment() {
        System.out.println("Refunding payment of " + amount + " with ID " + paymentID);
        this.status = "Refunded"; // Update status to "Refunded"
    }

    // Method to verify if the transaction code is valid (not null or empty)
    public boolean verifyTransaction() {
        return transactionCode != null && !transactionCode.isEmpty();
    }

    // Builder Class for constructing Payment objects
    public static class Builder {
        private String paymentID;
        private double amount;
        private String status;
        private String transactionCode;

        // Setter methods for setting values in the Builder pattern
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

        // Method to construct and return a Payment object
        public Payment build() {
            return new Payment(this);
        }
    }
}
