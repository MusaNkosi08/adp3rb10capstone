package za.ac.cput.domain;

public class Book {
    public String isbn;
    public String title;
    public String author;
    public int pages;

    private Book(BookBuilder builder) {
        this.isbn = builder.isbn;
        this.title = builder.title;
        this.author = builder.author;
    }
    public String getIsbn() {
        return isbn;
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

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages='" + pages + '\'' +
                '}';
    }

    public static class BookBuilder {

        private String isbn;
        private String title;
        private String author;
        private int pages;

        public BookBuilder(String isbn, String title, String author, int pages) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.pages = pages;
        }

        public BookBuilder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }
        public BookBuilder setPages(int pages) {
            this.pages = pages;
            return this;
        }

        public Book build() {return new Book(this); }
    }
}
