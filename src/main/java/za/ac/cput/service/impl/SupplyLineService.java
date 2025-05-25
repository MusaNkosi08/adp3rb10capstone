package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Book;
import za.ac.cput.repository.IBookRepository;
import za.ac.cput.repository.ISupplyLineRepository;
import za.ac.cput.service.IBookService;
import za.ac.cput.service.ISupplyLineService;

import java.util.List;

@Service
public class SupplyLineService {

    @Autowired
    private static ISupplyLineService service;
    private static ISupplyLineRepository repository;


    public static ISupplyLineService getService() {
        if (service == null) {
            service = new SupplyLineService();
        }
        return service;
    }


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
    public void delete(String id) {
        this.repository.deleteById(id);
    }
    @Override
    public List<Book> findAll() {
        return this.repository.findAll();
    }
}
