package za.ac.cput;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.User;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.repository.IUserRepository;
import za.ac.cput.repository.impl.PaymentRepository;
import za.ac.cput.repository.impl.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {

 public static void main(String[] args) {

  Order order = new Order(1, 123, "123 Main St, Anytown", "Credit Card");
  order.addItem(new OrderItem(1, 2, 10.0));
  order.addItem(new OrderItem(2, 1, 15.0));
  System.out.println(order.getOrderDetails());

  List<OrderItem> items = new ArrayList<>();
  items.add(new OrderItem(3, 1, 20.0));
  items.add(new OrderItem(4, 3, 5.0));
  Order order2 = OrderFactory.createOrder(456, "456 Elm St, Othertown", "PayPal", items);
  System.out.println(order2.getOrderDetails());

//        // Creating an employee manually
//        Employee employee1 = new Employee.Builder()
//                .setEmployeeID(101)
//                .setFirstName("John")
//                .setLastName("Doe")
//                .setEmail("john.doe@example.com")
//                .setPosition("Cashier")
//                .setSalary(35000)
//                .build();
//        System.out.println("Employee 1 Details:\n" + employee1);


  // user display
  System.out.println("User details: "); // using builder
  User user1 = new User.UserBuilder("54731","Ameena","Abrahams","amennaabrahams@gmail.com","Pasword123","0723787789").build();
  System.out.println(user1);

  // Create EmployeeRepository instance
  IUserRepository userRepository = UserRepository.getInstance();

  // Create a new employee via repository (CRUD operation - Create)
  System.out.println("Create user using repository:");
  User createdUser = userRepository.create(user1);
  System.out.println(createdUser);

  // Read employee using repository (CRUD operation - Read)
  System.out.println("Reading user with ID 54731 from repository:");
  User readUser = userRepository.read("54731");
  System.out.println(readUser);
  //System.out.println("------------------------------------------------------------------------------");

  // Update user using repository (CRUD operation - Update)
  System.out.println("Updating employee with ID 54731:");
  User updatedUser= new User.UserBuilder("54731","Ameena","Abrahams","amennaabrahams@gmail.com","Pasword123","0723787789")
          .build();
  User updatedResult = userRepository.update(updatedUser);
  System.out.println(updatedResult);
  //System.out.println("------------------------------------------------------------------------------");

  // Delete user using repository (CRUD operation - Delete)
  System.out.println("Deleting user with ID 54731 from repository:");
  boolean deleteResult = userRepository.delete("54731");
  if (deleteResult) {
   System.out.println("User with ID 54731 deleted successfully.");
  } else {
   System.out.println("User with ID 54731 not found for deletion.");
  }

  Payment payment1 = new Payment.Builder()
          .setPaymentID("P001")
          .setAmount(150.75)
          .setStatus("Pending")
          .setTransactionCode("TXN001")
          .build();


  PaymentRepository paymentRepo = new PaymentRepository();
  paymentRepo.create(payment1);


  paymentRepo.getPayment("P001");

  // Process the payment
  payment1.processPayment();
  paymentRepo.update(payment1);

  // Try to refund the payment
  payment1.refundPayment();
  paymentRepo.update(payment1);

  // List all payments
  paymentRepo.findAll();

  // Delete a payment
  paymentRepo.delete("P001");
  paymentRepo.findAll();
 } //EOF Main Run
} //EOF