package za.ac.cput.factory;

import za.ac.cput.domain.Contact;

public class ContactFactory {
    public static Contact createContact(String email, String phoneNumber, String address, String password) {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Invalid address");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Invalid password");
        }
        return new Contact(email, phoneNumber, address, password);
    }
}
