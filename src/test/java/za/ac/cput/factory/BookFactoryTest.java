package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookFactoryTest {

   @Test
   void createBooks() {
       assertNotNull(BookFactory.createBook("9780316137973", "You've Been Warned","James Patterson & Howard Roughan", 200,"Thriller",83.72));
   }

  @Test
   void createManyBooks() {
       assertNotNull(BookFactory.createManyBooks("9780749746117","A Series of Unfortunate Events: The Bad Beginning","Lemony Snicket",162,"Comedy, Drama, Child Fiction",20 ,49.21));
    }

@Test
  void blankStringCreation() {
      assertNotNull( BookFactory.createManyBooks("","","",20,null,3,88.20));
}

   @Test
    void negativeNumbersCreation() {
        assertNotNull( BookFactory.createManyBooks("Lemony Snicket","A Series of Unfortunate Events: The Bad Beginning","9780749746117",-68,"Comedy, Drama, Child Fiction",0,-40));
    }

}