package za.ac.cput.service;

import za.ac.cput.domain.SupplyOrder;
import java.util.List;

public interface ISupplyOrderService extends IService<SupplyOrder, Long> {
    SupplyOrder create(SupplyOrder order);
    SupplyOrder read(Long id);
    List<SupplyOrder> readAll();
    SupplyOrder update(SupplyOrder order);
    boolean delete(Long id);

    List<SupplyOrder> getAll();

    List<SupplyOrder> findByOrderStatus(String status);

    List<SupplyOrder> findByEmployeeID(Long employeeID);

    List<SupplyOrder> findBySupplierID(Long supplierID);

    List<SupplyOrder> findByOrderPriceBetween(double minPrice, double maxPrice);
}
