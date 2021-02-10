package co.wordbe;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class RedCommonRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements RedCommonRepository<T, ID> {

    private EntityManager entityManager;

    public RedCommonRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public boolean contains(Object entity) {
        return entityManager.contains(entity);
    }
}
