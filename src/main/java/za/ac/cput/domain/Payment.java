package za.ac.cput.domain;

public class Payment {
    private String paymentID;
    private double amount;
    private String status;
    private String transactionCode;

    // Constructor
    public Payment(String paymentID, double amount, String status, String transactionCode) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.status = status;
        this.transactionCode = transactionCode;
    }

    // Getter and Setter methods
    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String getTransactionCode() {
        return transactionCode;
    }

    private void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
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
}
