package za.ac.cput;

import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.EmployeeFactory;
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

//        List<Employee> employees = new ArrayList<>();
//
//        Employee employee1 = EmployeeFactory.createEmployee(001, "Musa", "Nkosi", "m.n@cput.ac.za", "Software Developer", 35000);
//        Employee employee2 = EmployeeFactory.createEmployee(002, "Sethu", "Msengeni", "s.m@cput.ac.za", "Intern", 5000);
//        Employee employee3 = EmployeeFactory.createEmployee(003, "Ashton", "Petersen", "a.s@cput.ac.za", "Senior Developer", 40000);
//
//        if (employee1 != null) employees.add(employee1);
//        if (employee2 != null) employees.add(employee2);
//        if (employee3 != null) employees.add(employee3);
//
//        System.out.println("List of Employees:");
//        for (Employee emp : employees) {
//            System.out.println(emp);
//        }
    }
}
