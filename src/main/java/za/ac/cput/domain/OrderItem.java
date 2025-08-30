package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "isbn", referencedColumnName = "isbn")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private Order order;

    protected OrderItem() {}

    private OrderItem(Builder builder) {
        this.itemId = builder.itemId;
        this.quantity = builder.quantity;
        this.book= builder.book;
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

        private Order order;
        private Book book;

        public Builder itemId(int itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }



        public Builder order(Order order) {
            this.order = order;
            return this;
        }

        public Builder book(Book book) {
            this.book = book;
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
        return quantity * book.price;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

}
