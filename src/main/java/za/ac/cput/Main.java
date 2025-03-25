package za.ac.cput;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.repository.PaymentRepository;

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

        Payment payment1 = new Payment.Builder()
                .setPaymentID("P001")
                .setAmount(150.75)
                .setStatus("Pending")
                .setTransactionCode("TXN001")
                .build();


        PaymentRepository paymentRepo = new PaymentRepository();
        paymentRepo.addPayment(payment1);


        paymentRepo.getPayment("P001");


        payment1.processPayment();
        paymentRepo.updatePayment(payment1);


        payment1.refundPayment();
        paymentRepo.updatePayment(payment1);


        paymentRepo.listPayments();

        paymentRepo.deletePayment("P001");
        paymentRepo.listPayments();
    }

}
