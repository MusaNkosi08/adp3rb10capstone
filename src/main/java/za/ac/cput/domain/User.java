package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // optional but recommended
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String userFirstName;

    @Column(name = "last_name")
    private String userLastName;

    @Column(name = "role")
    private String role;

    @Column(name = "email", unique = true)
    private String userEmail;

    @Column(name = "password")
    private String userPassword;

    @Column(name = "phone_number")
    private String userPhoneNumber;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    // Required by JPA
    protected User() {}

    private User(UserBuilder builder) {
        this.userId = builder.userId;
        this.userFirstName = builder.userFirstName;
        this.userLastName = builder.userLastName;
        this.role = builder.role;
        this.userEmail = builder.userEmail;
        this.userPassword = builder.userPassword;
        this.userPhoneNumber = builder.userPhoneNumber;
        this.contact = builder.contact;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getRole() {
        return role;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", role='" + role + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", contact=" + contact +
                '}';
    }

    // Builder Pattern
    public static class UserBuilder {
        private Long userId;
        private String userFirstName;
        private String userLastName;
        private String role;
        private String userEmail;
        private String userPassword;
        private String userPhoneNumber;
        private Contact contact;

        public UserBuilder() {}

        public UserBuilder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setUserFirstName(String userFirstName) {
            this.userFirstName = userFirstName;
            return this;
        }

        public UserBuilder setUserLastName(String userLastName) {
            this.userLastName = userLastName;
            return this;
        }

        public UserBuilder setRole(String role) {
            this.role = role;
            return this;
        }

        public UserBuilder setUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public UserBuilder setUserPassword(String userPassword) {
            this.userPassword = userPassword;
            return this;
        }

        public UserBuilder setUserPhoneNumber(String userPhoneNumber) {
            this.userPhoneNumber = userPhoneNumber;
            return this;
        }

        public UserBuilder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
