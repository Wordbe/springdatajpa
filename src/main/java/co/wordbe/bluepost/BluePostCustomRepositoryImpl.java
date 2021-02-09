package co.wordbe.bluepost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class BluePostCustomRepositoryImpl implements BluePostCustomRepository<BluePost> {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<BluePost> findMyPost() {
        System.out.println("custom findMyPost");
        return entityManager.createQuery("SELECT  p FROM  BluePost AS p", BluePost.class).getResultList();
    }

    @Override
    public void delete(BluePost entity) {
        System.out.println("custom delete");
        entityManager.remove(entity);
    }
}
