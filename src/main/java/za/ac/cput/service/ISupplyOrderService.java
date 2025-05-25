package za.ac.cput.service;

import za.ac.cput.domain.SupplyOrder;
import java.util.List;

public interface ISupplyOrderService {
    SupplyOrder create(SupplyOrder order);
    SupplyOrder read(String id);
    List<SupplyOrder> readAll();
    SupplyOrder update(SupplyOrder order);
    void delete(String id);
}
