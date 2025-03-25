package za.ac.cput;

import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderFactory;

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
    }
}
