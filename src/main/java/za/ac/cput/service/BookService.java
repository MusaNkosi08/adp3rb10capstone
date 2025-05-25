package za.ac.cput.service;

import za.ac.cput.domain.Book;
import za.ac.cput.repository.impl.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService{
    private static BookService service = null;
    private final List<Book> bookCatalogue;

    private BookService() {
        bookCatalogue = new ArrayList<Book>();
    }

    public static BookService getInstance() {
        if (service == null) {
            service = new BookService();
        }
        return service;
    }

}
