/*
SupplyOrderRepository.java
Author: Musa Banathi Nkosi (221744517)
*/

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.SupplyOrder;

import java.util.Date;
import java.util.List;

@Repository
public interface ISupplyOrderRepository extends JpaRepository<SupplyOrder, String> {

    // 🔎 Find all orders by a specific employee
    List<SupplyOrder> findByEmployeeID(String employeeID);

    // 🔎 Find all orders from a specific supplier
    List<SupplyOrder> findBySupplierID(String supplierID);

    // 🔎 Find all orders with a specific status (e.g., "Cancelled", "Pending")
    List<SupplyOrder> findByOrderStatus(String orderStatus);

    // 🔎 Find orders placed after a specific date
    List<SupplyOrder> findByOrderDateAfter(Date date);

    // 🔎 Find orders where the price is greater than a given amount
    List<SupplyOrder> findByOrderPriceGreaterThan(double price);

    SupplyOrder create(SupplyOrder order);

    SupplyOrder read(String id);

    List<SupplyOrder> readAll();

    SupplyOrder update(SupplyOrder order);

    void delete(String id);
}
