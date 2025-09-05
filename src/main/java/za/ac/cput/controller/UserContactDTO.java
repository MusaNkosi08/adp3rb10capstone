package za.ac.cput.controller;

import za.ac.cput.domain.Contact;

public class UserContactDTO {
    public Long userId;
    public String userFirstName;
    public String userLastName;
    public String role;
    public ContactDTO contact;

    public Contact toContact() {
        if (contact == null) return null;
        return new Contact(contact.email, contact.phoneNumber, contact.address, contact.password);
    }

    public static class ContactDTO {
        public String email;
        public String phoneNumber;
        public String address;
        public String password;
    }
}
