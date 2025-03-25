package za.ac.cput.domain;

public class OrderItem {

    private int itemId;
    private int quantity;
    private double price;

    public OrderItem(int itemId, int quantity, double price) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
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
