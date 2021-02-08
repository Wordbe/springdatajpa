package co.wordbe.redpost;

import co.wordbe.redpost.RedPost;
import co.wordbe.redpost.RedPostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RedRedPostRepositoryTest {

    @Autowired
    RedPostRepository redPostRepository;

    @Test
    @Rollback(false)
    public void crudRepository() {
        // Given
        RedPost redPost = new RedPost();
        redPost.setTitle("spring title");

        assertThat(redPost.getId()).isNull();

        // When
        RedPost newRedPost = redPostRepository.save(redPost);

        // Then
        assertThat(newRedPost.getId()).isNotNull();

        // When
        List<RedPost> redPosts = redPostRepository.findAll();

        // Then
        assertThat(redPosts.size()).isEqualTo(1);
        assertThat(redPosts).contains(newRedPost);

        // When
        Page<RedPost> page = redPostRepository.findAll(PageRequest.of(0, 10));

        // Then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        // When
        page = redPostRepository.findByTitleContains("spring", PageRequest.of(0, 10));

        // Then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        // When
        long spring = redPostRepository.countByTitleContains("spring");

        // Then
        assertThat(spring).isEqualTo(1);
    }
}