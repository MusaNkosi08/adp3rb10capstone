package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.SupplyLine;
import za.ac.cput.repository.IBookRepository;
import za.ac.cput.repository.ISupplyLineRepository;
import za.ac.cput.service.IBookService;
import za.ac.cput.service.ISupplyLineService;

import java.util.List;

@Service
public class SupplyLineService implements ISupplyLineService {

    @Autowired
    private static ISupplyLineService service;
    private static ISupplyLineRepository repository;




    @Override
    public SupplyLine create(SupplyLine line) {
        return this.repository.save(line);
    }

    @Override
    public SupplyLine read(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public SupplyLine update(SupplyLine line) {
        return this.repository.save(line);
    }

    @Override
    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
    @Override
    public List<SupplyLine> findAll() {
        return this.repository.findAll();
    }
}
