package co.wordbe.blueaccount;

import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BlueAccountRepositoryTest {

    @Autowired
    BlueAccountRepository blueAccountRepository;

    @Test
    public void crud() {
        Predicate predicate = QBlueAccount.blueAccount.firstName.containsIgnoreCase("Dorsey")
                            .and(QBlueAccount.blueAccount.lastName.startsWith("Jack"));

        Optional<BlueAccount> one = blueAccountRepository.findOne(predicate);
        assertThat(one).isEmpty();
    }
}