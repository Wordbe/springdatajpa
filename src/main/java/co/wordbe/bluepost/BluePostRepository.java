package co.wordbe.bluepost;

import co.wordbe.RedCommonRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BluePostRepository extends RedCommonRepository<BluePost, Long>, QuerydslPredicateExecutor<BluePost> {
}
