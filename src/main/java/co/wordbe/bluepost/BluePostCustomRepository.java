package co.wordbe.bluepost;

import java.util.List;

public interface BluePostCustomRepository<T> {

    List<BluePost> findMyPost();

    void delete(T entity);
}
