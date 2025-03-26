/*
BookRepository.java
Book Implementation Class
Author: Ashton Mondreo Petersen (220219494)
 */

package za.ac.cput.repository.impl;

import za.ac.cput.domain.Book;
import za.ac.cput.repository.IBookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {

    private static BookRepository repository = null;
    private final List<Book> bookCatalogue;

    private BookRepository() {
        bookCatalogue = new ArrayList<Book>();
    }

    public static BookRepository getInstance() {
        if (repository == null) {
            repository = new BookRepository();
        }
        return repository;
    }

    @Override
    public Book create(Book book) {

        boolean success = false;
        int instances = 0;

        for (Book b : bookCatalogue) {
            if (book.getIsbn().equals(b.getIsbn())) {
                instances++;
            }
        }
        if ((bookCatalogue.add(book)) && instances == 0) {
            success = true;
        }

        if (success) {
            return book;
        }
        return null;
    }

    @Override
    public Book read(String isbn) {
        for (Book b : bookCatalogue) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    @Override
    public Book update(Book book) {
        for (Book b : bookCatalogue) {
            if (b.getIsbn().equals(book.getIsbn())) {
                int index = 0;
                for (int i = 0; i < bookCatalogue.size(); i++) {
                    if (bookCatalogue.get(i).getIsbn().equals(book.getIsbn())) {
                        index = i;
                    }
                }
                bookCatalogue.set(index, book);
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String isbn) {
        for (Book b : bookCatalogue) {
            if (b.getIsbn().equals(isbn)) {
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


    @Override
    public List<Book> findByAuthor(String author, boolean displayOOS) {
        List<Book> newCatalogue = null;
        for (Book b : bookCatalogue) {
            if (b.getAuthor().equals(author)) {
                if (b.getQuantity()>0){
                  newCatalogue.add(b);
                } else if (displayOOS) {
newCatalogue.add(b);
                }
            }
        }
        return newCatalogue;
    }

    @Override
    public List<Book> findByTitle(String title, boolean displayOOS) {
        List<Book> newCatalogue = null;
        for (Book b : bookCatalogue) {
            if (b.getTitle().contains(title)) {
                if (b.getQuantity()>0){
                    newCatalogue.add(b);
                } else if (displayOOS) {
                    newCatalogue.add(b);
                }
            }
        }
        return newCatalogue;
    }

    @Override
    public List<Book> findByGenre(String genre, boolean displayOOS) {
        List<Book> newCatalogue = null;
        for (Book b : bookCatalogue) {
            if (b.getGenre().contains(genre)) {
                if (b.getQuantity()>0){
                    newCatalogue.add(b);
                } else if (displayOOS) {
                    newCatalogue.add(b);
                }
            }
        }
        return newCatalogue;
    }

    @Override
    public List<Book> findByLength(int length, boolean displayOOS) {
        List<Book> newCatalogue = null;
        for (Book b : bookCatalogue) {
            if ((b.getPages()>=length-20) && (b.getPages()<=length+20)) {
                if (b.getQuantity()>0){
                    newCatalogue.add(b);
                } else if (displayOOS) {
                    newCatalogue.add(b);
                }
            }
        }
        return newCatalogue;
    }
} //EOF
