package za.ac.cput;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.factory.PaymentFactory;
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

        // Initializing Payment Repository
        PaymentRepository paymentRepo = new PaymentRepository();

        // Creating Payment instances
        Payment payment1 = PaymentFactory.createPayment("P001", 250.00, "Pending", "TXN1234");
        Payment payment2 = PaymentFactory.createPayment("P002", 500.00, "Completed", "TXN5678");
        Payment payment3 = PaymentFactory.createPayment("P003", 100.00, "Pending", "TXN91011");

        // Adding payments to repository
        paymentRepo.create(payment1);
        paymentRepo.create(payment2);
        paymentRepo.create(payment3);

        // Display all payments
        System.out.println("\nAll Payments:");
        paymentRepo.findAll().forEach(System.out::println);


        // Process a payment
        System.out.println("\nProcessing Payment P001...");
        paymentRepo.processPayment("P001");
        System.out.println("Updated Payment Details: " + paymentRepo.read("P001"));

        // Refund a payment
        System.out.println("\nRefunding Payment P002...");
        paymentRepo.refundPayment("P002");
        System.out.println("Updated Payment Details: " + paymentRepo.read("P002"));

        // Find payments above a certain amount
        System.out.println("\nPayments above R200:");
        paymentRepo.findPaymentsAboveAmount(200).forEach(System.out::println);

        // Find payments by status
        System.out.println("\nPending Payments:");
        paymentRepo.findByStatus("Pending").forEach(System.out::println);
    }
}
