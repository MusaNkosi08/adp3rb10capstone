
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {

    // Custom queries
    Optional<User> findByUserEmail(String email);
    List<User> findByUserFirstName(String firstName);
    List<User> findByUserLastName(String lastName);
    List<User> findByUserPhoneNumber(String phoneNumber);
}
