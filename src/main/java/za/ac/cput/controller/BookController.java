package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Book;
import za.ac.cput.service.IBookService;
import za.ac.cput.service.impl.BookService;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/book")
//@CrossOrigin(origins = "http://localhost:3000") // Add this annotation
public class BookController {

    @Autowired
    private IBookService service;



@GetMapping ("/hello")
    public String hello() {
    System.out.println("Hello, Book!");
        return "Hello, Book!";
    }

    @PostMapping("/create")
    public Book createBook(@RequestBody Book book) {
        return this.service.create(book);
    }

    @GetMapping("/get/{bookISBN}")
    public Book getBook(@PathVariable String bookISBN) {

        return service.read(bookISBN);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return service.create(book);
    }

    @DeleteMapping("/delete/{bookISBN}")
    public void deleteBook(@PathVariable String bookISBN) {
        service.delete(bookISBN);
    }

    @GetMapping("/getall")
    public ArrayList<Book> getAllBooks() {

        return (ArrayList<Book>) service.findAll();
    }
}

