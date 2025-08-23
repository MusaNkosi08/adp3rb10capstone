package za.ac.cput.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Supplier;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class SupplierRepository implements ISupplierRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Supplier save(Supplier supplier) {
        if (supplier.getId() == null) {
            entityManager.persist(supplier);
            return supplier;
        } else {
            return entityManager.merge(supplier);
        }
    }

    @Override
    public Optional<Supplier> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Supplier.class, id));
    }

    @Override
    public List<Supplier> findAll() {
        String jpql = "SELECT s FROM Supplier s";
        return entityManager.createQuery(jpql, Supplier.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(this::delete);
    }

    @Override
    public void delete(Supplier supplier) {
        if (!entityManager.contains(supplier)) {
            supplier = entityManager.merge(supplier);
        }
        entityManager.remove(supplier);
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }
}
