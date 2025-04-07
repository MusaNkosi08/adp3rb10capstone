package za.ac.cput.util;

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
        if ((phoneNumber.length() != 10)||(phoneNumber.length() != 12)) {
            return false;
        }
        return true;
    }
}
