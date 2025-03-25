package za.ac.cput.repository.impl;

import za.ac.cput.domain.Book;
import za.ac.cput.repository.IBookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {

private static BookRepository repository=null;
private List<Book> bookCatalogue;

private BookRepository() {
    bookCatalogue = new ArrayList<Book>();
}
public static BookRepository getInstance() {
    if(repository==null) {
        repository = new BookRepository();
    }
    return repository;
}

    @Override
    public Book create(Book book) {

    boolean success=false;
    int instances=0;

    for(Book b:bookCatalogue) {
        if (book.getIsbn().equals(b.getIsbn())){
            instances++;
        }
    }
    if ((bookCatalogue.add(book)) && instances==0) {
        success=true;
    };

    if(success) {
        return book;
    } return null;
    }

    @Override
    public Book read(String isbn) {
    for(Book b:bookCatalogue) {
        if (b.getIsbn().equals(isbn)){
            return b;
        }
    }
    return null;
    }

    @Override
    public Book update(Book book) {
    for (Book b : bookCatalogue) {
        if (b.getIsbn().equals(book.getIsbn())){
            int index=0;
            for (int i = 0; i < bookCatalogue.size(); i++) {
                if (bookCatalogue.get(i).getIsbn().equals(book.getIsbn())){
                    index=i;
                }
            }
            bookCatalogue.set(index,book);
            return book;
        }
    }
    return null;
    }

    @Override
    public boolean delete(String isbn) {
    for (Book b : bookCatalogue) {
        if (b.getIsbn().equals(isbn)){
            bookCatalogue.remove(b);
            return true;
        }
    }

    return false;
    }

    @Override
    public List<Book> findAll() {
        return bookCatalogue;
    }
}
