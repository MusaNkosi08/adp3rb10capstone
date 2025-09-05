package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

/* User.java
   Author: Aimee Paulus (222814969)
   Date: 21 March 2025
*/
@Entity
@Table(name = "users") // optional but recommended
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userFirstName;
    private String userLastName;
    private String role;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    // Required by JPA
    protected User() {}

    private User(UserBuilder builder){
        this.userId = builder.userId;
        this.userFirstName = builder.userFirstName;
        this.userLastName = builder.userLastName;
        this.role = builder.role;
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

    public Contact getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", role='" + role + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class UserBuilder {
        private Long userId;
        private String userFirstName;
        private String userLastName;
        private String role;
        private Contact contact;

        public UserBuilder() {}

        public UserBuilder(Long userId, String userFirstName, String userLastName, String role, Contact contact) {
        }

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

        public UserBuilder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
