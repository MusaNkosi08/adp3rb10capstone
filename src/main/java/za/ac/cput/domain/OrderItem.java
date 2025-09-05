package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "book_isbn", referencedColumnName = "isbn")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private Order order;

    protected OrderItem() {}

    private OrderItem(Builder builder) {
        this.itemId = builder.itemId;
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.order = builder.order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public static class Builder {
        private int itemId;
        private int quantity;
        private double price;
        private Order order;

        public Builder itemId(int itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder order(Order order) {
            this.order = order;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }

        public Builder productId(int productId) {
            return this;
        }
    }

    public double totalPrice() {
        return quantity * price;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
