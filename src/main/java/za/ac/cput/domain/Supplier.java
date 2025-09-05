package za.ac.cput.domain;

/* Supplier.java
     Supplier domain class
     Author: TT Ntate (221817816)
     Date: 11 May 2025 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierID;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String website;

    // Private constructor
    private Supplier(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.website = builder.website;
    }

    public Supplier() {

    }

    // Getters
    public Long getSupplierID() {
        return supplierID;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID=" + supplierID +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    // Static inner Builder class
    public static class Builder {
        // Required fields
        private String name;
        private String address;
        private String email;
        private String phoneNumber;
        private String website;

        public Builder(String name) { // Mandatory field
            this.name = name;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder website(String website) {
            this.website = website;
            return this;
        }

        public Supplier build() {
            return new Supplier(this);
        }
    }
}

