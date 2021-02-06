package co.wordbe;

import co.wordbe.post.Jara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @Autowired
    Jara jara;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(jara.getName());
    }
}
