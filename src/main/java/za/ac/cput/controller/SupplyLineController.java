package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.SupplyLine;
import za.ac.cput.service.impl.SupplyLineService;

@RestController
@RequestMapping("/api/line")
public class SupplyLineController {


    private SupplyLineService service;

    @Autowired
    public SupplyLineController(SupplyLineService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public SupplyLine createLine(@RequestBody SupplyLine line) {
        return this.service.create(line);
    }

    @GetMapping("/{lineID}")
    public SupplyLine getLine(@PathVariable Integer LineISBN) {

        return service.read(LineISBN);
    }

    @PutMapping("/update")
    public SupplyLine updateLine(@RequestBody SupplyLine line) {
        return service.create(line);
    }

    @DeleteMapping("/delete/{lineID}")
    public void deleteLine(@PathVariable Integer lineID) {
        service.delete(lineID);
    }
}
