package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import java.util.List;

public class OrderFactory {


    public static Order createOrder(int orderId, int customerId, String shippingAddress, String paymentMethod) {
        return new Order.Builder()
                .orderId(orderId)
                .customerId(customerId)
                .shippingAddress(shippingAddress)
                .paymentMethod(paymentMethod)
                .build();
    }


    public static Order createOrderWithItems(int orderId, int customerId, String shippingAddress, String paymentMethod, List<OrderItem> items) {
        return new Order.Builder()
                .orderId(orderId)
                .customerId(customerId)
                .shippingAddress(shippingAddress)
                .paymentMethod(paymentMethod)
                .items(items)
                .build();
    }
}
