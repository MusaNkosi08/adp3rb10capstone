package za.ac.cput.domain;

/* SupplyLine.java
  Author: Ashton Petersen (220219494)
  Date: 11 May 2025
*/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class SupplyLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineID;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "book_isbn", referencedColumnName = "isbn")
    private Book book;
    private int quantity;

    public SupplyLine(Builder builder) {
        this.lineID = builder.lineID;
        this.order = builder.order;
        this.book = builder.book;
        this.quantity = builder.quantity;
    }

    public SupplyLine() {

    }

    public Long getLineID() {
        return lineID;
    }

    public Order getOrder() {
        return order;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public static class Builder {
        private Long lineID;
        private Order order;
        private Book book;
        private int quantity;

        public Builder(Long lineID, Order order, Book book, int quantity) {
            this.lineID = lineID;
            this.order = order;
            this.book = book;
            this.quantity = quantity;
        }

        public Builder setLineID(Long lineID) {
            this.lineID = lineID;
            return this;
        }

        public Builder setOrder(Order order) {
            this.order = order;
            return this;
        }

        public Builder setBook(Book book) {
            this.book = book;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public SupplyLine build() {
            return new SupplyLine(this);
        }
    }
}
