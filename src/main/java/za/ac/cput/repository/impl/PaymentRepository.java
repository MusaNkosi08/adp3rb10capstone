// PaymentRepository.java
package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Payment;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
    List<Payment> findByStatus(String status);
    List<Payment> findByAmountGreaterThan(double amount);

    // Custom methods can be handled in the service layer
}