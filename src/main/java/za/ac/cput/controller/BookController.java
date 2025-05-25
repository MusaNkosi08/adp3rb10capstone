package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.IBookRepository;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private IBookRepository repository;

    @PostMapping("/create")
    public Book createBook(@RequestBody Book book) {
        return this.repository.save(book);
    }

    @GetMapping("/{bookISBN}")
    public Book getBook(@PathVariable String bookISBN) {

        return repository.findById(bookISBN).orElse(null);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @DeleteMapping("/delete/{bookISBN}")
    public void deleteBook(@PathVariable String bookISBN) {
        repository.deleteById(bookISBN);
    }
}

