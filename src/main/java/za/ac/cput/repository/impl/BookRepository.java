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
        boolean preexisting = false;

        for (Book b : bookCatalogue) {
            if (book.getIsbn().equals(b.getIsbn())) {
                preexisting = true;
                System.out.println("A book already exists with this ISBN (" + b.getTitle() + ")");
            }
        }
        if ((bookCatalogue.add(book)) && !preexisting) {
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
        System.out.println("A book does not exist with this ISBN");
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
        System.out.println("A book does not exist with this ISBN");
        return false;
    }

    @Override
    public List<Book> findAll() {
        if (bookCatalogue.isEmpty()) {
            System.out.println("There are no books in the catalogue (Consider adding a few)");
            return null;
        }
        return bookCatalogue;
    }


    @Override
    public List<Book> findByAuthor(String author, boolean displayOOS) {
        List<Book> newCatalogue = null;
        for (Book b : bookCatalogue) {
            if (b.getAuthor().equals(author)) {
                if (b.getQuantity() > 0) {
                    newCatalogue.add(b);
                } else if (displayOOS) {
                    newCatalogue.add(b);
                }
            }
        }


        if (newCatalogue == null) {
            System.out.println("No books exist by this author");
            return null;
        }
        return newCatalogue;
    }

    @Override
    public List<Book> findByTitle(String title, boolean displayOOS) {
        List<Book> newCatalogue = null;
        for (Book b : bookCatalogue) {
            if (b.getTitle().contains(title)) {
                if (b.getQuantity() > 0) {
                    newCatalogue.add(b);
                } else if (displayOOS) {
                    newCatalogue.add(b);
                }
            }
        }


        if (newCatalogue == null) {
            System.out.println("No books exist by this title");
            return null;
        }
        return newCatalogue;
    }

    @Override
    public List<Book> findByGenre(String genre, boolean displayOOS) {
        List<Book> newCatalogue = null;
        for (Book b : bookCatalogue) {
            if (b.getGenre().contains(genre)) {
                if (b.getQuantity() > 0) {
                    newCatalogue.add(b);
                } else if (displayOOS) {
                    newCatalogue.add(b);
                }
            }
        }
        if (newCatalogue == null) {
            System.out.println("No books exist in this genre");
            return null;
        }
        return newCatalogue;
    }

    @Override
    public List<Book> findByLength(int length, boolean displayOOS) {
        List<Book> newCatalogue = null;
        for (Book b : bookCatalogue) {
            if ((b.getPages() >= length - 20) && (b.getPages() <= length + 20)) {
                if (b.getQuantity() > 0) {
                    newCatalogue.add(b);
                } else if (displayOOS) {
                    newCatalogue.add(b);
                }
            }
        }
        if (newCatalogue == null) {
            System.out.println("No books exist in this range");
            return null;
        }
        return newCatalogue;
    }
} //EOF
