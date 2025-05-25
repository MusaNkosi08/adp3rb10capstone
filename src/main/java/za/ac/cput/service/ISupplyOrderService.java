package za.ac.cput.service;

import za.ac.cput.domain.SupplyOrder;
import java.util.List;

public interface ISupplyOrderService {
    SupplyOrder create(SupplyOrder order);
    SupplyOrder read(String id);
    List<SupplyOrder> readAll();
    SupplyOrder update(SupplyOrder order);
    void delete(String id);

    List<SupplyOrder> getAll();

    List<SupplyOrder> findByOrderStatus(String status);

    List<SupplyOrder> findByEmployeeID(String employeeID);

    List<SupplyOrder> findBySupplierID(String supplierID);

    List<SupplyOrder> findByOrderPriceBetween(double minPrice, double maxPrice);
}
