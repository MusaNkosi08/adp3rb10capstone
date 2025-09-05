/*
SupplyOrderFactory.java
Author: [Your Name] (Your Student Number)
 */

package za.ac.cput.factory;

import za.ac.cput.domain.SupplyOrder;
import za.ac.cput.domain.Supplier;

import java.util.Date;

public class SupplyOrderFactory {

    public static SupplyOrder createSupplyOrder(Long orderID, Long employeeID, String orderDetails, Date orderDate, Supplier supplier, String orderStatus, double orderPrice) {
        // Validate required fields
        if (orderID == null) {
            throw new IllegalArgumentException("Error: Order ID cannot be null.");
        }
        if (employeeID == null) {
            throw new IllegalArgumentException("Error: Employee ID cannot be null.");
        }
        if (supplier == null) {
            throw new IllegalArgumentException("Error: Supplier cannot be null.");
        }
        if (orderPrice <= 0) {
            throw new IllegalArgumentException("Error: Order price must be greater than 0.");
        }
        // Build and return the SupplyOrder object
        return new SupplyOrder.Builder()
                .setOrderID(orderID)
                .setSupplier(supplier)
                .setEmployeeID(employeeID)
                .setOrderDetails(orderDetails)
                .setOrderDate(orderDate)
                .setOrderStatus(orderStatus)
                .setOrderPrice(orderPrice)
                .build();
    }
}