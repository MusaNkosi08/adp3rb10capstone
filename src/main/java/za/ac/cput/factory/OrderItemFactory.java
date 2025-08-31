package za.ac.cput.factory;

import za.ac.cput.domain.Book;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.util.Helper;

public class OrderItemFactory {

    public static OrderItem createOrderItem(
            //int itemId,
            Book book, Order order, int quantity
            // , double price
            ) {
        // Basic validations
      /*  if (itemId <= 0) {
            throw new IllegalArgumentException("Item ID must be greater than zero");
        } */


        if (Helper.verifyisbn(book.getIsbn())) {
            throw new IllegalArgumentException("Product ID must be greater than zero");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        /*
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
    */
        return new OrderItem.Builder()
            //    .itemId(itemId)
                .order(order)
                .book(book)
                .quantity(quantity)
                .build();
    }
}
