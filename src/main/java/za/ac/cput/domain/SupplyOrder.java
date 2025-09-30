package za.ac.cput.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
public class SupplyOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;

    private Long employeeID;
    private String orderDetails;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplierID")
    private Supplier supplier;
    private double orderPrice;
    private String orderStatus;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime supplyOrderTimestamp;

    // Constructors
    public SupplyOrder() {}

    private SupplyOrder(Builder builder) {
        this.orderID = builder.orderID;
        this.employeeID = builder.employeeID;
        this.orderDetails = builder.orderDetails;
        this.orderDate = builder.orderDate;
        this.supplier = builder.supplier;
        this.orderPrice = builder.orderPrice;
        this.orderStatus = builder.orderStatus;
    }

    // Getters
    public Long getOrderID() {
        return orderID;
    }
    public Long getEmployeeID() {
        return employeeID;
    }
    public String getOrderDetails() {
        return orderDetails;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public Supplier getSupplier() {
        return supplier;
    }
    public double getOrderPrice() {
        return orderPrice;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public LocalDateTime getSupplyOrderTimestamp() {
        return supplyOrderTimestamp;
    }

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
                ", supplier='" + (supplier != null ? supplier.getSupplierID() : null) + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }

    // Builder class
    public static class Builder {
        private Long orderID;
        private Long employeeID;
        private String orderDetails;
        private Date orderDate;
        private Supplier supplier;
        private double orderPrice;
        private String orderStatus;

        public Builder setOrderID(Long orderID) {
            this.orderID = orderID;
            return this;
        }
        public Builder setEmployeeID(Long employeeID) {
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

        public Builder setSupplier(Supplier supplier) {
            this.supplier = supplier;
            return this;
        }

        public Builder setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder setOrderPrice(double orderPrice) {
            this.orderPrice = orderPrice;
            return this;
        }

        public SupplyOrder build() {
            return new SupplyOrder(this);
        }
    }
}
