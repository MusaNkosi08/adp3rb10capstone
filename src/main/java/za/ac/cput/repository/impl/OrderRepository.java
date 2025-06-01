package za.ac.cput.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.IOrderRepository;

import java.util.List;

@Repository
@Transactional
public class OrderRepository implements IOrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order create(Order order) {
        entityManager.persist(order);
        return order;
    }

    @Override
    public Order read(String id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public Order update(Order order) {
        return entityManager.merge(order);
    }

    @Override
    public void delete(String id) {
        Order order = read(id);
        if (order != null) {
            entityManager.remove(order);
        }
    }

    @Override
    public List<Order> findAll() {
        return entityManager.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }

    @Override
    public List<Order> findByCustomerId(String customerId) {
        return entityManager.createQuery("SELECT o FROM Order o WHERE o.customerId = :customerId", Order.class)
                .setParameter("customerId", customerId)
                .getResultList();
    }

    @Override
    public Order getOrder(int orderId) {
        return null;
    }

    @Override
    public List<Order> getOrdersByCustomerId(int customerId) {
        return List.of();
    }

    @Override
    public List<Order> findByStatus(String status) {
        return entityManager.createQuery("SELECT o FROM Order o WHERE o.status = :status", Order.class)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public boolean addOrder(Order order) {
        return false;
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        return false;
    }

    @Override
    public boolean cancelOrder(String orderId) {
        Order order = read(orderId);
        if (order != null) {
            order.setStatus("Cancelled");
            update(order);
            return true;
        }
        return false;
    }

    @Override
    public boolean completeOrder(String orderId) {
        Order order = read(orderId);
        if (order != null) {
            order.setStatus("Completed");
            update(order);
            return true;
        }
        return false;
    }
}
