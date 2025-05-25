package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.OrderRepository;
import za.ac.cput.service.IOrderService;
import java.util.List;
@Service
public class OrderService implements IOrderService {
    private final OrderRepository repository;
    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }
    @Override
    public Order create(Order order) {
        return repository.save(order);
    }
    @Override
    public Order read(String id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public Order update(Order order) {
        return repository.save(order);
    }
    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }
    @Override
    public Order getOrder(int orderId) {
        return repository.findByOrderId(orderId);
    }
    @Override
    public List<Order> getOrdersByCustomerId(int customerId) {
        return repository.findByCustomerId(customerId);
    }
    @Override
    public List<Order> findByStatus(String status) {
        return repository.findByStatus(status);
    }
}