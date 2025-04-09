/*
BookFactory.java
Book Factory
Author: Ashton Mondreo Petersen (220219494)
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Book;
import za.ac.cput.util.Helper;

public class BookFactory {

    //This method creates a book item that has a custom amount of copies in stock
    public static Book createManyBooks(String isbn,String title, String author, int pages, String genre, int quantity, double price) {
        if (((title == null) || (title == ""))
                ||(author == null) || (author == "")
                ||(!Helper.verifyisbn(isbn))
                ||(title == null) || (title == "")
                || ((genre == null) || (genre == ""))
        ){
            System.out.println("Error: title or author or isbn or title is empty");
            return null;
        }
        if (
                (pages<=0)||(price<=0)||(quantity<=0)
        ){
            System.out.println("Error: page or price or quantity or price is invalid");
            return null;
        }
        return new Book.BookBuilder(isbn, title, author, pages, genre, quantity, price).build();
    }

    //This method creates a book item where there is only one copy of it in stock
    public static Book createBook( String isbn, String title, String author, int pages, String genre, double price) {
        if (((title == null) || (title == ""))
                ||(author == null) || (author == "")
                ||(!Helper.verifyisbn(isbn))
                ||(title == null) || (title == "")
                || ((genre == null) || (genre == ""))
        ){
            System.out.println("Error: title or author or isbn or title is empty");
            return null;
        }
        if (
                (pages<=0)||(price<=0)
        ){
            System.out.println("Error: page or price or quantity or price is invalid");
            return null;
        }
        return new Book.BookBuilder(isbn, title, author, pages, genre, price).build();
    }
} //EOF
