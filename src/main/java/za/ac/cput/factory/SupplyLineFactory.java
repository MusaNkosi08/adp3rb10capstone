
package za.ac.cput.factory;

import za.ac.cput.domain.SupplyLine;

public class SupplyLineFactory {

    public static SupplyLine createSupplyLine(int lineID,int orderID, int bookID, int quantity) {
        return new SupplyLine.Builder(lineID,orderID,bookID,quantity).build();
    }
}
