package za.ac.cput.repository;

/* User.java
``Author: Aimee Paulus (222814969)
  Date: 23 March 2025
 */

import za.ac.cput.domain.User;
import java.util.List;

public interface IUserRepository extends IRepository<User, String> {

    User create(User user);

    User read(String id);


    User update(User user);

    boolean delete(String id);

    List<User> findAll();

}

