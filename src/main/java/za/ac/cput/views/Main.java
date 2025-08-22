package za.ac.cput.views;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.ac.cput.domain.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {


        // Creating an order using
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

        // Creating a list of order items using the builder pattern
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem.Builder().itemId(3).quantity(1).price(20.0).build());
        items.add(new OrderItem.Builder().itemId(4).quantity(3).price(5.0).build());

        // Creating a second order using the builder pattern
        Order order2 = new Order.Builder()
                .orderId(456)
                .customerId(789)
                .shippingAddress("456 Elm St, Othertown")
                .paymentMethod("PayPal")
                .items(items)
                .build();

        System.out.println("\n=== ORDERITEMS ===");
        System.out.println(order2.getOrderDetails());

        // Creating users using the builder pattern (like Order and Supplier)
        System.out.println("\n=== USERS ===");
        User user1 = new User.UserBuilder("54731", "Ameena", "Abrahams", "amennaabrahams@gmail.com", "Password123", "0723787789")
                .build();
        System.out.println("User 1: " + user1);

        User user2 = new User.UserBuilder("54732", "John", "Doe", "john.doe@example.com", "SecurePass456", "0831234567")
                .build();
        System.out.println("User 2: " + user2);

        // Creating employees using the builder pattern
        System.out.println("\n=== EMPLOYEES ===");
        Employee employee1 = new Employee.Builder()
                .setEmployeeID(001L)
                .setFirstName("Musa")
                .setLastName("Nkosi")
                .setEmail("m.n@cput.ac.za")
                .setPosition("Cashier")
                .setSalary(35000)
                .build();
        System.out.println("Employee 1: " + employee1);

        Employee employee2 = new Employee.Builder()
                .setEmployeeID(002L)
                .setFirstName("Siphosethu")
                .setLastName("Msengeni")
                .setEmail("s.m@cput.ac.za")
                .setPosition("Manager")
                .setSalary(50000)
                .build();
        System.out.println("Employee 2: " + employee2);

        Employee employee3 = new Employee.Builder()
                .setEmployeeID(003L)
                .setFirstName("Ashton")
                .setLastName("Petersen")
                .setEmail("a.p@cput.ac.za")
                .setPosition("Sales Assistant")
                .setSalary(28000)
                .build();
        System.out.println("Employee 3: " + employee3);

        // Creating payments using the builder pattern
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

        // Creating a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        // Creating a list of users
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        // Creating a list of payments
        List<Payment> payments = new ArrayList<>();
        payments.add(payment1);
        payments.add(payment2);
        payments.add(payment3);

        // Display all collections
        System.out.println("\n=== ALL EMPLOYEES ===");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        System.out.println("\n=== ALL USERS ===");
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("\n=== ALL PAYMENTS ===");
        for (Payment payment : payments) {
            System.out.println(payment);
        }

    } //EOF Main Run
} //EOF