package za.ac.cput.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
Book book1;
Book.BookBuilder builder1;
Book book2;
Book.BookBuilder builder2;
    @BeforeEach
    void setUp() {
                builder1= new Book.BookBuilder("9780521402309","The Great Gatsby", "F. Scott Fitzgerald",280, "Tragedy", 97.05);
       builder2= new Book.BookBuilder("9780316137973", "You've Been Warned", "James Patterson & Howard Roughan", 200,"Thriller",22,83.72);
    }

@Test
public void removeStock(){
        builder1.setQuantity(6);
        book1=builder1.build();
        double totalPrice=book1.removeStock(2);
        assertTrue(book1.getQuantity()>=0);
}

@Test
public void addStock(){
        book1=builder1.build();
        assertTrue(book1.restockBook(4));
}

@Test
public void checkStock(){
        book1=builder1.build();
        assertTrue(book1.checkStock());
}

    @Test
    public void testSaleLimit(){
        builder1.setQuantity(1);
        builder2.setQuantity(6);
        book1= builder1.build();
        book2= builder2.build();
        double totalPrice = book1.removeStock(2)+book2.removeStock(2);
       assertTrue(book1.getQuantity()>=0);
    }

    @Test
    public void testAddNegativeStock(){
        book1= builder1.build();
        assertTrue(book1.restockBook(-2));
    }

    @Test
    public void testCheckStock(){
        builder1.setQuantity(-4);
        book1= builder1.build();
       assertTrue(book1.checkStock());
    }
}