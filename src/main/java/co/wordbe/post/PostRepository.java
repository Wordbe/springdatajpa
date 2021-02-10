package co.wordbe.post;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitleStartsWith(String title);

    @Query(value = "SELECT p FROM #{#entityName} AS p WHERE p.title = ?1")
    List<Post> findByTitle(String title, Sort sort);

    @Query("UPDATE Post p SET p.title = ?1 WHERE p.id = ?2")
    int updateTitle(String title, Long id);

}
