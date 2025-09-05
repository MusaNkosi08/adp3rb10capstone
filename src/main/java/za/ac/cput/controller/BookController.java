package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.Book;
import za.ac.cput.service.IBookService;
import za.ac.cput.service.impl.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@CrossOrigin(origins = "http://localhost:3000") // Optional if React frontend is used
public class BookController {

    @Autowired
    private BookService bookService;

    // Test endpoint
    @GetMapping("/hello")
    public String hello() {
        System.out.println("Hello, Book!");
        return "Hello, Book!";
    }

    @PostMapping(value = "/create", consumes = {"multipart/form-data"})
    public Book createBook(
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("pages") int pages,
            @RequestParam("genre") String genre,
            @RequestParam("quantity") int quantity,
            @RequestParam("price") double price,
            @RequestParam(value = "image", required = false) MultipartFile image
    ) throws Exception {
        byte[] imageBytes = image != null ? image.getBytes() : null;
        Book.BookBuilder builder = new Book.BookBuilder(title, author, pages, genre, quantity, price);
        builder.setImage(imageBytes);
        Book book = builder.build();
        return bookService.save(book);
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        return bookService.findById(bookId).orElse(null);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/delete/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteById(bookId);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }
}
