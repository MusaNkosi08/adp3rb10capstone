/*
 BookService.java
 Service class for Book
 Author: Ashton Mondreo Petersen (220219494)
*/


package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Book;
import za.ac.cput.repository.IBookRepository;
import za.ac.cput.service.IBookService;

import java.util.List;

@Service
public class BookService implements IBookService {

    private final IBookRepository repository;

    @Autowired
    public BookService(IBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book create (Book book){
        return this.repository.save(book);
    }

    // Remove String overload, only use Long for read
    @Override
    public Book read(Long id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Book update (Book book){
        return this.repository.save(book);
    }

    @Override
    public boolean delete(Long id){
        if (!this.repository.existsById(id)) {
            return false;
        } else {
            this.repository.deleteById(id);
            return true;
        }
    }
    @Override
    public List<Book> findAll () {
        return this.repository.findAll();
    }
    public Book create(String title, String author, int pages, String genre, int quantity, double price, byte[] image) {
        Book.BookBuilder builder = new Book.BookBuilder(title, author, pages, genre, quantity, price);
        builder.setImage(image);
        Book book = builder.build();
        return this.repository.save(book);
    }

    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Book> findByAuthor(String author, boolean displayOOS) {
        return List.of();
    }

    @Override
    public List<Book> findByTitle(String title, boolean displayOOS) {
        return List.of();
    }

    @Override
    public List<Book> findByGenre(String genre, boolean displayOOS) {
        return List.of();
    }
}
