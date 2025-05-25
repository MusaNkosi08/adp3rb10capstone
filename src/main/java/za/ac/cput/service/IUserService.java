/* UserController.java
``Author: Aimee Paulus (222814969)
  Date: 25 May 2025
 */

package za.ac.cput.service;

import za.ac.cput.domain.User;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface IUserService extends IRepository<User,String>{
    List<User> findByFirstName(String userFirstname);
    List<User> findByLastName(String userLastname);
    List<User> findByEmail(String userEmail);
    List<User> findByPhoneNumber(String userPhoneNumber);
}// end of file