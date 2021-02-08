package co.wordbe.redpost;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedPostRepository extends JpaRepository<RedPost, Long> {

    Page<RedPost> findByTitleContains(String title, Pageable page);
    long countByTitleContains(String title);
}
