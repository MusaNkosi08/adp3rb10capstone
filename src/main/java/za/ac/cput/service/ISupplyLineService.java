package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.SupplyLine;
import java.util.List;
import java.util.Optional;

@Service
public interface ISupplyLineService extends IService<SupplyLine, Integer> {
    // No extra methods needed if IService already declares them
}
