package za.ac.cput.domain;

/* User.java
``Author: Aimee Paulus (222814969)
  Date: 21 March 2025
 */


public class User {
    private String userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private String userPhoneNumber;

    private User(UserBuilder builder){
        this.userId = builder.userId;
        this.userFirstName = builder.userFirstName;
        this.userLastName = builder.userLastName;
        this.userEmail = builder.userEmail;
        this.userPassword = builder.userPassword;
        this.userPhoneNumber = builder.userPhoneNumber;


    }


    public String getUserId() {
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

        public UserBuilder(String userId,String userFirstName,String userLastName, String userEmail,String userPassword, String userPhoneNumber){
            this.userId = userId;
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
