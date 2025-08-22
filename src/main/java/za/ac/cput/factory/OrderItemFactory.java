package za.ac.cput.factory;

import za.ac.cput.domain.OrderItem;

public class OrderItemFactory {

    public static OrderItem createOrderItem(int itemId, int productId, int quantity, double price) {
        // Basic validations
        if (itemId <= 0) {
            throw new IllegalArgumentException("Item ID must be greater than zero");
        }
        if (productId <= 0) {
            throw new IllegalArgumentException("Product ID must be greater than zero");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }

        return new OrderItem.Builder()
                .itemId(itemId)
                .productId(productId)
                .quantity(quantity)
                .price(price)
                .build();
    }
}
