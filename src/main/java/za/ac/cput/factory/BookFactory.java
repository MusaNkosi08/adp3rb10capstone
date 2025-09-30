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
    public static Book createManyBooks(String title, String author, int pages, String genre, int quantity, double price, byte[] image) {
        if (((title == null) || (title == ""))
                ||(author == null) || (author == "")
                ||((genre == null) || (genre == ""))
        ){
            System.out.println("Error: title or author or genre is empty");
            return null;
        }
        if (
                (pages<=0)||(price<=0)||(quantity<=0)
        ){
            System.out.println("Error: page or price or quantity or price is invalid");
            return null;
        }
        Book.BookBuilder builder = new Book.BookBuilder(title, author, pages, genre, quantity, price);
        builder.setImage(image);
        return builder.build();
    }

    //This method creates a book item where there is only one copy of it in stock
    public static Book createBook( String title, String author, int pages, String genre, double price, byte[] image) {
        if (((title == null) || (title == ""))
                ||(author == null) || (author == "")
                ||((genre == null) || (genre == ""))
        ){
            System.out.println("Error: title or author or genre is empty");
            return null;
        }
        if (
                (pages<=0)||(price<=0)
        ){
            System.out.println("Error: page or price or quantity or price is invalid");
            return null;
        }
        Book.BookBuilder builder = new Book.BookBuilder(title, author, pages, genre, price);
        builder.setImage(image);
        return builder.build();
    }
} //EOF
