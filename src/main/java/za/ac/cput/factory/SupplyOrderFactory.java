/*
SupplyOrderFactory.java
Author: [Your Name] (Your Student Number)
 */

package za.ac.cput.factory;

import za.ac.cput.domain.SupplyOrder;

import java.util.Date;

public class SupplyOrderFactory {

    public static SupplyOrder createSupplyOrder(String orderID, String employeeID, String orderDetails, Date orderDate, String supplierID, String orderStatus, double orderPrice) {
        // Trim input values to avoid leading/trailing spaces being considered as valid inputs
        orderID = orderID != null ? orderID.trim() : "";
        employeeID = employeeID != null ? employeeID.trim() : "";
        supplierID = supplierID != null ? supplierID.trim() : "";

        // Validate required fields
        if (orderID.isEmpty()) {
            throw new IllegalArgumentException("Error: Order ID cannot be empty.");
        }
        if (employeeID.isEmpty()) {
            throw new IllegalArgumentException("Error: Employee ID cannot be empty.");
        }
        if (supplierID.isEmpty()) {
            throw new IllegalArgumentException("Error: Supplier ID cannot be empty.");
        }

        // Validate order price and quantity
        if (orderPrice <= 0) {
            throw new IllegalArgumentException("Error: Order price must be greater than 0.");
        }

        // Build and return the Supply object
        return new SupplyOrder.Builder()
                .setOrderID(orderID)
                .setSupplierID(supplierID)
                .setEmployeeID(employeeID)
                .setOrderDetails(orderDetails)
                .setOrderDate(orderDate)
                .setOrderStatus(orderStatus)
                .setOrderPrice(orderPrice)
                .build();
    }
}