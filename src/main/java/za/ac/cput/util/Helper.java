package za.ac.cput.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Date;

public class Helper {




    public static Boolean verifyisbn(String isbn) {
        if ((isbn.length() != 10) && (isbn.length() != 13)) {
            return false;
        }
        if (isbn.matches(".*[a-z].*")) {
            return false;
        }
        return true;
    }

    public static Boolean verifyemail(String email) {
        if ((email == null) || (email.length() == 0)) {
            return false;
        }
        if ((!email.contains("@")) || (!email.contains("."))) {
            return false;
        }
        return true;
    }

    public static Boolean verifyPhoneNumber(String phoneNumber) {
        if ((phoneNumber == null) || (phoneNumber.matches(".*[a-z].*"))) {
            return false;
        }
        if ((phoneNumber.length() != 10) || (phoneNumber.length() != 12)) {
            return false;
        }
        return true;
    }
// === SUPPLY ORDER VALIDATIONS BELOW ===

    public static boolean verifyOrderID(String orderID) {
        return orderID != null && !orderID.trim().isEmpty() && orderID.length() >= 5;
    }

    public static boolean verifySupplierID(String supplierID) {
        return supplierID != null && !supplierID.trim().isEmpty();
    }

    public static boolean verifyOrderPrice(double orderPrice) {
        return orderPrice >= 0.0;
    }

    public static boolean verifyOrderDate(Date orderDate) {
        return orderDate != null && !orderDate.after(new Date());
    }

    public static boolean verifyOrderStatus(String status) {
        if (status == null) return false;
        String cleanStatus = status.trim().toLowerCase();
        return cleanStatus.equals("pending") ||
                cleanStatus.equals("shipped") ||
                cleanStatus.equals("delivered") ||
                cleanStatus.equals("cancelled");
    }

    public static boolean isValidSupplyOrder(String orderID, String supplierID, double price, Date date, String status) {
        return verifyOrderID(orderID) &&
                verifySupplierID(supplierID) &&
                verifyOrderPrice(price) &&
                verifyOrderDate(date) &&
                verifyOrderStatus(status);
    }
}