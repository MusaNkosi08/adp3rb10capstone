package za.ac.cput.factory;

/* SupplyLineFactory.java
  Author: Ashton Petersen (220219494)
  Date: 11 May 2025
*/

import za.ac.cput.domain.SupplyLine;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.Book;

public class SupplyLineFactory {

    public static SupplyLine createSupplyLine(Long lineID, Order order, Book book, int quantity) {
        return new SupplyLine.Builder(lineID, order, book, quantity).build();
    }
}
