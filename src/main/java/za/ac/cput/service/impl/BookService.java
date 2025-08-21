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

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private IBookRepository bookRepository;

    // Create
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    // Read by ISBN
    public Optional<Book> read(String isbn) {
        return bookRepository.findById(isbn);
    }

    // Update
    public Book update(Book book) {
        if (bookRepository.existsById(book.getIsbn())) {
            return bookRepository.save(book);
        }
        return null;
    }

    // Delete
    public boolean delete(String isbn) {
        if (bookRepository.existsById(isbn)) {
            bookRepository.deleteById(isbn);
            return true;
        }
        return false;
    }

    // Get all books
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    // Business logic: check stock
    public boolean checkStock(String isbn) {
        return bookRepository.findById(isbn)
                .map(Book::checkStock)
                .orElse(false);
    }

    // Business logic: restock book
    public boolean restockBook(String isbn, int amount) {
        Optional<Book> optionalBook = bookRepository.findById(isbn);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            boolean success = book.restockBook(amount);
            if (success) {
                bookRepository.save(book);
                return true;
            }
        }
        return false;
    }

    // Business logic: sell book (remove stock and return total price)
    public double sellBook(String isbn, int amount) {
        Optional<Book> optionalBook = bookRepository.findById(isbn);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (book.getQuantity() >= amount) {
                double total = book.removeStock(amount);
                bookRepository.save(book);
                return total;
            }
        }
        return 0.0; // failed transaction
    }
}
