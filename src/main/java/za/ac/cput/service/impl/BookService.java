package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Book;
import za.ac.cput.repository.IBookRepository;
import za.ac.cput.service.IBookService;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private static IBookService service;
    private static IBookRepository repository;


    public static IBookService getService() {
        if (service == null) {
            service = new BookService();
        }
        return service;
    }

    /*
    @Override
    public List<Book> findByAuthor(String author, boolean displayOOS) {
        return List.of();
    }


    @Override
    public List<Book> findByTitle(String title, boolean displayOOS) {
       return this.repository.findByTitle(title, displayOOS);
    }



    @Override
    public List<Book> findByGenre(String genre, boolean displayOOS) {
      return  this.repository.findByGenre(genre, displayOOS);
    }


    @Override
    public List<Book> findByLength(int length, boolean displayOOS) {
      return  this.repository.findByLength(length, displayOOS);
    }
 */
    @Override
    public Book create(Book book) {
        return this.repository.save(book);
    }

    @Override
    public Book read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Book update(Book book) {
        return this.repository.save(book);
    }

    @Override
    public boolean delete(String id) {
      this.repository.deleteById(id);
        return false;
    }
    @Override
    public List<Book> findAll() {
        return this.repository.findAll();
    }
}
