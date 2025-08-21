package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.Supplier;

import java.util.List;

@Service
public interface ISupplierService extends IService<Supplier, Integer> {
    List<Supplier> findBySuppliercode(int SupplierCode);
    List<Supplier> findBySupplierEmail (String email);
    List<Supplier> findByPhoneNumber(String contactNumber);

}
