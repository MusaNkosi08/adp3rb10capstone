package za.ac.cput.domain;

public class OrderItem {

    private int itemId;
    private int quantity;
    private double price;

    // Private constructor that accepts a Builder instance.
    private OrderItem(Builder builder) {
        this.itemId = builder.itemId;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    // Static nested Builder class.
    public static class Builder {
        private int itemId;
        private int quantity;
        private double price;

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

        public OrderItem build() {
            return new OrderItem(this);
        }
    }

    // Calculate the total price for the order item.
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
