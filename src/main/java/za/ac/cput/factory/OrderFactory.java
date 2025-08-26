package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Payment;

import java.util.List;

public class OrderFactory {

    public static Order createOrder(Long orderId, int customerId, String shippingAddress,
                                    String paymentMethod, List<OrderItem> items, Payment payment) {
        // Basic validations
        if (orderId != null && orderId <= 0) {
            throw new IllegalArgumentException("Order ID must be greater than zero");
        }
        if (customerId <= 0) {
            throw new IllegalArgumentException("Customer ID must be greater than zero");
        }
        if (shippingAddress == null || shippingAddress.isEmpty()) {
            throw new IllegalArgumentException("Shipping address cannot be null or empty");
        }
        if (paymentMethod == null || paymentMethod.isEmpty()) {
            throw new IllegalArgumentException("Payment method cannot be null or empty");
        }
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }
        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null");
        }

        Order order = new Order.Builder()
                .orderId(orderId)
                .customerId(customerId)
                .shippingAddress(shippingAddress)
                .paymentMethod(paymentMethod)
                .status("Pending")  // default status
                .items(items)
                .payment(payment)
                .build();

        // Set back-reference for each OrderItem
        for (OrderItem item : items) {

        }

        return order;
    }
}
