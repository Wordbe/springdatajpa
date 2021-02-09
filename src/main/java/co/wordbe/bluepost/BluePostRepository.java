package co.wordbe.bluepost;

import co.wordbe.CommonRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BluePostRepository extends CommonRepository<BluePost, Long>, QuerydslPredicateExecutor<BluePost> {
}
