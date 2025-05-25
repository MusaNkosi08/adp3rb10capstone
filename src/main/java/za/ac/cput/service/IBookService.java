/*
IBookService.java
Book Repository Interface
Author: Ashton Mondreo Petersen (220219494)
 */

package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Book;
import za.ac.cput.repository.IRepository;

import java.util.List;

@Service
public interface IBookService extends IService<Book, String> {
List<Book> findByAuthor(String author, boolean displayOOS);
List<Book> findByTitle(String title, boolean displayOOS);
List<Book> findByGenre(String genre, boolean displayOOS);
List<Book> findByLength(int length, boolean displayOOS);

}//EOF
