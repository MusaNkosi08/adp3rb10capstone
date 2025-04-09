package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Book;
import za.ac.cput.factory.BookFactory;

import static org.junit.jupiter.api.Assertions.*;


class BookRepositoryTest {
    BookRepository repo1;


    @BeforeEach
    void setUp() {
        repo1 = BookRepository.getInstance();
    }

    @Test
    public void testCreate() {
        assertNotNull(repo1.create(BookFactory.createBook("9780521402309","The Great Gatsby", "F. Scott Fitzgerald",280, "Tragedy", 97.05)));
    }

    @Test
    public void testRead() {
        repo1.create(BookFactory.createBook("9780521402309","The Great Gatsby", "F. Scott Fitzgerald",280, "Tragedy", 97.05));
        assertNotNull(repo1.read("9780521402309"));
    }

    @Test
    public void testUpdate() {
        repo1.create(BookFactory.createBook("9780521402309","The Great Gatsby", "F. Scott Fitzgerald",280, "Tragedy", 97.05));
        assertNotNull(repo1.update(BookFactory.createBook("9780521402309","The Great Gatsby", "F. Scott Fitzgerald",280, "Tragedy", 25)));
    }

    @Test
    public void testDelete() {
        repo1.create(BookFactory.createManyBooks("9780316137973", "You've Been Warned", "James Patterson & Howard Roughan", 200, "Thriller", 22, 83.72));
        assertNotNull(repo1.delete("9780316137973"));
    }

    @Test
    public void testFind() {
        repo1.create(BookFactory.createManyBooks("9780316137973", "You've Been Warned", "James Patterson & Howard Roughan", 200, "Thriller", 22, 83.72));
        repo1.create( BookFactory.createBook("9780521402309","The Great Gatsby", "F. Scott Fitzgerald",280, "Tragedy", 97.90));
        assertNotNull(repo1.findAll());
        assertNotNull(repo1.findByAuthor("James",true));
        assertNotNull(repo1.findByLength(200,true));
        assertNotNull(repo1.findByGenre("Thriller",true));
        assertNotNull(repo1.findByTitle("Great",true));
    }
    @Test
    void checkAddingCopy() {
        repo1.create(BookFactory.createManyBooks("9780316137973", "You've Been Warned", "James Patterson & Howard Roughan", 200, "Thriller", 22, 83.72));
        assertNotNull(repo1.create(BookFactory.createManyBooks("9780316137973", "You Are Warned", "James Patterson & Howard Roughan", 200, "Thriller", 22, 83.72)));
    }

    @Test
    void updateOnNonExistingBook() {
        repo1.create(new Book.BookBuilder("9780521402309", "The Great Gatsby", "F. Scott Fitzgerald", 280, "Tragedy", 97.05).build());
        assertNotNull(repo1.update(new Book.BookBuilder("9780596004651", "Head First Java", "Kathy Sierra, Bert Bates", 619, "Textbook, Computer", 110.20).build()));
    }

    @Test
    void deleteNonExistingBook() {
        repo1.create(new Book.BookBuilder("9780521402309", "The Great Gatsby", "F. Scott Fitzgerald", 280, "Tragedy", 97.05).build());
        assertTrue(repo1.delete("9780596004651"));
    }

    @Test
    void getNoBooks() {
        assertNotNull(repo1.findAll());
    }

    @Test
    void getNonExistingAuthor() {
        assertNotNull(repo1.findByAuthor("Lemony Snickets", true));
    }

    @Test
    void getNonExistingTitle() {
        assertNotNull(repo1.findByTitle("Handmaid", true));
    }

    @Test
    void getNonExistingGenre() {
        assertNotNull(repo1.findByAuthor("Fantasy", true));
    }

    @Test
    void getNonExistingLength() {
        assertNotNull(repo1.findByLength(80, true));
    }

}//EOF