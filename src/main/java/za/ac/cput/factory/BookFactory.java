/*
BookFactory.java
Book Factory
Author: Ashton Mondreo Petersen (220219494)
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Book;

public class BookFactory {

    //This method creates a book item that has a custom amount of copies in stock
    public static Book createManyBooks(String title, String author, String isbn, int pages, String genre, int quantity, double price) {
        return new Book.BookBuilder(isbn, title, author, pages, genre, quantity, price).build();
    }

    //This method creates a book item where there is only one copy of it in stock
    public static Book createBook(String title, String author, String isbn, int pages, String genre, double price) {
        return new Book.BookBuilder(isbn, title, author, pages, genre, price).build();
    }
} //EOF
