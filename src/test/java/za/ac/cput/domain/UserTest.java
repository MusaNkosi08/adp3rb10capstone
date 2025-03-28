package za.ac.cput.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class UserTest {

    User user1;
    User.UserBuilder builder1;
    User user2;
    User.UserBuilder builder2;

    @BeforeEach
    void setUp() {
        builder1 = new User.UserBuilder("58147","Alex","Peterson","alexpeterson@gmail.com","password456","0764578976");
        builder2 = new User.UserBuilder("59812","Adam","Isaacs","adamisaacs@gmail.com","password789","0824569821");

    }

    @Test

    void testToString(){
        String toString = user1.toString();
        assertTrue(toString.contains("Alex"));
        assertTrue(toString.contains("Peterson"));
        assertTrue(toString.contains("alexpeterson@gmail.com"));
        assertTrue(toString.contains("password456"));


    }

}
