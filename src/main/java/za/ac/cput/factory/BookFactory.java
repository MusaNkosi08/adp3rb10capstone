package za.ac.cput.factory;

import za.ac.cput.domain.Book;

public class BookFactory {
    public static Book createBook(String title, String author, String isbn, int pages) {
        return new Book.BookBuilder(isbn, title, author,pages).build();
    }
}
