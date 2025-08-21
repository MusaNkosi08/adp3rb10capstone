/* UserController.java
``Author: Aimee Paulus (222814969)
  Date: 25 May 2025
 */

package za.ac.cput.service;

import za.ac.cput.domain.User;

import java.util.List;


public interface IUserService extends IService<User, Long> {
    List<User> findById(Long userId);
    List<User> findByFirstName(String userFirstname);
    List<User> findByLastName(String userLastname);
    List<User> findByEmail(String userEmail);
    List<User> findByPhoneNumber(String userPhoneNumber);
    User login(String email, String password);
}// end of file