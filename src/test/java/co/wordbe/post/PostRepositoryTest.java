package co.wordbe.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void crud() {
        Post post = new Post();
        post.setTitle("설날 연휴 공지");
        Post savedPost = postRepository.save(post); // persist

        Post updatedPost = new Post();
        updatedPost.setId(post.getId());
        updatedPost.setTitle("설날 연휴 공지(수정)");
        Post savedUpdatedPost = postRepository.save(updatedPost);// merge

        savedUpdatedPost.setTitle("변경");

        List<Post> all = postRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitleStartsWith() {
        savePost();

        List<Post> all = postRepository.findByTitleStartsWith("설날");
        assertThat(all.size()).isEqualTo(1);
    }

    private Post savePost() {
        Post post = new Post();
        post.setTitle("설날 연휴 공지");
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    @Test
    public void findByTitle() {
        savePost();

        List<Post> all = postRepository.findByTitle("설날 연휴 공지", JpaSort.unsafe("LENGTH(title)"));
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void updateTitle() {
        Post post = savePost();
        String updatedTitle = "설날 연휴 공지(변경)";
        post.setTitle(updatedTitle);

        List<Post> all = postRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(updatedTitle);
    }
}