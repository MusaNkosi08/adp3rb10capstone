package za.ac.cput;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.OrderFactory;

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


        List<Payment> payments = new ArrayList<>();

        // Creating and adding Payment objects using the Builder pattern
        Payment payment1 = new Payment.Builder()
                .setPaymentID("P001")
                .setAmount(150.0)
                .setStatus("Pending")
                .setTransactionCode("TX12345")
                .build();

        Payment payment2 = new Payment.Builder()
                .setPaymentID("P002")
                .setAmount(200.0)
                .setStatus("Pending")
                .setTransactionCode("TX12346")
                .build();

        // Adding payments to the ArrayList
        payments.add(payment1);
        payments.add(payment2);

        // Processing each payment in the list
        for (Payment payment : payments) {
            System.out.println("Before Processing: " + payment);
            payment.processPayment();
            System.out.println("After Processing: " + payment);
            // Verifying transaction for each payment
            if (payment.verifyTransaction()) {
                System.out.println("Transaction for " + payment.getPaymentID() + " is verified.");
            } else {
                System.out.println("Transaction for " + payment.getPaymentID() + " is not verified.");
            }
            System.out.println();
        }

        // Refund a payment
        System.out.println("Refunding Payment 1...");
        payment1.refundPayment();
        System.out.println("After Refund: " + payment1);

    }
}
