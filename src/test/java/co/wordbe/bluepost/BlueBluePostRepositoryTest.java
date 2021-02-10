package co.wordbe.bluepost;

import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(BluePostRepositoryTestConfig.class)
class BlueBluePostRepositoryTest {

    @Autowired
    BluePostRepositoryRed bluePostRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void event() {
        BluePost bluePost = new BluePost();
        bluePost.setTitle("내일 해뜬다.");
        BluePostPublishEvent event = new BluePostPublishEvent(bluePost);

        applicationContext.publishEvent(event);
    }

    @Test
    public void crud() {
        BluePost bluePost = new BluePost();
        bluePost.setTitle("Book Dorsey");
        bluePostRepository.save(bluePost);

        Predicate predicate = QBluePost.bluePost.title.containsIgnoreCase("Dorsey");
        Optional<BluePost> one = bluePostRepository.findOne(predicate);
        assertThat(one).isNotEmpty();

    }
}