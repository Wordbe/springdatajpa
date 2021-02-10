package co.wordbe.blueaccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BlueAccountRepository extends JpaRepository<BlueAccount, Long>, QuerydslPredicateExecutor<BlueAccount> {
}
