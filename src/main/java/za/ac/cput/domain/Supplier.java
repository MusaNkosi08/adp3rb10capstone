package za.ac.cput.domain;

public class Supplier {
    private final String name;
    private final String address;
    private final String email;
    private final String phoneNumber;
    private final String website;

    // Private constructor
    private Supplier(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.website = builder.website;
    }

    // Getters
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
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    // Static inner Builder class
    public static class Builder {
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

