/*
IBookRepository.java
Book Repository Interface
Author: Ashton Mondreo Petersen (220219494)
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Book;

import java.util.List;

public interface IBookRepository extends IRepository<Book, String> {
List<Book> findByAuthor(String author, boolean displayOOS);
List<Book> findByTitle(String title, boolean displayOOS);
List<Book> findByGenre(String genre, boolean displayOOS);
List<Book> findByLength(int length, boolean displayOOS);

}//EOF
