/*
ISupplyRepository.java
Author: Musa Banathi Nkosi
        221744517
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Supply;

import java.util.List;

public interface ISupplyRepository extends IRepository<Supply, String> {

    // Saves a Supply entity to the repository
    Supply save(Supply supply);

    // Finds supplies by their order price
    List<Supply> findByOrderPrice(double orderPrice);

    // Finds supplies by their quantity
    List<Supply> findByQuantity(int quantity);

    // Finds supplies by their supplier name
    List<Supply> findBySupplierName(String supplierName);
}