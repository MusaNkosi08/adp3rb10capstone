package za.ac.cput.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class SupplyOrder implements Serializable {

    @Id
    private String orderID;

    private String employeeID;
    private String orderDetails;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    private String supplierID;
    private double orderPrice;
    private String orderStatus;

    // Constructors
    public SupplyOrder() {}

    private SupplyOrder(Builder builder) {
        this.orderID = builder.orderID;
        this.employeeID = builder.employeeID;
        this.orderDetails = builder.orderDetails;
        this.orderDate = builder.orderDate;
        this.supplierID = builder.supplierID;
        this.orderPrice = builder.orderPrice;
        this.orderStatus = builder.orderStatus;
    }

    // Getters
    public String getOrderID() { return orderID; }
    public String getEmployeeID() { return employeeID; }
    public String getOrderDetails() { return orderDetails; }
    public Date getOrderDate() { return orderDate; }
    public String getSupplierID() { return supplierID; }
    public double getOrderPrice() { return orderPrice; }
    public String getOrderStatus() { return orderStatus; }

    // Business Logic
    public String displayStatus() {
        return "Order Status: " + orderStatus;
    }

    public void cancelOrder() {
        this.orderStatus = "Cancelled";
    }

    @Override
    public String toString() {
        return "SupplyOrder{" +
                "orderID='" + orderID + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", orderDetails='" + orderDetails + '\'' +
                ", orderDate=" + orderDate +
                ", supplierID='" + supplierID + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }

    // Builder class
    public static class Builder {
        private String orderID;
        private String employeeID;
        private String orderDetails;
        private Date orderDate;
        private String supplierID;
        private double orderPrice;
        private String orderStatus;

        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setEmployeeID(String employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public Builder setOrderDetails(String orderDetails) {
            this.orderDetails = orderDetails;
            return this;
        }

        public Builder setOrderDate(Date orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setSupplierID(String supplierID) {
            this.supplierID = supplierID;
            return this;
        }

        public Builder setOrderPrice(double orderPrice) {
            this.orderPrice = orderPrice;
            return this;
        }

        public Builder setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public SupplyOrder build() {
            return new SupplyOrder(this);
        }
    }
}
