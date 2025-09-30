package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp;
    private String status;
    private double totalAmount;
    private String shippingAddress;
    private String paymentMethod;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    protected Order() {} // JPA needs this

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.user = builder.user;

        this.status = builder.status;
        this.shippingAddress = builder.shippingAddress;
        this.paymentMethod = builder.paymentMethod;
        this.items = builder.items != null ? builder.items : new ArrayList<>();
        this.payment = builder.payment;
        calculateTotal();
    }
    public double setTotalAmount(double totalAmount) {
        return this.totalAmount = totalAmount;
    }

    public Long getOrderId() { return orderId; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public LocalDateTime getTimeStamp() { return timestamp; }
    public String getStatus() { return status; }
    public double getTotalAmount() { return totalAmount; }
    public String getShippingAddress() { return shippingAddress; }
    public String getPaymentMethod() { return paymentMethod; }
    public List<OrderItem> getItems() { return items; }
    public Payment getPayment() { return payment; }

    public void setStatus(String status) { this.status = status;

    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setID(Long i) {
        this.orderId = i;
    }

    public static class Builder {
        private Long orderId;
        private User user;
        private String shippingAddress;
        private String paymentMethod;
        private String status = "Pending";
        private List<OrderItem> items = new ArrayList<>();
        private Payment payment;

        public Builder orderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder shippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public Builder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder items(List<OrderItem> items) {
            this.items = items;
            return this;
        }

        public Builder payment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();


    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void addItem(OrderItem item) {
        // item.setOrder(this); // Uncomment if OrderItem has @ManyToOne
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
        details.append("User ID: ").append(user != null ? user.getUserId() : "N/A").append("\n");
        details.append("Order Date: ").append(timestamp).append("\n");
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
