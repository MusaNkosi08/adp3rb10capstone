package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.SupplyLine;
import za.ac.cput.repository.ISupplyLineRepository;

@RestController
@RequestMapping("/api/line")
public class SupplyLineController {

    @Autowired
    private ISupplyLineRepository repository;

    @PostMapping("/create")
    public SupplyLine createLine(@RequestBody SupplyLine line) {
        return this.repository.save(line);
    }

    @GetMapping("/{lineID}")
    public SupplyLine getLine(@PathVariable Long lineID) {

        return repository.findById(lineID).orElse(null);
    }

    @PutMapping("/update")
    public SupplyLine updateLine(@RequestBody SupplyLine line) {
        return repository.save(line);
    }

    @DeleteMapping("/delete/{lineID}")
    public void deleteLine(@PathVariable Long lineID) {
        repository.deleteById(lineID);
    }
}
