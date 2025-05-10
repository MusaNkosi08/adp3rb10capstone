/*
Supply.java
Author: Musa Banathi Nkosi
        221744517
 */

package za.ac.cput.domain;

public class Supply {
    // Private attributes
    private String orderID;
    private double orderPrice;
    private int quantity;

    // Private constructor that initializes a Supply object using the Builder
    private Supply(Builder builder) {
        this.orderID = builder.orderID;
        this.orderPrice = builder.orderPrice;
        this.quantity = builder.quantity;
    }

    // Getters
    public String getOrderID() {
        return orderID;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    // Returns a string representation of the Supply object
    @Override
    public String toString() {
        return "Supply{" +
                "orderID='" + orderID + '\'' +
                ", orderPrice=" + orderPrice +
                ", quantity=" + quantity +
                '}';
    }

    // Checks if there is stock available
    public boolean checkStock() {
        return quantity > 0;
    }

    // Increases the order price by the specified amount
    public void restock(double amount) {
        this.orderPrice += amount;
    }

    public String getSupplierName() {
        return null; // Placeholder implementation
    }

    // Builder Class
    public static class Builder {
        private String orderID;
        private double orderPrice;
        private int quantity;

        // Sets the order ID
        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        // Sets the order price
        public Builder setOrderPrice(double orderPrice) {
            this.orderPrice = orderPrice;
            return this;
        }

        // Sets the quantity
        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        // Builds and returns a Supply object
        public Supply build() {
            return new Supply(this);
        }
    }
}