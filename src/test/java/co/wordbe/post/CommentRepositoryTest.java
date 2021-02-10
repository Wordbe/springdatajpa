package co.wordbe.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void getComment() {
        System.out.println("loadCommentById: ");
        commentRepository.getById(1l);
        System.out.println("findById: ");
        commentRepository.findById(1l);
    }
}