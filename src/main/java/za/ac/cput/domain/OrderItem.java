package za.ac.cput.domain;

//tyrese ntate 221817816

public class OrderItem {

    private int itemId;
    private int quantity;
    private double price;

   
    private OrderItem(Builder builder) {
        this.itemId = builder.itemId;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

  
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
