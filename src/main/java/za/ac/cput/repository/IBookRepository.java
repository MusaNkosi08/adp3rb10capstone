/*
IBookService.java
Book Repository Interface
Author: Ashton Mondreo Petersen (220219494)
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Book;

import java.util.List;
@Repository
public interface IBookRepository extends JpaRepository<Book,String> {


}//EOF
