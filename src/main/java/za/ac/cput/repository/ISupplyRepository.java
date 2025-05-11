/*
ISupplyRepository.java
Author: Musa Banathi Nkosi
        221744517
 */

package za.ac.cput.repository;

import za.ac.cput.domain.SupplyOrder;

import java.util.List;

public interface ISupplyRepository extends IRepository<SupplyOrder, String> {

    // Saves a Supply entity to the repository
    SupplyOrder save(SupplyOrder supply);

    // Finds supplies by their order price
    List<SupplyOrder> findByOrderPrice(double orderPrice);

    // Finds supplies by their supplier name
    List<SupplyOrder> findBySupplierID(String supplierName);
}