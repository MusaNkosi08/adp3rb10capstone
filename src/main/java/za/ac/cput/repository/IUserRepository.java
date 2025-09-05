package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    List<User> findByUserFirstName(String firstName);

    List<User> findByUserLastName(String lastName);

    // Search via Contact object
    Optional<User> findByContactEmail(String email);
    List<User> findByContactPhoneNumber(String phoneNumber);

    // Search via User fields
    List<User> findByUserPhoneNumber(String phoneNumber);

    @Query(value = "SELECT * FROM users u WHERE u.email = :email AND u.password = :password", nativeQuery = true)
    Optional<User> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
