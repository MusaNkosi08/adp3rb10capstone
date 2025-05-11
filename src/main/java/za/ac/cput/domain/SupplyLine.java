package za.ac.cput.domain;

public class SupplyLine {
    private int lineOrder;
    private int orderId;
    private int bookId;
    private int quantity;

    public SupplyLine(Builder builder) {
        this.lineOrder = builder.lineOrder;
        this.orderId = builder.orderId;
        this.bookId = builder.bookId;
        this.quantity = builder.quantity;
    }

    public int getLineOrder() {
        return lineOrder;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public static class Builder {
        private int lineOrder;
        private int orderId;
        private int bookId;
        private int quantity;

        public Builder (int lineOrder, int orderId, int bookId, int quantity) {
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

        public void setBookId(int bookId) {
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
