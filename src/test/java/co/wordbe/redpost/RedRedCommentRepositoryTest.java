package co.wordbe.redpost;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RedRedCommentRepositoryTest {

    @Autowired
    RedCommentRepository redCommentRepository;

    @Test
    public void crud() throws ExecutionException, InterruptedException {
        // Given
        this.createComment(33, "spring comment1");
        this.createComment(22, "SPRING comment2");
        redCommentRepository.flush();
        List<RedComment> all = redCommentRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "LikeCount"));

        // When
        ListenableFuture<List<RedComment>> future =
                redCommentRepository.findByCommentContainsIgnoreCase("Spring", pageRequest);
        System.out.println("is done?" + future.isDone());

        future.addCallback(new ListenableFutureCallback<List<RedComment>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(throwable);
            }

            @Override
            public void onSuccess(List<RedComment> redComments) {
                System.out.println(" Async 결과 ");
                System.out.println(redComments.size());
            }
        });

        Thread.sleep(5000l);
    }

    private void createComment(int likeCount, String comment) {
        RedComment newRedComment = new RedComment();
        newRedComment.setLikeCount(likeCount);
        newRedComment.setComment(comment);
        redCommentRepository.save(newRedComment);
    }
}