package co.wordbe.post;

import co.wordbe.CommonRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository extends CommonRepository<Post, Long>, QuerydslPredicateExecutor<Post> {
}
