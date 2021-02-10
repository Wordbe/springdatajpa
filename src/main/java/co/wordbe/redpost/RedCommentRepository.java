package co.wordbe.redpost;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

public interface RedCommentRepository extends JpaRepository<RedComment, Long> {

    @Async
    ListenableFuture<List<RedComment>> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);
}
