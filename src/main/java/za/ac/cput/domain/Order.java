package za.ac.cput.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private int orderId;
    private int customerId;
    private Date orderDate;
    private String status;
    private double totalAmount;
    private String shippingAddress;
    private String paymentMethod;
    private List<OrderItem> items;

    public Order(int orderId, int customerId, String shippingAddress, String paymentMethod) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = new Date();
        this.status = "Pending";
        this.totalAmount = 0.0;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.items = new ArrayList<>();
    }

    public double calculateTotal() {
        totalAmount = items.stream().mapToDouble(OrderItem::totalPrice).sum();
        return totalAmount;
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void addItem(OrderItem item) {
        items.add(item);
        calculateTotal();
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
        calculateTotal();
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Order ID: ").append(orderId).append("\n");
        details.append("Customer ID: ").append(customerId).append("\n");
        details.append("Order Date: ").append(orderDate).append("\n");
        details.append("Status: ").append(status).append("\n");
        details.append("Total Amount: ").append(String.format("%.2f", totalAmount)).append("\n");
        details.append("Shipping Address: ").append(shippingAddress).append("\n");
        details.append("Payment Method: ").append(paymentMethod).append("\n");
        details.append("Items:\n");
        for (OrderItem item : items) {
            details.append(" - Item ID: ").append(item.getItemId())
                    .append(", Quantity: ").append(item.getQuantity())
                    .append(", Price: ").append(String.format("%.2f", item.getPrice())).append("\n");
        }
        return details.toString();
    }

}
