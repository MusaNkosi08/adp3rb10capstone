/*
SupplyFactory.java
Author: Musa Banathi Nkosi
        221744517
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Supply;

public class SupplyFactory {

    public static Supply createSupply(String orderID, double orderPrice, int quantity, String abcSupplies) {
        // Trim input values to avoid trailing spaces being considered as valid inputs
        orderID = orderID != null ? orderID.trim() : "";

        // Validate required fields
        if (orderID.isEmpty()) {
            throw new IllegalArgumentException("Error: Order ID cannot be empty.");
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