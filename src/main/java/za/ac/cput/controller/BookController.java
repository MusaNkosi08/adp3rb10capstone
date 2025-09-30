package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.Book;
import za.ac.cput.repository.IBookRepository;
import za.ac.cput.service.impl.BookService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

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
        byte[] imageBytes = image != null ? image.getBytes() : null; // Store as byte[]
        Book.BookBuilder builder = new Book.BookBuilder(title, author, pages, genre, quantity, price);
        builder.setImage(imageBytes); // Set as byte[]
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

    @DeleteMapping("/delete/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        repository.deleteById(bookId);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        String uploadDir = "uploads/";
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir + fileName);
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, file.getBytes());
        // Return the relative path or URL
        return ResponseEntity.ok("/uploads/" + fileName);
    }
}

