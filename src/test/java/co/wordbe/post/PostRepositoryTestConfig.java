package co.wordbe.post;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostRepositoryTestConfig {
    @Bean
    public ApplicationListener<PostPublishEvent> postListener() {
        return postPublishEvent ->
                System.out.println(postPublishEvent.getPost().getTitle() + " published.");
    }
}
