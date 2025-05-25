package za.ac.cput.factory;

/* SupplyLineFactory.java
  Author: Ashton Petersen (220219494)
  Date: 11 May 2025
*/

import za.ac.cput.domain.SupplyLine;

public class SupplyLineFactory {

    public static SupplyLine createSupplyLine(int lineID, int orderID, String bookID, int quantity) {
        return new SupplyLine.Builder(lineID,orderID,bookID,quantity).build();
    }
}
