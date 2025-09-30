package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    List<User> findByUserFirstName(String firstName);
    List<User> findByUserLastName(String lastName);
    Optional<User> findByContactEmail(String email);
    List<User> findByContactPhoneNumber(String phoneNumber);
}
