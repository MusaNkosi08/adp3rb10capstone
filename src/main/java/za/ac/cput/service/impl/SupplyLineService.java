package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.SupplyLine;
import za.ac.cput.repository.ISupplyLineRepository;
import za.ac.cput.service.ISupplyLineService;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyLineService implements ISupplyLineService {

    @Autowired
    private ISupplyLineRepository supplyLineRepository;

    @Override
    public SupplyLine create(SupplyLine supplyLine) {
        return supplyLineRepository.save(supplyLine);
    }

    @Override
    public SupplyLine read(Integer integer) {
        return supplyLineRepository.findById(integer).orElse(null);
    }

//    @Override
//    public Optional<SupplyLine> read(Integer id) {
//        return supplyLineRepository.findById(id);
//    }

    @Override
    public SupplyLine update(SupplyLine supplyLine) {
        if (supplyLineRepository.existsById(supplyLine.getLineID())) {
            return supplyLineRepository.save(supplyLine);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if (supplyLineRepository.existsById(id)) {
            supplyLineRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<SupplyLine> findAll() {
        return List.of();
    }

//    @Override
//    public List<SupplyLine> getAll() {
//        return supplyLineRepository.findAll();
//    }
}
