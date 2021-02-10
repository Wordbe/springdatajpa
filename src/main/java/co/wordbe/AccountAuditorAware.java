package co.wordbe;

import co.wordbe.post.Account;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountAuditorAware implements AuditorAware<Account> {

    @Override
    public Optional<Account> getCurrentAuditor() {
        System.out.println("현재 유저를 찾고 있어요.");
        return Optional.empty();
    }
}
