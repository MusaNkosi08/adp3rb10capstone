package za.ac.cput.factory;

/* SupplierFactory.java
     Supplier Factory domain class
     Author: TT Ntate (221817816)
     Date: 11 May 2025 */ 

import za.ac.cput.domain.Supplier;

public class SupplierFactory {

    // Private constructor to prevent instantiation
    private SupplierFactory() {
    }

    /**
     * Creates a Supplier with mandatory fields only.
     */
    public static Supplier createSupplier(String name) {
        return new Supplier.Builder(name)
                .build();
    }

    /**
     * Creates a Supplier with all fields.
     */
    public static Supplier createSupplier(String name, String address, String email, String phoneNumber, String website) {
        return new Supplier.Builder(name)
                .address(address)
                .email(email)
                .phoneNumber(phoneNumber)
                .website(website)
                .build();
    }

    /**
     * Creating a basic Supplier with name and email only.
     */
    public static Supplier createSupplierWithEmail(String name, String email) {
        return new Supplier.Builder(name)
                .email(email)
                .build();
    }
}

