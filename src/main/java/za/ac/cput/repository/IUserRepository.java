package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;

import java.util.List;
import java.util.Optional;

/*
 IUserRepository.java
 Repository interface for User entity
 Author: Aimee Paulus (222814969)
 Date: 21 March 2025
*/

@Repository
public interface IUserRepository extends JpaRepository<User, String> {

    Optional<User> findByUserEmail(String email);
    List<User> findByUserFirstName(String firstName);
    List<User> findByUserLastName(String lastName);
    List<User> findByUserPhoneNumber(String phoneNumber);
    @Query(value= "SELECT * FROM User WHERE userEmail > :email AND userPassword =:password", nativeQuery = true)
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
