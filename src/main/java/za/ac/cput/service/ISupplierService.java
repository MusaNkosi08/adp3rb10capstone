package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.Supplier;

import java.util.List;

@Service
public interface ISupplierService extends IService<Supplier, Integer> {
    List<Supplier> findBySuppliercode(String author, boolean displayOOS);
    List<Supplier> findByTitle(String title, boolean displayOOS);
    List<Supplier> findByGenre(String genre, boolean displayOOS);
    List<Supplier> findByLength(int length, boolean displayOOS);

}
