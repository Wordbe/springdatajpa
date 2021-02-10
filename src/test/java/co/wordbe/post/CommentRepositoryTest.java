package co.wordbe.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static co.wordbe.post.CommentSpecs.isBest;
import static co.wordbe.post.CommentSpecs.isGood;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Test
    public void getComment() {
        Post post = new Post();
        post.setTitle("안녕하세요.");
        Post savedPost = postRepository.save(post);

        Comment comment = new Comment();
        comment.setComment("댓글입니다.");
        comment.setPost(savedPost);
        comment.setUp(5);
        comment.setDown(2);
        commentRepository.save(comment);

        List<Comment> all = commentRepository.findAll();

        assertThat(all.size()).isEqualTo(1);

//        commentRepository.findByPost_Id(savedPost.getId(), CommentSummary.class)
//            .forEach(c -> {
//                System.out.println(c.getVotes());
//            });
//
//        commentRepository.findByPost_Id(savedPost.getId(), CommentOnly.class)
//                .forEach(c -> {
//                    System.out.println(c.getComment());
//                });
    }

    @Test
    public void specs() {
        Page<Comment> page = commentRepository.findAll(isBest().or(isGood()), PageRequest.of(0, 10));
    }

    @Test
    public void qbe() {
        Comment prove = new Comment();
        prove.setBest(true);

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                .withIgnorePaths("up", "down");

        Example<Comment> example = Example.of(prove, exampleMatcher);

        commentRepository.findAll(example);
    }
}