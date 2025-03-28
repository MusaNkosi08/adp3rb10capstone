package za.ac.cput;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.repository.impl.PaymentRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Order order = new Order(1, 123, "123 Main St, Anytown", "Credit Card");
        order.addItem(new OrderItem(1, 2, 10.0));
        order.addItem(new OrderItem(2, 1, 15.0));
        System.out.println(order.getOrderDetails());

        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(3, 1, 20.0));
        items.add(new OrderItem(4, 3, 5.0));
        Order order2 = OrderFactory.createOrder(456, "456 Elm St, Othertown", "PayPal", items);
        System.out.println(order2.getOrderDetails());

        // Creating Payment Repository
        PaymentRepository paymentRepo = new PaymentRepository();
        List<Payment> paymentList = new ArrayList<>();

        // Creating payments using the Builder Pattern
        Payment payment1 = new Payment.Builder()
                .setPaymentID("P001")
                .setAmount(250.00)
                .setStatus("Pending")
                .setTransactionCode("TXN123")
                .build();

        Payment payment2 = new Payment.Builder()
                .setPaymentID("P002")
                .setAmount(500.00)
                .setStatus("Completed")
                .setTransactionCode("TXN456")
                .build();

        Payment payment3 = new Payment.Builder()
                .setPaymentID("P003")
                .setAmount(100.00)
                .setStatus("Pending")
                .setTransactionCode("TXN789")
                .build();

        // Adding payments to the list
        paymentList.add(payment1);
        paymentList.add(payment2);
        paymentList.add(payment3);

        // Attempt to add payments to the repository (will return null based on current implementation)
        for (Payment payment : paymentList) {
            if (paymentRepo.create(payment) == null) {
                System.out.println("Failed to add payment: " + payment.getPaymentID());
            }
        }

        // Display all payments (will return empty list based on current implementation)
        System.out.println("\nAll Payments:");
        List<Payment> allPayments = paymentRepo.findAll();
        if (!allPayments.isEmpty()) {
            allPayments.forEach(System.out::println);
        } else {
            System.out.println("No payments found.");
        }

        // Process a payment (method will always return false)
        System.out.println("\nProcessing Payment P001...");
        if (paymentRepo.processPayment("P001")) {
            System.out.println("Payment P001 processed successfully.");
        } else {
            System.out.println("Failed to process Payment P001.");
        }

        // Refund a payment (method will always return false)
        System.out.println("\nRefunding Payment P002...");
        if (paymentRepo.refundPayment("P002")) {
            System.out.println("Payment P002 refunded successfully.");
        } else {
            System.out.println("Failed to refund Payment P002.");
        }

        // Verify a transaction (method will always return false)
        System.out.println("\nVerifying Payment P003...");
        if (paymentRepo.verifyTransaction("P003")) {
            System.out.println("Payment P003 verified successfully.");
        } else {
            System.out.println("Failed to verify Payment P003.");
        }

        // Find payments above a certain amount (will return empty list)
        System.out.println("\nPayments above R200:");
        List<Payment> paymentsAbove = paymentRepo.findPaymentsAboveAmount(200);
        if (!paymentsAbove.isEmpty()) {
            paymentsAbove.forEach(System.out::println);
        } else {
            System.out.println("No payments found above R200.");
        }

        // Find payments by status (will return empty list)
        System.out.println("\nPending Payments:");
        List<Payment> pendingPayments = paymentRepo.findByStatus("Pending");
        if (!pendingPayments.isEmpty()) {
            pendingPayments.forEach(System.out::println);
        } else {
            System.out.println("No pending payments found.");
        }
    }
}