package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Book;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {
BookRepository repo1;



    @BeforeEach
    void setUp() {
        repo1 = BookRepository.getInstance();
    }

@Test
void che(){
 repo1.create(new Book.BookBuilder("9780316137973", "You've Been Warned", "James Patterson & Howard Roughan", 200,"Thriller",22,83.72).build());

    }
}