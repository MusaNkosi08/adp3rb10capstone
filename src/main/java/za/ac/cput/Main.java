package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.ac.cput.domain.*;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        //  Spring will scan the whole project for components
        SpringApplication.run(Main.class, args);

        // Creating an order using builder
        Order order = new Order.Builder()
                .orderId(1)
                .customerId(123)
                .shippingAddress("123 Main St, Anytown")
                .paymentMethod("Credit Card")
                .addItem(new OrderItem.Builder().itemId(1).quantity(2).price(10.0).build())
                .addItem(new OrderItem.Builder().itemId(2).quantity(1).price(15.0).build())
                .build();

        System.out.println("\n=== ORDERS ===");
        System.out.println(order.getOrderDetails());

        // Creating the supplier
        Supplier supplier = new Supplier.Builder("BookWorld Publishing")
                .address("123 Main Street, Booktown")
                .email("contact@bookworld.com")
                .phoneNumber("+1-555-1234")
                .website("www.bookworld.com")
                .build();

        System.out.println("\n=== SUPPLIERS ===");
        System.out.println(supplier);

        // Creating a list of order items
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem.Builder().itemId(3).quantity(1).price(20.0).build());
        items.add(new OrderItem.Builder().itemId(4).quantity(3).price(5.0).build());

        // Second order
        Order order2 = new Order.Builder()
                .orderId(456)
                .customerId(789)
                .shippingAddress("456 Elm St, Othertown")
                .paymentMethod("PayPal")
                .items(items)
                .build();

        System.out.println("\n=== ORDERITEMS ===");
        System.out.println(order2.getOrderDetails());

        // Creating users
        System.out.println("\n=== USERS ===");
        User user1 = new User.UserBuilder("54731", "Ameena", "Abrahams",
                "ameenaabrahams@gmail.com", "Password123", "0723787789").build();
        System.out.println("User 1: " + user1);

        User user2 = new User.UserBuilder("54732", "John", "Doe",
                "john.doe@example.com", "SecurePass456", "0831234567").build();
        System.out.println("User 2: " + user2);

        // Creating employees
        System.out.println("\n=== EMPLOYEES ===");
        Employee employee1 = new Employee.Builder()
                .setEmployeeID(1L)
                .setFirstName("Musa")
                .setLastName("Nkosi")
                .setEmail("m.n@cput.ac.za")
                .setPosition("Cashier")
                .setSalary(35000)
                .build();
        System.out.println("Employee 1: " + employee1);

        Employee employee2 = new Employee.Builder()
                .setEmployeeID(2L)
                .setFirstName("Siphosethu")
                .setLastName("Msengeni")
                .setEmail("s.m@cput.ac.za")
                .setPosition("Manager")
                .setSalary(50000)
                .build();
        System.out.println("Employee 2: " + employee2);

        Employee employee3 = new Employee.Builder()
                .setEmployeeID(3L)
                .setFirstName("Ashton")
                .setLastName("Petersen")
                .setEmail("a.p@cput.ac.za")
                .setPosition("Sales Assistant")
                .setSalary(28000)
                .build();
        System.out.println("Employee 3: " + employee3);

        // Creating payments
        System.out.println("\n=== PAYMENTS ===");
        Payment payment1 = new Payment.Builder()
                .setPaymentId("P001")
                .setAmount(150.75)
                .setStatus("Pending")
                .setTransactionCode("TXN001")
                .build();
        System.out.println("Payment 1: " + payment1);

        Payment payment2 = new Payment.Builder()
                .setPaymentId("P002")
                .setAmount(299.99)
                .setStatus("Completed")
                .setTransactionCode("TXN002")
                .build();
        System.out.println("Payment 2: " + payment2);

        Payment payment3 = new Payment.Builder()
                .setPaymentId("P003")
                .setAmount(75.50)
                .setStatus("Refunded")
                .setTransactionCode("TXN003")
                .build();
        System.out.println("Payment 3: " + payment3);

        // Display all collections
        List<Employee> employees = List.of(employee1, employee2, employee3);
        List<User> users = List.of(user1, user2);
        List<Payment> payments = List.of(payment1, payment2, payment3);

        System.out.println("\n=== ALL EMPLOYEES ===");
        employees.forEach(System.out::println);

        System.out.println("\n=== ALL USERS ===");
        users.forEach(System.out::println);

        System.out.println("\n=== ALL PAYMENTS ===");
        payments.forEach(System.out::println);
    }
}
