/*
 BookService.java
 Service class for Book
 Author: Ashton Mondreo Petersen (220219494)
*/


package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.IBookRepository;
import za.ac.cput.service.IBookService;

import java.util.List;
@Primary
@Service
public class BookService implements IBookService {



    @Autowired
    private IBookRepository repository;

/*
    public static IBookService getService() {
        if (service == null) {

            return service;
        }

        return service;
    }

 */

 /*
    @Override
    public List<Book> findByAuthor(String author, boolean displayOOS) {


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
        public Book create (Book book){
            return this.repository.save(book);
        }

        @Override
        public Book read (String s){
            return this.repository.findById(s).orElse(null);
        }

        @Override
        public Book update (Book book){
            return this.repository.save(book);
        }

        @Override
        public boolean delete (String id){
            if (!this.repository.existsById(id)) {
                return false;}
            else {
                this.repository.deleteById(id);
                return true;
            }
        }
        @Override
        public List<Book> findAll () {
            return this.repository.findAll();
        }
    }
