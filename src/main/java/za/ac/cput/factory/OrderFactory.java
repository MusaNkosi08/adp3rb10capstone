package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import java.util.List;

public class OrderFactory {

    private static int orderCounter = 1; // To generate unique order IDs

    public static Order createOrder(int customerId, String shippingAddress, String paymentMethod) {
        return new Order(orderCounter++, customerId, shippingAddress, paymentMethod);
    }

    public static Order createOrder(int customerId, String shippingAddress, String paymentMethod, List<OrderItem> items) {
        Order order = createOrder(customerId, shippingAddress, paymentMethod);
        for (OrderItem item : items) {
            order.addItem(item);
        }
        return order;
    }
}
