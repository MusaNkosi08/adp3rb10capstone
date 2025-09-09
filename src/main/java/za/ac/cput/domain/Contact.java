package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.Objects;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;

    protected Contact() {}

    public Contact(String email, String phoneNumber, String address, String password) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
    }

    private Contact(Builder builder) {
        this.contactId = builder.contactId;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.password = builder.password;
    }

    public Long getContactId() { return contactId; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public String getPassword() { return password; }



    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(getContactId(), contact.getContactId()) &&
                Objects.equals(getEmail(), contact.getEmail()) &&
                Objects.equals(getPhoneNumber(), contact.getPhoneNumber()) &&
                Objects.equals(getAddress(), contact.getAddress()) &&
                Objects.equals(getPassword(), contact.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContactId(), getEmail(), getPhoneNumber(), getAddress(), getPassword());
    }

    public static class Builder {
        private Long contactId;
        private String email;
        private String phoneNumber;
        private String address;
        private String password;

        public Builder setContactId(Long contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}
