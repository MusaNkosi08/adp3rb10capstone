package za.ac.cput.domain;

import jakarta.persistence.*;

/* User.java
``Author: Aimee Paulus (222814969)
  Date: 21 March 2025
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "first_name")
    private String userFirstName;
    @Column(name = "last_name")
    private String userLastName;
    @Column(name = "email", unique = true)
    private String userEmail;
    @Column(name = "password")
    private String userPassword;
    @Column(name = "phone_number")
    private String userPhoneNumber;

    protected User() {

    }
    private User(UserBuilder builder){
        this.userFirstName = builder.userFirstName;
        this.userLastName = builder.userLastName;
        this.userEmail = builder.userEmail;
        this.userPassword = builder.userPassword;
        this.userPhoneNumber = builder.userPhoneNumber;


    }




    public int getUserId() {
        return userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
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

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                '}';
    }

    public static class UserBuilder{
        private String userId;
        private String userFirstName;
        private String userLastName;
        private String userEmail;
        private String userPassword;
        private String userPhoneNumber;

        public UserBuilder(int userId, String userFirstName, String userLastName, String userEmail, String userPassword, String userPhoneNumber){
            this.userFirstName = userFirstName;
            this.userLastName = userLastName;
            this.userEmail = userEmail;
            this.userPassword = userPassword;
            this.userPhoneNumber = userPhoneNumber;
        }

        public UserBuilder setUserId(String userId) {
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

        public User build(){ return new User(this);
        }
    }
}
