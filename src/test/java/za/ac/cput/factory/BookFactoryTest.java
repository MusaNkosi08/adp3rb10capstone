package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookFactoryTest {


@BeforeEach
    void setUp() {

}

@Test
    void blankStringCreation() {
    assertNotNull( BookFactory.createManyBooks("","","",20,null,3,88.20));
}

    @Test
    void negativeNumbersCreation() {
        assertNotNull( BookFactory.createManyBooks("A Series of Unfortunate Events: The Bad Beginning","Lemony Snicket","9780749746117",-68,"Comedy, Drama, Child Fiction",0,-40));
    }

}