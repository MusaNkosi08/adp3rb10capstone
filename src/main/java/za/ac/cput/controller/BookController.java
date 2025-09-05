package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.Book;
import za.ac.cput.repository.IBookRepository;
import za.ac.cput.service.impl.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private IBookRepository repository;

    @Autowired
    private BookService bookService;

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
        return this.repository.save(book);
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable Long bookId) {

        return repository.findById(bookId).orElse(null);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @DeleteMapping("/delete/{bookISBN}")
    public void deleteBook(@PathVariable Long bookISBN) {
        repository.deleteById(bookISBN);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }
}

