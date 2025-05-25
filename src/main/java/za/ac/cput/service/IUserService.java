/* UserController.java
``Author: Aimee Paulus (222814969)
  Date: 25 May 2025
 */

package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.IRepository;

import java.util.List;


public interface IUserService extends IService<User,String>{
    List<User> findById(String userId);
    List<User> findByFirstName(String userFirstname);
    List<User> findByLastName(String userLastname);
    List<User> findByEmail(String userEmail);
    List<User> findByPhoneNumber(String userPhoneNumber);
    List <User> getAll();
}// end of file