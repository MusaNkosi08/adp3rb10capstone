package za.ac.cput.domain;

/* SupplyLine.java
  Author: Ashton Petersen (220219494)
  Date: 11 May 2025
*/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SupplyLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lineID;
    private int orderId;
    private String bookIsbn;
    private int quantity;

    public SupplyLine(Builder builder) {
        this.lineID = builder.lineOrder;
        this.orderId = builder.orderId;
        this.bookIsbn = builder.bookId;
        this.quantity = builder.quantity;
    }

    public SupplyLine() {

    }

    public int getLineID() {
        return lineID;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public static class Builder {
        private int lineOrder;
        private int orderId;
        private String bookId;
        private int quantity;

        public Builder (int lineOrder, int orderId, String bookId, int quantity) {
            this.lineOrder = lineOrder;
            this.orderId = orderId;
            this.bookId = bookId;
            this.quantity = quantity;
        }

        public void setLineOrder(int lineOrder) {
            this.lineOrder = lineOrder;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public void setBookId(String bookId) {
            this.bookId = bookId;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public SupplyLine build() {
            return new SupplyLine(this);
        }

    }
}
