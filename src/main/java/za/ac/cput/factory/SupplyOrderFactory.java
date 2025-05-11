/*
SupplyOrderFactory.java
Author: [Your Name] (Your Student Number)
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Supply;

public class SupplyOrderFactory {

    public static Supply createSupply(String orderID, double orderPrice, int quantity, String supplierName) {
        // Trim input values to avoid leading/trailing spaces being considered as valid inputs
        orderID = orderID != null ? orderID.trim() : "";
        supplierName = supplierName != null ? supplierName.trim() : "";

        // Validate required fields
        if (orderID.isEmpty()) {
            throw new IllegalArgumentException("Error: Order ID cannot be empty.");
        }
        if (supplierName.isEmpty()) {
            throw new IllegalArgumentException("Error: Supplier name cannot be empty.");
        }

        // Validate order price and quantity
        if (orderPrice <= 0) {
            throw new IllegalArgumentException("Error: Order price must be greater than 0.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Error: Quantity cannot be negative.");
        }

        // Build and return the Supply object
        return new Supply.Builder()
                .setOrderID(orderID)
                .setOrderPrice(orderPrice)
                .setQuantity(quantity)
                .build();
    }
}