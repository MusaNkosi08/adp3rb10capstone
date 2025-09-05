package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Contact;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Long> {
    // Custom queries can be added here if needed
}

