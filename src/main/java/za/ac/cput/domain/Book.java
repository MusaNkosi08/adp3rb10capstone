/*
Book.java
Book Model Class
Author: Ashton Mondreo Petersen (220219494)
 */

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long bookId;
    public String title;
    public String author;
    public int pages;
    public String genre;
    public int quantity;
    public double price;
    @Lob
    private byte[] image; // Store image as BLOB

    private Book(BookBuilder builder) {
        this.bookId = builder.bookId;
        this.title = builder.title;
        this.author = builder.author;
        this.pages = builder.pages;
        this.genre = builder.genre;
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.image = builder.image;
    }

    public Book() {

    }

    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getGenre() {
        return genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    //A method to check if there is stock of the book
    public boolean checkStock() {
        if (quantity <= 0) {
            return false;
        }
        return true;
    }

    //A method to add more stock to the quantity of this book
    public Boolean restockBook(int amount) {
        if (amount <= 0) {
            return false;
        }
        quantity += amount;
        return true;
    }

    //A method that removes stock that is sold and returns the total price of the amount sold
    public double removeStock(int amount) {
        quantity -= amount;
        double total = amount*price;
        return total;
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", genre='" + genre + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public static class BookBuilder {
        private Long bookId;
        private String title;
        private String author;
        private int pages;
        private String genre;
        private int quantity;
        private double price;
        private byte[] image; // Store image as BLOB

        public BookBuilder(String title, String author, int pages, String genre, int quantity, double price) {
            this.title = title;
            this.author = author;
            this.pages = pages;
            this.genre = genre;
            this.quantity = quantity;
            this.price = price;
        }

        public BookBuilder(String title, String author, int pages, String genre, double price){
            this.title = title;
            this.author = author;
            this.pages = pages;
            this.genre = genre;
            this.quantity = 1;
            this.price = price;
        }

        public void setBookId(Long bookId) {
            this.bookId = bookId;
        }

        public void setTitle(String title) {
            this.title = title;

        }

        public void setAuthor(String author) {
            this.author = author;

        }

        public void setPages(int pages) {
            this.pages = pages;

        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setImage(byte[] image) {
            this.image = image;
        }

        public Book build() {
            return new Book(this);
        }
    }
} //EOF
